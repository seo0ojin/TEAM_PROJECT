package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.dao.RestaurantImageDao;
import com.jeju.entity.RestaurantImage;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RestaurantImageServiceImpl implements RestaurantImageService{
	
	@Autowired
	private RestaurantImageDao restaurantImageDao;

	@Override
	public RestaurantImage insert(RestaurantImage restaurantImage) {
		return restaurantImageDao.insert(restaurantImage);
	}

	@Override
	public void deleteByNo(Long imageNo) {
		restaurantImageDao.deleteByNo(imageNo);
	}

	@Override
	public RestaurantImage update(RestaurantImage restaurantImage) {
		return restaurantImageDao.update(restaurantImage);
	}

	@Override
	public RestaurantImage findByNo(Long imageNo) {
		return restaurantImageDao.findByNo(imageNo);
	}

	@Override
	public List<RestaurantImage> findAll() {
		return restaurantImageDao.findAll();
	}

	@Override
	public List<RestaurantImage> findByRestaurantRestaurantNo(Long restaurantNo) {
		return restaurantImageDao.findByRestaurantRestaurantNo(restaurantNo);
	}
	
}
