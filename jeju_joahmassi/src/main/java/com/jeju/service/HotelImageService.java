package com.jeju.service;

import java.util.List;

import com.jeju.entity.HotelImage;

public interface HotelImageService {

public HotelImage insert(HotelImage insertImage);
	
	public void deleteByNo(Long imageNo);
	
	public HotelImage update(HotelImage updateImage);
	
	public HotelImage findByNo(Long imageNo);
	
	public List<HotelImage> findAll();
	
	// 호텔별 이미지
	public List<HotelImage> findByHotelHotelNo(Long hotelNo);
}
