package com.jeju.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jeju.entity.HotelBooking;

public interface HotelBookingRepository extends JpaRepository<HotelBooking, Long>{

	// 내 호텔 예약내역 리스트 확인
	Page<HotelBooking> findByUserinfoUserNo(Long userNo, Pageable pageable);
	List<HotelBooking> findByUserinfoUserNo(Long userNo);
	
	// 호텔에 따른 모든 예약내역 리스트
	Page<HotelBooking> findByHotelHotelNo(Long hotelNo, Pageable pageable);
	List<HotelBooking> findByHotelHotelNo(Long hotelNo);
	
	// 기간별 내 예약내역 조회
	Page<HotelBooking> findByHbCheckinBetweenAndUserinfoUserNo(LocalDate hbCheckin, LocalDate hbCheckout, Long userNo, Pageable pageable);
	List<HotelBooking> findByHbCheckinBetweenAndUserinfoUserNo(LocalDate hbCheckin, LocalDate hbCheckout, Long userNo);
}
