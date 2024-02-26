package com.jeju.service;

import java.util.List;

import com.jeju.entity.RestaurantImage;

public interface RestaurantImageService {
	public RestaurantImage insert(RestaurantImage restaurantImage);
	
	public void deleteByNo(Long imageNo);
	
	public RestaurantImage update(RestaurantImage restaurantImage);
	
	public RestaurantImage findByNo(Long imageNo);
	
	public List<RestaurantImage> findAll();
	
	public List<RestaurantImage> findByRestaurantRestaurantNo(Long restaurantNo);
}
