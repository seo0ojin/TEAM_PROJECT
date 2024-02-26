package com.jeju.controller;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeju.dto.HotelBookingDto;
import com.jeju.dto.HotelBookingUpdateDto;
import com.jeju.dto.HotelCouponDto;
import com.jeju.entity.Coupon;
import com.jeju.entity.Hotel;
import com.jeju.entity.HotelBooking;
import com.jeju.entity.Userinfo;
import com.jeju.service.CouponService;
import com.jeju.service.HotelBookingService;
import com.jeju.service.HotelService;
import com.jeju.service.PasswordMismatchException;
import com.jeju.service.UserinfoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/hotelBooking")
public class HotelBookingRestController {

	@Autowired
	private HotelBookingService hotelBookingService;
	@Autowired
	private HotelService hotelService;
	@Autowired
	private CouponService couponService;
	@Autowired
	private UserinfoService userinfoService;
	
	@Operation(summary = "호텔 예약하기")
	@PostMapping("/insert")
	public ResponseEntity<HotelBookingDto> insertBooking(@RequestBody HotelBookingDto dto, HttpSession session) {
		
		Long userNo = (Long) session.getAttribute("userNo");
		
		HotelBooking entity = HotelBookingDto.toEntity(dto);
		
		if(userNo != null) {
			Userinfo userinfo = new Userinfo();
			userinfo.setUserNo(userNo);
			entity.setUserinfo(userinfo);
		} else {
			throw new PasswordMismatchException("로그인이 필요한 서비스입니다.");
		}
		
		Hotel hotel = hotelService.findByHotelNo(dto.getHotelNo());
		entity.setHotel(hotel);
		
		hotelBookingService.insertHb(entity);
		
		HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

	    return new ResponseEntity<HotelBookingDto>(dto, httpHeaders, HttpStatus.CREATED);
	}
	
	
	@Operation(summary = "쿠폰 찾기")
	@PostMapping("/findCoupon")
	public ResponseEntity<HotelCouponDto> findCoupon(@RequestBody HotelCouponDto dto, HttpSession session) {

		Long userNo = (Long) session.getAttribute("userNo");

		List<Coupon> couponList = couponService.findAllByUserNo(userNo);

		dto.setCouponStatus(1001);

		for (Coupon coupon : couponList) {
			if (coupon.getCouponName().equals(dto.getCouponName())) {
				dto.setCouponStatus(1000);

				Double discount = dto.getTotalPrice() * ((double) coupon.getCouponDiscount() / 100);

				int discountInteger = discount.intValue();

				dto.setCouponDiscount(discountInteger);
				dto.setTotalPrice(dto.getTotalPrice() - discountInteger);
			}
		}
		
		
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<HotelCouponDto>(dto, httpHeaders, HttpStatus.CREATED);
	}
	
	
	
	
	@Operation(summary = "호텔 예약 번호로 찾기")
	@GetMapping("/{hbNo}")
	public HotelBookingDto findBookingByNo(@PathVariable(name = "hbNo") Long hbNo) {
		
		HotelBooking find = hotelBookingService.findByHbNo(hbNo);
		
		HotelBookingDto bookingDto = HotelBookingDto.toDto(find);
		
		return bookingDto;
	}
	
	
	@Operation(summary = "호텔 예약 수정")
	@PutMapping("/update/{hbNo}")
	public ResponseEntity<HotelBookingUpdateDto> update(@PathVariable(name = "hbNo") Long hbNo, @RequestBody HotelBookingUpdateDto dto) {
		
		HotelBooking find = hotelBookingService.findByHbNo(hbNo);
		
		if(find != null) {
			if(dto.getHbCheckin() != null) {
				find.setHbCheckin(dto.getHbCheckin());
			}
			if(dto.getHbCheckout() != null) {
				find.setHbCheckout(dto.getHbCheckout());
			}
			if(dto.getHbPersons() != null) {
				find.setHbPersons(dto.getHbPersons());
			}
			if(dto.getHbPhone() != null) {
				find.setHbPhone(dto.getHbPhone());
			}
			if(dto.getHbPrice() != null) {
				find.setHbPrice(dto.getHbPrice());
			}
			hotelBookingService.updateHb(find);
			return new ResponseEntity<HotelBookingUpdateDto>(HotelBookingUpdateDto.toDto(find), HttpStatus.OK);
		} else {
			return new ResponseEntity<HotelBookingUpdateDto>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@Operation(summary = "호텔 예약 삭제")
	@DeleteMapping("/delete")
	public void delete(@RequestBody HotelBookingDto dto, HttpSession session) {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		HotelBooking findBooking = hotelBookingService.findByHbNo(dto.getHbNo());
		Long findUserNo = findBooking.getUserinfo().getUserNo();
		Long loginUserNo = (Long) session.getAttribute("userNo");
		
		if (findUserNo.equals(loginUserNo)) {
			hotelBookingService.deleteByhbNo(dto.getHbNo());
		
		}
	}
	
	
	@Operation(summary = "호텔 예약 내역 기간별 조회")
	@GetMapping("/{hbCheckin}/{hbCheckout}")
	public  ResponseEntity<List<HotelBookingDto>> findAllByBookingDate(@PathVariable(name = "hbCheckin") LocalDate hbCheckin, @PathVariable(name = "hbCheckout") LocalDate hbCheckout, HttpSession session) {
		
		Long userNo = (Long) session.getAttribute("userNo");
		
		List<HotelBooking> bookingList = hotelBookingService.findByHbCheckinBetweenAndUserinfoUserNo(hbCheckin, hbCheckout, userNo);
		List<HotelBookingDto> bookingDto = new ArrayList<HotelBookingDto>();
		
		for (HotelBooking bookings : bookingList) {
			HotelBookingDto bookingsDto = HotelBookingDto.toDto(bookings);
			bookingDto.add(bookingsDto);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<HotelBookingDto>>(bookingDto, httpHeaders, HttpStatus.OK);
	}
	
	@Operation(summary = "중복 체크")
	@PostMapping("/duplicate")
	public ResponseEntity<HotelBookingDto> duplication(@RequestBody HotelBookingDto dto, HttpSession session) {
		Hotel hotel = hotelService.findByHotelNo(dto.getHotelNo());

		Long userNo = (Long) session.getAttribute("userNo");
		Userinfo userinfo = userinfoService.findByUserNo(userNo);

		String hotelName = hotel.getHotelName();
		String hotelLocal = hotel.getHotelLocal();

		// 문자열을 "-"를 기준으로 나누기
		String[] dateParts = dto.getBookingDate().split(" - ");

		// 나뉜 부분을 각각의 변수에 저장
		String bookingCheckin = dateParts[0];
		String bookingCheckout = dateParts[1];

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate checkin = LocalDate.parse(bookingCheckin, formatter);
		LocalDate checkout = LocalDate.parse(bookingCheckout, formatter);

		Integer realPeople = Integer.parseInt(dto.getPeople().replaceAll("[^0-9]", ""));

		HotelBooking hotelBooking = new HotelBooking();
		hotelBooking.setHotel(hotel);
		hotelBooking.setHbPhone(userinfo.getUserPhone());
		hotelBooking.setHbPersons(realPeople);
		hotelBooking.setHbName(dto.getHbName());
		hotelBooking.setHbCheckin(checkin);
		hotelBooking.setHbCheckout(checkout);
		hotelBooking.setUserinfo(userinfo);
		hotelBooking.setHbPrice(dto.getHbPrice());

		/*********************** 중복체크 *****************************/
		List<HotelBooking> bookingList = hotelBookingService.findByHotelHotelNo(dto.getHotelNo());

		boolean insert = true;
		for (HotelBooking booking : bookingList) {
			LocalDate hotelCheckin = booking.getHbCheckin();
			LocalDate hotelCheckout = booking.getHbCheckout();

			if (hotelCheckin.getDayOfYear() == hotelBooking.getHbCheckin().getDayOfYear()
					&& hotelCheckin.getMonth() == hotelBooking.getHbCheckin().getMonth()) {
				if (hotelCheckin.getDayOfMonth() <= hotelBooking.getHbCheckin().getDayOfMonth()
						|| hotelCheckout.getDayOfMonth() >= hotelBooking.getHbCheckin().getDayOfMonth()) {
					insert = false;
					dto.setStatus(1001);
				}
			}
		}
		if (insert == true) {
			//hotelBookingService.insertHb(hotelBooking);
			dto.setStatus(1000);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<HotelBookingDto>(dto, httpHeaders, HttpStatus.OK);
	}
}
