package com.jeju.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeju.entity.HotelAmenity;
import com.jeju.entity.RestaurantAmenity;

public interface RestaurantAmenityRepository extends JpaRepository<RestaurantAmenity, Long>{
	
	// 식당번호로 편의성 가져오기
	public List<RestaurantAmenity> findByRestaurantRestaurantNo(Long restaurantNo);
	
}
