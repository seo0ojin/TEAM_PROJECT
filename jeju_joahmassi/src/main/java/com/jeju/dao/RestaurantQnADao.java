package com.jeju.dao;

import java.util.List;

import com.jeju.entity.HotelAmenity;
import com.jeju.entity.RestaurantAmenity;
import com.jeju.entity.RestaurantQnA;

public interface RestaurantQnADao {
	
	public List<RestaurantQnA> findByRestaurantRestaurantNo(Long restaurantNo);
	
}
