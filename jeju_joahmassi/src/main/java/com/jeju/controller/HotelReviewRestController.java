package com.jeju.controller;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

import com.jeju.dto.HotelReviewDto;
import com.jeju.dto.HotelReviewUpdateDto;
import com.jeju.dto.RestaurantReviewInsertDto;
import com.jeju.dto.RestaurantReviewUpdateDto;
import com.jeju.entity.Hotel;
import com.jeju.entity.HotelBooking;
import com.jeju.entity.HotelReview;
import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantReview;
import com.jeju.service.HotelBookingService;
import com.jeju.service.HotelReviewService;
import com.jeju.service.HotelService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/hotelReview")
public class HotelReviewRestController {

	@Autowired
	private HotelService hotelService;
	@Autowired
	private HotelReviewService hotelReviewService;
	@Autowired
	private HotelBookingService hotelBookingService;
	
	
	@Operation(summary = "호텔 리뷰 작성")
	@PostMapping("/insert")
	public ResponseEntity<HotelReviewDto> insertReview(@RequestBody HotelReviewDto dto, HttpSession session) {

		List<HotelBooking> hotelBookings = hotelBookingService.findByUserinfoUserNo(dto.getUserNo());
		List<HotelBooking> hotelBookings2 = new ArrayList<HotelBooking>();
		
		for (HotelBooking hotelBooking : hotelBookings) {
			if(hotelBooking.getHotel().getHotelNo() == dto.getHotelNo()) {
				Long day = ChronoUnit.DAYS.between(hotelBooking.getHbCheckout(), LocalDate.now());
				if(day >= 1 && day <= 3) {
					hotelBookings2.add(hotelBooking);
				}
			}
		}
		
		List<HotelReview> findReview = hotelReviewService.findByUserinfoUserNoAndHotelHotelNo(dto.getUserNo(), dto.getHotelNo());
		List<HotelReview> findReview2 = new ArrayList<HotelReview>();
		
		for (HotelReview hotelReview : findReview) {
			if(hotelReview.getHotel().getHotelNo()==dto.getHotelNo()) {
				Long a = ChronoUnit.DAYS.between(hotelReview.getHrDate(), LocalDate.now());
				if(a>=1 && a <=3) {
					findReview2.add(hotelReview);
				}
			}
		}
		
		// 예약갯수 , 리뷰개수.....
		if ((hotelBookings2.size() > 0) && (hotelBookings2.size() > findReview2.size())) {
			// 리뷰쓰기
			HotelReview hotelReview = HotelReviewDto.toEntity(dto);
			hotelReview.setHrDate(LocalDate.now());
			hotelReviewService.insertHr(hotelReview);

			List<HotelReview> hotelReviewList = hotelReviewService.findByHotelHotelNo(dto.getHotelNo());
			Double reviewTotal = 0.0;
			
			for (HotelReview hotelReview2 : hotelReviewList) {
				reviewTotal = reviewTotal + hotelReview2.getHrStar();
			}
			Double reviewTotalStar = reviewTotal / hotelReviewList.size();
			Hotel hotel = hotelService.findByHotelNo(dto.getHotelNo());
			hotel.setHotelStar(reviewTotalStar);
			hotelService.updateHotel(hotel);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

	    return new ResponseEntity<HotelReviewDto>(dto, httpHeaders, HttpStatus.CREATED);
	}
	
	
	@Operation(summary = "호텔 리뷰 수정")
	@PostMapping("/update")
	public ResponseEntity<HotelReviewUpdateDto> update(@RequestBody HotelReviewUpdateDto dto) {
		
		HotelReview find = hotelReviewService.findByHrNo(dto.getHrNo());
		
		if(find != null) {
			if(dto.getHrContent() != null) {
				find.setHrContent(dto.getHrContent());
				hotelReviewService.updateHr(find);
			}
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<HotelReviewUpdateDto>(dto, httpHeaders, HttpStatus.OK);
	}
	
	
	@Operation(summary = "호텔 리뷰 수정 폼")
	@PostMapping("/updateForm")
	public ResponseEntity<HotelReviewUpdateDto> updateFormRestaurantReview(@RequestBody HotelReviewUpdateDto dto) {	
		
		HotelReview findHotelReview = hotelReviewService.findByHrNo(dto.getHrNo());
		HotelReviewUpdateDto findHotelReviewDto = HotelReviewUpdateDto.toDto(findHotelReview);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<HotelReviewUpdateDto>(findHotelReviewDto, httpHeaders, HttpStatus.OK);
	}
	
	
	@Operation(summary = "호텔 리뷰 삭제")
	@DeleteMapping("/delete")
	public ResponseEntity<HotelReviewDto> delete(@RequestBody HotelReviewDto dto) {
		
		hotelReviewService.deleteByHrNo(dto.getHrNo());
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<HotelReviewDto>(dto, httpHeaders, HttpStatus.OK);
	}
}
