package com.jeju.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantBooking;
import com.jeju.entity.Userinfo;

public interface RestaurantBookingRepository extends JpaRepository<RestaurantBooking, Long>{
	
	// 유저의 예약내역 찾기
	public List<RestaurantBooking> findByUserinfoUserNo(Long userNo);
	
	// 해당식당의 유저 예약 찾기
	public List<RestaurantBooking> findByUserinfoUserNoAndRestaurantRestaurantNo(Long userNo,Long restaurantNo);
	
	// 1개의 식당 예약 리스트
	public List<RestaurantBooking> findByRestaurantRestaurantNo(Long restaurantNo);
	
	// 1명 유저의 기간별 예약 내역 찾기
	public List<RestaurantBooking> findByRbDateBetweenAndUserinfoUserNo(LocalDateTime startDateTime,LocalDateTime endDateTime,Long userNo);
	
	// 유저의 예약내역 찾기 페이징
	public Page<RestaurantBooking> findByUserinfoUserNo(Long userNo,Pageable pageable);
	
	// 1개의 식당 예약 리스트 페이징
	public Page<RestaurantBooking> findByRestaurantRestaurantNo(Long restaurantNo,Pageable pageable);
	
	// 1명 유저의 기간별 예약 내역 찾기 페이징
	public Page<RestaurantBooking> findByRbDateBetweenAndUserinfoUserNo(LocalDateTime startDateTime,LocalDateTime endDateTime,Long userNo,Pageable pageable);
}
