package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.dao.RestaurantAmenityDao;
import com.jeju.entity.RestaurantAmenity;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class RestaurantAmenityServiceImpl implements RestaurantAmenityService{
	
	@Autowired
	private RestaurantAmenityDao restaurantAmenityDao;

	@Override
	public List<RestaurantAmenity> findByRestaurantRestaurantNo(Long restaurantNo) {
		return restaurantAmenityDao.findByRestaurantRestaurantNo(restaurantNo);
	}
	
}
