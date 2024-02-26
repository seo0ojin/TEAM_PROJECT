package com.jeju.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeju.entity.RestaurantAmenity;
import com.jeju.repository.RestaurantAmenityRepository;

@Repository
public class RestaurantAmenityDaoImpl implements RestaurantAmenityDao{
	
	@Autowired
	private RestaurantAmenityRepository restaurantAmenityRepository;
	
	// 식당번호로 편의성 가져오기
	@Override
	public List<RestaurantAmenity> findByRestaurantRestaurantNo(Long restaurantNo) {
		return restaurantAmenityRepository.findByRestaurantRestaurantNo(restaurantNo);
	}
	
}
