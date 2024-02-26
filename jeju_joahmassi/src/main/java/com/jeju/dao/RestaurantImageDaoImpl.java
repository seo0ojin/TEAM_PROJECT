package com.jeju.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeju.entity.RestaurantImage;
import com.jeju.repository.RestaurantImageRepository;

@Repository
public class RestaurantImageDaoImpl implements RestaurantImageDao{
	
	@Autowired
	private RestaurantImageRepository restaurantImageRepository;
	
	@Override
	public RestaurantImage insert(RestaurantImage restaurantImage) {
		return restaurantImageRepository.save(restaurantImage);
	}

	@Override
	public void deleteByNo(Long imageNo) {
		restaurantImageRepository.deleteById(imageNo);
	}

	@Override
	public RestaurantImage update(RestaurantImage restaurantImage) {
		return restaurantImageRepository.save(restaurantImage);
	}

	@Override
	public RestaurantImage findByNo(Long imageNo) {
		return restaurantImageRepository.findById(imageNo).get();
	}

	@Override
	public List<RestaurantImage> findAll() {
		return restaurantImageRepository.findAll();
	}

	@Override
	public List<RestaurantImage> findByRestaurantRestaurantNo(Long restaurantNo) {
		return restaurantImageRepository.findByRestaurantRestaurantNo(restaurantNo);
	}

}
