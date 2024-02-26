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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeju.dto.AttractionReviewDto;
import com.jeju.dto.RestaurantInsertDto;
import com.jeju.dto.RestaurantReviewDeleteDto;
import com.jeju.dto.RestaurantReviewInsertDto;
import com.jeju.dto.RestaurantReviewUpdateDto;
import com.jeju.entity.AttractionReview;
import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantBooking;
import com.jeju.entity.RestaurantReview;
import com.jeju.service.RestaurantBookingService;
import com.jeju.service.RestaurantReviewService;
import com.jeju.service.RestaurantService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/restaurantReview")
public class RestaurantReviewRestController {
	@Autowired
	private RestaurantReviewService restaurantReviewService;
	@Autowired
	private RestaurantBookingService restaurantBookingService;
	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/insert")
	public ResponseEntity<RestaurantReviewInsertDto> insert(@RequestBody RestaurantReviewInsertDto dto, HttpSession session) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		List<RestaurantBooking> restaurantBookings = restaurantBookingService.findByUserinfoUserNo(dto.getUserNo());
		List<RestaurantBooking> restaurantBookings2 = new ArrayList<RestaurantBooking>();
		
		for (RestaurantBooking restaurantBooking : restaurantBookings) {
			if(restaurantBooking.getRestaurant().getRestaurantNo()==dto.getRestaurantNo()) {
				Long a = ChronoUnit.DAYS.between(restaurantBooking.getRbDate(), LocalDate.now());
				if(a>=1 && a <=3) {
					restaurantBookings2.add(restaurantBooking);
				}
			}
		}
		List<RestaurantReview> findReviews = 
				restaurantReviewService.findByUserinfoUserNoAndRestaurantRestaurantNo(dto.getUserNo(), dto.getRestaurantNo());
		List<RestaurantReview> findReviews2 = new ArrayList<RestaurantReview>();
		
		for (RestaurantReview restaurantReview : findReviews) {
			if(restaurantReview.getRestaurant().getRestaurantNo()==dto.getRestaurantNo()) {
				Long a = ChronoUnit.DAYS.between(restaurantReview.getRrDate(), LocalDate.now());
				if(a>=1 && a <=3) {
					findReviews2.add(restaurantReview);
				}
			}
		}
		
		// 예약갯수 , 리뷰개수.....
		if( (restaurantBookings2.size() > 0) && (restaurantBookings2.size() > findReviews2.size())) {
			// 리뷰쓰기
			RestaurantReview restaurantReview = RestaurantReviewInsertDto.toEntity(dto);
			restaurantReview.setRrDate(LocalDate.now());
			restaurantReviewService.insert(restaurantReview);
			
			List<RestaurantReview> restaurantReviewList = restaurantReviewService.findByRestaurantRestaurantNo(dto.getRestaurantNo());
			Double reviewTotal = 0.0;
			
			for (RestaurantReview restaurantReview2 : restaurantReviewList) {
				reviewTotal = reviewTotal + restaurantReview2.getRrStar();
			}
			Double reviewTotalStar = reviewTotal / restaurantReviewList.size();
			Restaurant retaurant = restaurantService.findByNo(dto.getRestaurantNo());
			reviewTotalStar = Math.round(reviewTotalStar * 10.0) / 10.0;
			retaurant.setRestaurantStar(reviewTotalStar);
			restaurantService.update(retaurant);
		}
		
		return new ResponseEntity<RestaurantReviewInsertDto>(dto, httpHeaders, HttpStatus.CREATED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<RestaurantReviewUpdateDto> update(@RequestBody RestaurantReviewUpdateDto dto) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		RestaurantReview restaurantReview = restaurantReviewService.findByNo(dto.getRrNo());
		
		if(restaurantReview!=null) {
			restaurantReview.setRrContent(dto.getRrContent());
			restaurantReviewService.update(restaurantReview);
		}
		return new ResponseEntity<RestaurantReviewUpdateDto>(dto, httpHeaders, HttpStatus.OK);
	}
	
	@Operation(summary = "식당 리뷰 수정 폼")
	@PostMapping("/updateForm")
	public ResponseEntity<RestaurantReviewUpdateDto> updateFormRestaurantReview(@RequestBody RestaurantReviewUpdateDto dto) {		
		RestaurantReview findRestaurantReview = restaurantReviewService.findByNo(dto.getRrNo());
		RestaurantReviewUpdateDto findRestaurantReviewDto = RestaurantReviewUpdateDto.toDto(findRestaurantReview);
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>" + findRestaurantReviewDto);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<RestaurantReviewUpdateDto>(findRestaurantReviewDto, httpHeaders, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<RestaurantReviewDeleteDto> delete(@RequestBody RestaurantReviewDeleteDto dto) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		restaurantReviewService.deleteByNo(dto.getRrNo());
		
		return new ResponseEntity<RestaurantReviewDeleteDto>(dto, httpHeaders, HttpStatus.OK);
	}
	
}
