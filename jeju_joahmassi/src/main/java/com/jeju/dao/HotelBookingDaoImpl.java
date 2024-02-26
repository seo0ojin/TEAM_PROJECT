package com.jeju.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.jeju.entity.HotelBooking;
import com.jeju.repository.HotelBookingRepository;

@Repository
public class HotelBookingDaoImpl implements HotelBookingDao{

	@Autowired
	private HotelBookingRepository hotelBookingRepository;
	
	@Override
	// 호텔 예약
	public HotelBooking insertHb(HotelBooking booking) {
		return hotelBookingRepository.save(booking);
	}

	@Override
	// 호텔 예약 취소
	public void deleteByhbNo(Long hbNo) {
		hotelBookingRepository.deleteById(hbNo);
	}

	@Override
	// 호텔 예약 수정
	public HotelBooking updateHb(HotelBooking updateHb) {
		return hotelBookingRepository.save(updateHb);
	}

	@Override
	// 호텔 예약내역 찾기
	public HotelBooking findByHbNo(Long hbNo) {
		return hotelBookingRepository.findById(hbNo).get();
	}

	@Override
	// 모든 호텔 예약내역 전부 확인 (관리자)
	public List<HotelBooking> findAll() {
		return hotelBookingRepository.findAll();
	}

	@Override
	// 내 호텔 예약내역 리스트 확인
	public Page<HotelBooking> findByUserinfoUserNo(Long userNo, Pageable pageable) {
		return hotelBookingRepository.findByUserinfoUserNo(userNo, pageable);
	}
	
	@Override
	// 기간별 내 예약내역 조회
	public Page<HotelBooking> findByHbCheckinBetweenAndUserinfoUserNo(LocalDate hbCheckin, LocalDate hbCheckout, Long userNo, Pageable pageable) {
		return hotelBookingRepository.findByHbCheckinBetweenAndUserinfoUserNo(hbCheckin, hbCheckout, userNo, pageable);
	}
	
	@Override
	// 호텔에 따른 모든 예약내역 리스트 (관리자)
	public  Page<HotelBooking> findByHotelHotelNo(Long hotelNo, Pageable pageable) {
		return hotelBookingRepository.findByHotelHotelNo(hotelNo, pageable);
	}
	
	
	@Override
	public Page<HotelBooking> hbFindAllPage(Pageable pageable) {
		Page<HotelBooking> hbList = hotelBookingRepository.findAll(pageable);
		return hbList;
	}

	@Override
	public List<HotelBooking> findByUserinfoUserNo(Long userNo) {
		return hotelBookingRepository.findByUserinfoUserNo(userNo);
	}

	@Override
	public List<HotelBooking> findByHotelHotelNo(Long hotelNo) {
		return hotelBookingRepository.findByHotelHotelNo(hotelNo);
	}

	@Override
	public List<HotelBooking> findByHbCheckinBetweenAndUserinfoUserNo(LocalDate hbCheckin, LocalDate hbCheckout, Long userNo) {
		return hotelBookingRepository.findByHbCheckinBetweenAndUserinfoUserNo(hbCheckin, hbCheckout, userNo);
	}

}
