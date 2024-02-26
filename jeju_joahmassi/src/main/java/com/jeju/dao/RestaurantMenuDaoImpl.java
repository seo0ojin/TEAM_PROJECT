package com.jeju.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeju.entity.RestaurantMenu;
import com.jeju.repository.RestaurantMenuRepository;

@Repository
public class RestaurantMenuDaoImpl implements RestaurantMenuDao{
	
	@Autowired
	private RestaurantMenuRepository restaurantMenuRepository;
	
	// 메뉴 넣기
	@Override
	public RestaurantMenu insert(RestaurantMenu restaurantMenu) {
		return restaurantMenuRepository.save(restaurantMenu);
	}

	// 메뉴 번호로 삭제
	@Override
	public void deleteByNo(Long rmNo) {
		restaurantMenuRepository.deleteById(rmNo);
	}

	// 메뉴 수정
	@Override
	public RestaurantMenu update(RestaurantMenu restaurantMenu) {
		return restaurantMenuRepository.save(restaurantMenu);
	}

	// 메뉴 전체 리스트
	@Override
	public List<RestaurantMenu> findAll() {
		return restaurantMenuRepository.findAll();
	}

	// 메뉴 번호로 찾기
	@Override
	public RestaurantMenu findByNo(Long rmNo) {
		return restaurantMenuRepository.findById(rmNo).get();
	}

	// 식당 번호로 메뉴 찾기
	@Override
	public List<RestaurantMenu> findByRestaurantRestaurantNo(Long restaurantNo) {
		return restaurantMenuRepository.findByRestaurantRestaurantNo(restaurantNo);
	}

}
