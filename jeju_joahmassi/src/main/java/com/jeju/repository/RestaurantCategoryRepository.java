package com.jeju.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeju.entity.RestaurantCategory;

public interface RestaurantCategoryRepository extends JpaRepository<RestaurantCategory, Long>{

}
