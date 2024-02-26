package com.jeju.dao;

import java.util.List;

import com.jeju.entity.RestaurantCategory;

public interface RestaurantCategoryDao {
	// 식당 카테고리 추가
	public RestaurantCategory insert(RestaurantCategory restaurantCategory);
	
	// 식당 카테고리 번호로 삭제
	public void delete(Long rcNo);
	
	// 식당 카테고리 수정
	public RestaurantCategory update(RestaurantCategory restaurantCategory);
	
	// 식당 카테고리 전체 리스트
	public List<RestaurantCategory> findAll();
	
	// 식당 카테고리 1개 찾기
	public RestaurantCategory findByNo(Long rcNo);
	
}
