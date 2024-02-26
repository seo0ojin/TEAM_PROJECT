package com.jeju.dao;

import java.util.List;

import com.jeju.entity.HotelAmenity;

public interface HotelAmenityDao {
	
	// 호텔번호로 편의성 가져오기
	public List<HotelAmenity> findByHotelHotelNo(Long hotelNo);
	
}
