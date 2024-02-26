package com.jeju.service;

import java.util.List;

import com.jeju.entity.RestaurantMenu;

public interface RestaurantMenuService {
	// 메뉴 넣기
	public RestaurantMenu insert(RestaurantMenu restaurantMenu);
	
	// 메뉴 번호로 삭제
	public void deleteByNo(Long rmNo);
	
	// 메뉴 수정
	public RestaurantMenu update(RestaurantMenu restaurantMenu);
	
	// 메뉴 전체 리스트
	public List<RestaurantMenu> findAll();
	
	// 메뉴 번호로 찾기
	public RestaurantMenu findByNo(Long rmNo);
	
	// 식당 번호로 메뉴 찾기
	public List<RestaurantMenu> findByRestaurantRestaurantNo(Long restaurantNo);
}
