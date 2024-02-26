package com.jeju.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeju.entity.RestaurantQnA;
import com.jeju.repository.RestauranQnARepository;

@Repository
public class RestaurantQnADaoImpl implements RestaurantQnADao{
	
	@Autowired
	private RestauranQnARepository restaurantQnARepository;
	
	@Override
	public List<RestaurantQnA> findByRestaurantRestaurantNo(Long restaurantNo) {
		return restaurantQnARepository.findByRestaurantRestaurantNo(restaurantNo);
	}
	
	
}
