package com.jeju.service;

import java.util.List;

import com.jeju.entity.HotelAmenity;

public interface HotelAmenityService {
	
	// 호텔번호로 편의성 가져오기
	public List<HotelAmenity> findByHotelHotelNo(Long hotelNo);
	
}
