package com.jeju.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeju.entity.HotelAmenity;
import com.jeju.repository.HotelAmenityRepository;

@Repository
public class HotelAmenityDaoImpl implements HotelAmenityDao{
	
	@Autowired
	private HotelAmenityRepository hotelAmenityRepository;
	
	@Override
	public List<HotelAmenity> findByHotelHotelNo(Long hotelNo) {
		return hotelAmenityRepository.findByHotelHotelNo(hotelNo);
	}
	
}
