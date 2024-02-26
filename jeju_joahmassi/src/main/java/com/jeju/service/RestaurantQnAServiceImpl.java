package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.dao.RestaurantQnADao;
import com.jeju.entity.RestaurantQnA;

@Service
public class RestaurantQnAServiceImpl implements RestaurantQnAService{
	
	@Autowired
	private RestaurantQnADao restaurantQnADao;
	
	@Override
	public List<RestaurantQnA> findByRestaurantRestaurantNo(Long restaurantNo) {
		return restaurantQnADao.findByRestaurantRestaurantNo(restaurantNo);
	}

}
