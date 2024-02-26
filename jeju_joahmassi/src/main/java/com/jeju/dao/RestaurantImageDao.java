package com.jeju.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jeju.entity.RestaurantImage;
import com.jeju.repository.RestaurantImageRepository;

public interface RestaurantImageDao {
	
	public RestaurantImage insert(RestaurantImage restaurantImage);
	
	public void deleteByNo(Long imageNo);
	
	public RestaurantImage update(RestaurantImage restaurantImage);
	
	public RestaurantImage findByNo(Long imageNo);
	
	public List<RestaurantImage> findAll();
	
	public List<RestaurantImage> findByRestaurantRestaurantNo(Long restaurantNo);
	
}
