package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.dao.HotelAmenityDao;
import com.jeju.entity.HotelAmenity;

@Service
public class HotelAmenityServiceImpl implements HotelAmenityService{
	
	@Autowired
	private HotelAmenityDao hotelAmenityDao;
	
	@Override
	public List<HotelAmenity> findByHotelHotelNo(Long hotelNo) {
		return hotelAmenityDao.findByHotelHotelNo(hotelNo);
	}
	
}
