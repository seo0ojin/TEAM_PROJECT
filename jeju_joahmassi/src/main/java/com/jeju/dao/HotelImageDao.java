package com.jeju.dao;

import java.util.List;

import com.jeju.entity.HotelImage;

public interface HotelImageDao {

	public HotelImage insert(HotelImage insertImage);
	
	public void deleteByNo(Long imageNo);
	
	public HotelImage update(HotelImage updateImage);
	
	public HotelImage findByNo(Long iamgeNo);
	
	public List<HotelImage> findAll();
	
	// 호텔별 이미지
	List<HotelImage> findByHotelHotelNo(Long hotelNo);
}
