package com.jeju.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeju.entity.HotelAmenity;
import com.jeju.entity.RestaurantAmenity;
import com.jeju.entity.RestaurantQnA;

public interface RestauranQnARepository extends JpaRepository<RestaurantQnA, Long>{
	
	public List<RestaurantQnA> findByRestaurantRestaurantNo(Long restaurantNo);
	
}
