package com.jeju.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jeju.entity.RestaurantCategory;
import com.jeju.entity.RestaurantCategoryItem;

public interface RestaurantCategoryItemRepository extends JpaRepository<RestaurantCategoryItem, Long>{
	
	// 식당 번호로 카테고리 아이템 찾기
	public List<RestaurantCategoryItem> findByRestaurantRestaurantNo(Long restaurantNo);
	
	// 카테고리 번호로 카테고리 아이템 찾기
	public List<RestaurantCategoryItem> findByRestaurantCategoryRcNo(Long rcNo);
	
	// 카테고리 번호로 카테고리 아이템 찾기 페이징
	public Page<RestaurantCategoryItem> findByRestaurantCategoryRcNo(Long rcNo,Pageable pageable);
}
