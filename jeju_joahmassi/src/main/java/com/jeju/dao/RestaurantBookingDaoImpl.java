package com.jeju.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantBooking;
import com.jeju.entity.Userinfo;
import com.jeju.repository.RestaurantBookingRepository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RestaurantBookingDaoImpl implements RestaurantBookingDao{
	
	@Autowired
	private RestaurantBookingRepository restaurantBookingRepository;
	
	// 식당 예약하기
	@Override
	public RestaurantBooking insert(RestaurantBooking restaurantBooking) {
		return restaurantBookingRepository.save(restaurantBooking);
	}
	
	// 식당 예약 번호로 삭제
	@Override
	public void deleteByNo(Long rbNo) {
		restaurantBookingRepository.deleteById(rbNo);
	}
	
	// 식당 예약 수정
	@Override
	public void update(RestaurantBooking restaurantBooking) {
		restaurantBookingRepository.save(restaurantBooking);
	}
	
	// 1명 유저의 식당 예약내역
	@Override
	public List<RestaurantBooking> findByUserinfoUserNo(Long userNo) {
		return restaurantBookingRepository.findByUserinfoUserNo(userNo);
	}
	
	// 모든 식당 예약 리스트
	@Override
	public List<RestaurantBooking> findAll() {
		return restaurantBookingRepository.findAll();
	}
	
	// 식당 예약번호로 1개 찾기
	@Override
	public RestaurantBooking findByNo(Long rbNo) {
		return restaurantBookingRepository.findById(rbNo).get();
	}
	
	// 1개의 식당 예약 리스트
	@Override
	public List<RestaurantBooking> findByRestaurantRestaurantNo(Long restaurantNo) {
		return restaurantBookingRepository.findByRestaurantRestaurantNo(restaurantNo);
	}
	
	// 유저의 예약내역 찾기 페이징
	@Override
	public Page<RestaurantBooking> findByUserinfoUserNo(Long userNo, Pageable pageable) {
		return restaurantBookingRepository.findByUserinfoUserNo(userNo, pageable);
	}
	
	// 1개의 식당 예약 리스트 페이징
	@Override
	public Page<RestaurantBooking> findByRestaurantRestaurantNo(Long restaurantNo,Pageable pageable) {
		return restaurantBookingRepository.findByRestaurantRestaurantNo(restaurantNo, pageable);
	}
	
	// 1명 유저의 기간별 예약 내역 찾기
	@Override
	public List<RestaurantBooking> findByRbDateBetweenAndUserinfoUserNo(LocalDateTime startDateTime, LocalDateTime endDateTime,Long userNo) {
		return restaurantBookingRepository.findByRbDateBetweenAndUserinfoUserNo(startDateTime, endDateTime, userNo);
	}
	
	// 1명 유저의 기간별 예약 내역 찾기 페이징
	@Override
	public Page<RestaurantBooking> findByRbDateBetweenAndUserinfoUserNo(LocalDateTime startDateTime,
			LocalDateTime endDateTime, Long userNo, Pageable pageable) {
		return restaurantBookingRepository.findByRbDateBetweenAndUserinfoUserNo(startDateTime, endDateTime, userNo, pageable);
	}

	@Override
	public List<RestaurantBooking> findByUserinfoUserNoAndRestaurantRestaurantNo(Long userNo, Long restaurantNo) {
		return restaurantBookingRepository.findByUserinfoUserNoAndRestaurantRestaurantNo(userNo,restaurantNo);
	}
	
	
}
