package com.jeju.dao;

import java.util.List;

import com.jeju.entity.HotelAmenity;
import com.jeju.entity.RestaurantAmenity;

public interface RestaurantAmenityDao {
	
	// 식당번호로 편의성 가져오기
	public List<RestaurantAmenity> findByRestaurantRestaurantNo(Long restaurantNo);
	
}
