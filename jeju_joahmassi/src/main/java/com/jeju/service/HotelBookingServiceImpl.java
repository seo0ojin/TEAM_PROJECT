package com.jeju.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jeju.dao.HotelBookingDao;
import com.jeju.entity.HotelBooking;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class HotelBookingServiceImpl implements HotelBookingService{

	@Autowired
	HotelBookingDao hotelBookingDao;
	
	@Override
	// 호텔 예약
	public HotelBooking insertHb(HotelBooking booking) {
		return hotelBookingDao.insertHb(booking);
	}

	@Override
	// 호텔 예약 취소
	public void deleteByhbNo(Long hbNo) {
		hotelBookingDao.deleteByhbNo(hbNo);
	}

	@Override
	// 호텔 예약 수정
	public HotelBooking updateHb(HotelBooking updateHb) {
		return hotelBookingDao.updateHb(updateHb);
	}

	@Override
	// 호텔 예약내역 찾기
	public HotelBooking findByHbNo(Long hbNo) {
		return hotelBookingDao.findByHbNo(hbNo);
	}

	@Override
	// 모든 호텔 예약내역 전부 확인 (관리자)
	public List<HotelBooking> findAll() {
		return hotelBookingDao.findAll();
	}

	@Override
	// 내 호텔 예약내역 리스트 확인
	public Page<HotelBooking> findByUserinfoUserNo(Long userNo, Pageable pageable) {
		return hotelBookingDao.findByUserinfoUserNo(userNo, pageable);
	}
	
	@Override
	// 기간별 내 예약내역 조회
	public Page<HotelBooking> findByHbCheckinBetweenAndUserinfoUserNo(LocalDate hbCheckin, LocalDate hbCheckout, Long userNo, Pageable pageable) {
		return hotelBookingDao.findByHbCheckinBetweenAndUserinfoUserNo(hbCheckin, hbCheckout, userNo, pageable);
	}
	
	@Override
	// 호텔에 따른 모든 예약내역 리스트 (관리자)
	public  Page<HotelBooking> findByHotelHotelNo(Long hotelNo, Pageable pageable) {
		return hotelBookingDao.findByHotelHotelNo(hotelNo, pageable);
	}
	
	
	@Override
	public Page<HotelBooking> hbFindAllPage(Pageable pageable) {
		Page<HotelBooking> hbList = hotelBookingDao.hbFindAllPage(pageable);
		return hbList;
	}

	@Override
	public List<HotelBooking> findByUserinfoUserNo(Long userNo) {
		return hotelBookingDao.findByUserinfoUserNo(userNo);
	}

	@Override
	public List<HotelBooking> findByHotelHotelNo(Long hotelNo) {
		return hotelBookingDao.findByHotelHotelNo(hotelNo);
	}

	@Override
	public List<HotelBooking> findByHbCheckinBetweenAndUserinfoUserNo(LocalDate hbCheckin, LocalDate hbCheckout, Long userNo) {
		return hotelBookingDao.findByHbCheckinBetweenAndUserinfoUserNo(hbCheckin, hbCheckout, userNo);
	}
}
