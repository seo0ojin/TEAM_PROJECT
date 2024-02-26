package com.jeju.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantImage;

public interface RestaurantImageRepository extends JpaRepository<RestaurantImage, Long>{
	
	public List<RestaurantImage> findByRestaurantRestaurantNo(Long restaurantNo);
	
}
