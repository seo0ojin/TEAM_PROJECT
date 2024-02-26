package com.jeju.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeju.entity.Coupon;
import com.jeju.entity.Hotel;
import com.jeju.entity.HotelBooking;
import com.jeju.entity.HotelImage;
import com.jeju.entity.Userinfo;
import com.jeju.service.CouponService;
import com.jeju.service.HotelBookingService;
import com.jeju.service.HotelImageService;
import com.jeju.service.HotelService;
import com.jeju.service.UserinfoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HotelBookingController {
	
	@Autowired
	private HotelService hotelService;
	@Autowired
	private HotelImageService hotelImageService;
	@Autowired
	private UserinfoService userinfoService;
	@Autowired
	private HotelBookingService hotelBookingService;
	@Autowired
	private CouponService couponService;
		
	@GetMapping("/hotelBooking1")
	public String hotelBooking(@RequestParam(name = "bookingDate") String bookingDate,
							   @RequestParam(name = "people") String people,
							   @RequestParam(name = "hotelNo") Long hotelNo, 
							   @RequestParam(name = "bookingTotalPrice") String bookingTotalPrice, Model model, HttpSession session) {
		
		// 문자열을 "-"를 기준으로 나누기
		String[] dateParts = bookingDate.split(" - ");

		// 나뉜 부분을 각각의 변수에 저장
		String bookingCheckin = dateParts[0];
		String bookingCheckout = dateParts[1];
		
		Hotel hotel = hotelService.findByHotelNo(hotelNo);
		
		Long userNo = (Long) session.getAttribute("userNo");
		Userinfo userinfo = userinfoService.findByUserNo(userNo);
		
		String hotelName = hotel.getHotelName();
		String hotelLocal = hotel.getHotelLocal();
		
		List<HotelImage> imageList = hotelImageService.findByHotelHotelNo(hotelNo);
		
		model.addAttribute("bookingCheckin", bookingCheckin);
		model.addAttribute("bookingCheckout", bookingCheckout);
		model.addAttribute("people", people);
		model.addAttribute("hotelName", hotelName);
		model.addAttribute("hotelLocal", hotelLocal);
		model.addAttribute("imageList", imageList);
		model.addAttribute("userinfo", userinfo);
		model.addAttribute("hotelNo", hotelNo);
		model.addAttribute("bookingTotalPrice", bookingTotalPrice);
		
		return "html/hotels/hotel-booking1";
	}
	
	@GetMapping("/hotelBooking2")
	public String hotelBooking2(@RequestParam(name = "inputNameHotelBooking") String inputNameHotelBooking,
								@RequestParam(name = "inputPhoneHotelBooking") String inputPhoneHotelBooking,
								@RequestParam(name = "inputHotelBookingCheckin") String bookingCheckin,
								@RequestParam(name = "inputHotelBookingCheckout") String bookingCheckout,
								@RequestParam(name = "inputHotelBookingPeople") String people,
								@RequestParam(name = "couponName") String couponName,
								@RequestParam(name = "hotelNo") Long hotelNo,
								@RequestParam(name = "totalPrice") Integer totalPrice, Model model , HttpSession session) {
		
		Hotel hotel = hotelService.findByHotelNo(hotelNo);

		Long userNo = (Long) session.getAttribute("userNo");
		Userinfo userinfo = userinfoService.findByUserNo(userNo);

		String hotelName = hotel.getHotelName();
		String hotelLocal = hotel.getHotelLocal();

		List<HotelImage> imageList = hotelImageService.findByHotelHotelNo(hotelNo);

		model.addAttribute("inputNameHotelBooking", inputNameHotelBooking);
		model.addAttribute("inputPhoneHotelBooking", inputPhoneHotelBooking);
		model.addAttribute("bookingCheckin", bookingCheckin);
		model.addAttribute("bookingCheckout", bookingCheckout);
		model.addAttribute("people", people);
		model.addAttribute("hotelNo", hotelNo);
		model.addAttribute("userinfo", userinfo);
		model.addAttribute("imageList", imageList);
		model.addAttribute("hotelName", hotelName);
		model.addAttribute("hotelLocal", hotelLocal);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("couponName", couponName);
		
		return "html/hotels/hotel-booking2";
	}
	
	@GetMapping("/hotelBooking3")
	public String hotelBooking3(@RequestParam(name = "inputNameHotelBooking") String inputNameHotelBooking,
			@RequestParam(name = "inputPhoneHotelBooking") String inputPhoneHotelBooking,
			@RequestParam(name = "inputHotelBookingDate") String inputHotelBookingDate,
			@RequestParam(name = "inputHotelBookingPeople") String people,
			@RequestParam(name = "couponName") String couponName,
			@RequestParam(name = "hotelNo") Long hotelNo,
			@RequestParam(name = "totalPrice") String totalPrice, Model model , HttpSession session) {
		
		Hotel hotel = hotelService.findByHotelNo(hotelNo);
		
		Long userNo = (Long) session.getAttribute("userNo");
		Userinfo userinfo = userinfoService.findByUserNo(userNo);
		
		String hotelName = hotel.getHotelName();
		String hotelLocal = hotel.getHotelLocal();
		
		// 문자열을 "-"를 기준으로 나누기
		String[] dateParts = inputHotelBookingDate.split("-");

		// 나뉜 부분을 각각의 변수에 저장
		String bookingCheckin = dateParts[0];
		String bookingCheckout = dateParts[1];
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate checkin = LocalDate.parse(bookingCheckin, formatter);
        LocalDate checkout = LocalDate.parse(bookingCheckout, formatter);
        
        Integer realPeople = Integer.parseInt(people.replaceAll("[^0-9]", ""));
		
		HotelBooking hotelBooking = new HotelBooking();
		hotelBooking.setHotel(hotel);
		hotelBooking.setHbPhone(inputPhoneHotelBooking);
		hotelBooking.setHbPersons(realPeople);
		hotelBooking.setHbName(inputNameHotelBooking);
		hotelBooking.setHbCheckin(checkin);
		hotelBooking.setHbCheckout(checkout);
		hotelBooking.setUserinfo(userinfo);
		hotelBooking.setHbPrice(Integer.parseInt(totalPrice));
		
		/*********************** 중복체크 *****************************/
		List<HotelBooking> bookingList = hotelBookingService.findByHotelHotelNo(hotelNo);
		
		boolean insert = true;
		for (HotelBooking booking : bookingList) {
			LocalDate hotelCheckin = booking.getHbCheckin();
			LocalDate hotelCheckout = booking.getHbCheckout();
			
			if (hotelCheckin.getDayOfYear() == hotelBooking.getHbCheckin().getDayOfYear() && hotelCheckin.getMonth() == hotelBooking.getHbCheckin().getMonth()) {
				if (hotelCheckin.getDayOfMonth() <= hotelBooking.getHbCheckin().getDayOfMonth() || hotelCheckout.getDayOfMonth() >= hotelBooking.getHbCheckin().getDayOfMonth()) {
					insert = false;
				}
			}
		}
		if (insert == true) {
			List<Coupon> findCouponList = couponService.findAllByUserNo(userNo);
			for (Coupon coupon : findCouponList) {
				if(coupon.getCouponName().equals(couponName)) {
					couponService.deleteByCouponNo(coupon.getCouponNo());
				}
			}
			hotelBookingService.insertHb(hotelBooking);
		}
		
		model.addAttribute("inputNameHotelBooking", inputNameHotelBooking);
		model.addAttribute("inputPhoneHotelBooking", inputPhoneHotelBooking);
		model.addAttribute("inputHotelBookingDate", inputHotelBookingDate);
		model.addAttribute("people", people);
		model.addAttribute("hotelNo", hotelNo);
		model.addAttribute("userinfo", userinfo);
		model.addAttribute("hotelName", hotelName);
		model.addAttribute("hotelLocal", hotelLocal);
		model.addAttribute("totalPrice", totalPrice);
		
		return "html/hotels/hotel-booking3";
	}
	
}
