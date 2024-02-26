package com.jeju.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantBooking;
import com.jeju.entity.Userinfo;

public interface RestaurantBookingService {
		// 식당 예약하기
		public RestaurantBooking insert(RestaurantBooking restaurantBooking);
		
		// 식당 예약 번호로 삭제
		public void deleteByNo(Long rbNo);
		
		// 식당 예약 수정
		public void update(RestaurantBooking restaurantBooking);
		
		// 해당식당의 유저 예약 찾기
		public List<RestaurantBooking> findByUserinfoUserNoAndRestaurantRestaurantNo(Long userNo,Long restaurantNo);
		
		// 1명 유저의 식당 예약내역
		public List<RestaurantBooking> findByUserinfoUserNo(Long userNo);
		
		// 모든 식당 예약 리스트
		public List<RestaurantBooking> findAll();
		
		// 식당 예약번호로 1개 찾기
		public RestaurantBooking findByNo(Long rbNo);
		
		// 1개의 식당 예약 리스트
		public List<RestaurantBooking> findByRestaurantRestaurantNo(Long restaurantNo);
		
		// 유저의 예약내역 찾기 페이징
		public Page<RestaurantBooking> findByUserinfoUserNo(Long userNo,Pageable pageable);
		
		// 1개의 식당 예약 리스트 페이징
		public Page<RestaurantBooking> findByRestaurantRestaurantNo(Long restaurantNo,Pageable pageable);
		
		// 1명 유저의 기간별 예약 내역 찾기
		public List<RestaurantBooking> findByRbDateBetweenAndUserinfoUserNo(LocalDateTime startDateTime,LocalDateTime endDateTime,Long userNo);
		
		// 1명 유저의 기간별 예약 내역 찾기 페이징
		public Page<RestaurantBooking> findByRbDateBetweenAndUserinfoUserNo(LocalDateTime startDateTime,LocalDateTime endDateTime,Long userNo,Pageable pageable);
}
