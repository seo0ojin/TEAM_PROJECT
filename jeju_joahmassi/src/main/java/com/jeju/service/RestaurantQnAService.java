package com.jeju.service;

import java.util.List;

import com.jeju.entity.RestaurantQnA;

public interface RestaurantQnAService {
	
	public List<RestaurantQnA> findByRestaurantRestaurantNo(Long restaurantNo);
	
}
