package com.jeju.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeju.entity.RestaurantMenu;

public interface RestaurantMenuRepository extends JpaRepository<RestaurantMenu, Long>{
	
	// 식당 번호로 메뉴 찾기
	public List<RestaurantMenu> findByRestaurantRestaurantNo(Long restaurantNo);
	
	public List<RestaurantMenu> findByRmNameLike(String rmName);
}
