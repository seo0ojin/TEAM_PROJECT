package com.jeju.controller;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeju.dto.UserUpdateDto;
import com.jeju.dto.UserWriteActionDto;
import com.jeju.entity.AttractionReview;
import com.jeju.entity.Coupon;
import com.jeju.entity.HotelBooking;
import com.jeju.entity.HotelQnA;
import com.jeju.entity.HotelReview;
import com.jeju.entity.RestaurantBooking;
import com.jeju.entity.RestaurantReview;
import com.jeju.entity.Userinfo;
import com.jeju.entity.Wish;
import com.jeju.service.AttractionReviewService;
import com.jeju.service.CouponService;
import com.jeju.service.HotelBookingService;
import com.jeju.service.HotelQnAService;
import com.jeju.service.HotelReviewService;
import com.jeju.service.RestaurantBookingService;
import com.jeju.service.RestaurantReviewService;
import com.jeju.service.UserinfoService;
import com.jeju.service.WishService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserinfoController {

	@Autowired
	private UserinfoService userinfoService;
	@Autowired
	private WishService wishService;
	@Autowired
	private CouponService couponService;
	@Autowired
	private HotelBookingService hotelBookingService;
	@Autowired
	private RestaurantBookingService restaurantBookingService;
	@Autowired
	private HotelReviewService hotelReviewService;
	@Autowired
	private RestaurantReviewService restaurantReviewService;
	@Autowired
	private AttractionReviewService attractionReviewService;
	@Autowired
	private HotelQnAService hotelQnAService;
	
	// 회원 전체 목록
	@GetMapping("/userList")
	public String userList(Model model) {
		
		List<Userinfo> userList = userinfoService.findAll();
		
		model.addAttribute("userList", userList);
		
		return null;
	}
	
	// 회원 상세 정보
	@GetMapping("/userInfo")
	public String userView(Model model, HttpSession session) throws Exception {
		
		Long userNo = (Long) session.getAttribute("userNo");
		
		if (userNo == null) {
			throw new Exception("로그인을 해주세요.");
		}
		
		Userinfo userinfo = userinfoService.findByUserNo(userNo);
		
		List<Coupon> couponList = couponService.findAllByUserNo(userNo);
		
		List<HotelBooking> hotelBookingList = hotelBookingService.findByUserinfoUserNo(userNo);
		Collections.sort(hotelBookingList, Comparator.<HotelBooking, LocalDate>comparing(hotel -> hotel.getHbCheckin()).reversed());
		
		List<RestaurantBooking> restaurantBookingList = restaurantBookingService.findByUserinfoUserNo(userNo);
		Collections.sort(restaurantBookingList, Comparator.<RestaurantBooking, LocalDate>comparing(restaurant -> restaurant.getRbDate()).reversed());
 		
		model.addAttribute("userinfo", userinfo);
		model.addAttribute("couponList", couponList);
		model.addAttribute("hotelBookingList", hotelBookingList);
		model.addAttribute("restaurantBookingList", restaurantBookingList);
		
		return "html/home/my-account";
	}
	
	// 회원가입
	@PostMapping("/userWrite")
	@Operation(summary = "회원가입")
	public String userCreate(@RequestBody UserWriteActionDto dto) throws Exception {
		
		dto.setUserPoint(0);
		
		Userinfo createUser = userinfoService.createUser(UserWriteActionDto.toEntity(dto));
		
		Coupon coupon = Coupon.builder()
				.couponName("가입축하쿠폰")
				.couponDiscount(10)
				.userinfo(createUser)
				.build();
		coupon.setCouponDate(30L);
		
		coupon = couponService.createCoupon(coupon);
		
		
		return "html/home/home-v3";
	}
	
	/*
	// 회원 정보 수정
	@PostMapping("/userUpdate")
	public String userUpdate(Model model, HttpSession session, UserUpdateDto dto) {
		
		Long userNo = (Long) session.getAttribute("userNo");
		
		Userinfo userinfo = userinfoService.findByUserNo(userNo);
		
		if (dto.getUserPassword() != "" && dto.getUserPassword() != null) {
			userinfo.setUserPassword(dto.getUserPassword());
		}

		userinfo.setUserEmail(dto.getUserEmail());
		userinfo.setUserPhone(dto.getUserPhone());
		userinfoService.updateUser(userinfo);
		
		model.addAttribute("userinfo", userinfo);
		
		return "html/home/my-account";
	}
	*/
	
	// 회원 탈퇴
	@GetMapping("/userDelete")
	public String userDelete(HttpSession session) {
		Long userNo = (Long) session.getAttribute("userNo");
		
		List<Wish> wishList = wishService.findAllWishByUserNo(userNo);
		for (Wish wish : wishList) {
			wishService.deleteWish(wish.getWishNo());
		}
		
		List<Coupon> couponList = couponService.findAllByUserNo(userNo);
		for (Coupon coupon : couponList) {
			couponService.deleteByCouponNo(coupon.getCouponNo());
		}
		
		List<HotelBooking> hotelBookingList = hotelBookingService.findByUserinfoUserNo(userNo);
		for (HotelBooking hotelBooking : hotelBookingList) {
			hotelBookingService.deleteByhbNo(hotelBooking.getHbNo());
		}
		
		List<RestaurantBooking> restaurantBookingList = restaurantBookingService.findByUserinfoUserNo(userNo);
		for (RestaurantBooking restaurantBooking : restaurantBookingList) {
			restaurantBookingService.deleteByNo(restaurantBooking.getRbNo());
		}
		
		List<HotelReview> hotelReviewList = hotelReviewService.findByUserinfoUserNo(userNo);
		for (HotelReview hotelReview : hotelReviewList) {
			hotelReviewService.deleteByHrNo(hotelReview.getHrNo());
		}
		
		List<RestaurantReview> restaurantReviewList = restaurantReviewService.findByUserinfoUserNo(userNo);
		for (RestaurantReview restaurantReview : restaurantReviewList) {
			restaurantReviewService.deleteByNo(restaurantReview.getRrNo());
		}
		
		List<AttractionReview> attractionReviewList = attractionReviewService.findByUserinfoUserNo(userNo);
		for (AttractionReview attractionReview : attractionReviewList) {
			attractionReviewService.deleteByArNo(attractionReview.getArNo());
		}
		
		List<HotelQnA> hotelQnaList = hotelQnAService.findByUserinfoUserNo(userNo);
		for (HotelQnA hotelQnA : hotelQnaList) {
			hotelQnAService.deleteByQnANo(hotelQnA.getQnaNo());
		}
		
		userinfoService.deleteUserByNo(userNo);
		session.invalidate();
		
		return "html/home/home-v3";
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("/userDeletePopUp")
	public String userDeletePopUp() {
		
		return "html/home/userDeletePopUp";
	}
	
	@GetMapping(value = "/hotelBookingDeletePopUp", params = "hbNo")
	public String hotelBookingDeletePopUp(@RequestParam Long hbNo, Model model) {
		model.addAttribute("hbNo", hbNo);
		
		return "html/hotels/hotelBookingDeletePopUp";
	}
	
	@GetMapping(value = "/restaurantBookingDeletePopUp", params = "rbNo")
	public String restaurantBookingDeletePopUp(@RequestParam Long rbNo, Model model) {
		model.addAttribute("rbNo", rbNo);
		
		return "html/restaurant/restaurantBookingDeletePopUp";
	}
}
