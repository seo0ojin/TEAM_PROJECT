package com.jeju.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jeju.entity.HotelBooking;

public interface HotelBookingService {
	
	// 호텔 예약 
	HotelBooking insertHb(HotelBooking booking);
		
	// 호텔 예약 취소
	void deleteByhbNo(Long hbNo);
		
	// 호텔 예약 수정
	HotelBooking updateHb(HotelBooking updateHb);
		
	// 호텔 예약 찾기
	HotelBooking findByHbNo(Long hbNo);
		
	// 호텔 예약내역 전부 확인
	List<HotelBooking> findAll();
		
	// 내 호텔 예약내역 리스트 확인
	Page<HotelBooking> findByUserinfoUserNo(Long userNo, Pageable pageable);
	List<HotelBooking> findByUserinfoUserNo(Long userNo);

	// 호텔에 따른 모든 예약내역 리스트
	Page<HotelBooking> findByHotelHotelNo(Long hotelNo, Pageable pageable);
	List<HotelBooking> findByHotelHotelNo(Long hotelNo);

	// 기간별 내 예약내역 조회
	Page<HotelBooking> findByHbCheckinBetweenAndUserinfoUserNo(LocalDate hbCheckin, LocalDate hbCheckout, Long userNo, Pageable pageable);
	List<HotelBooking> findByHbCheckinBetweenAndUserinfoUserNo(LocalDate hbCheckin, LocalDate hbCheckout, Long userNo);
	// 호텔 예약 페이징
	Page<HotelBooking> hbFindAllPage(Pageable pageable);

}
