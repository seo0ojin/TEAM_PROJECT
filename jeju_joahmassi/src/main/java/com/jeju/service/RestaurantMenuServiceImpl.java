package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.dao.RestaurantMenuDao;
import com.jeju.entity.RestaurantMenu;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RestaurantMenuServiceImpl implements RestaurantMenuService{
	
	@Autowired
	private RestaurantMenuDao restaurantMenuDao;
	
	// 메뉴 넣기
	@Override
	public RestaurantMenu insert(RestaurantMenu restaurantMenu) {
		return restaurantMenuDao.insert(restaurantMenu);
	}

	// 메뉴 번호로 삭제
	@Override
	public void deleteByNo(Long rmNo) {
		restaurantMenuDao.deleteByNo(rmNo);
	}

	// 메뉴 수정
	@Override
	public RestaurantMenu update(RestaurantMenu restaurantMenu) {
		return restaurantMenuDao.update(restaurantMenu);
	}

	// 메뉴 전체 리스트
	@Override
	public List<RestaurantMenu> findAll() {
		return restaurantMenuDao.findAll();
	}

	// 메뉴 번호로 찾기
	@Override
	public RestaurantMenu findByNo(Long rmNo) {
		return restaurantMenuDao.findByNo(rmNo);
	}

	// 식당 번호로 메뉴 찾기
	@Override
	public List<RestaurantMenu> findByRestaurantRestaurantNo(Long restaurantNo) {
		return restaurantMenuDao.findByRestaurantRestaurantNo(restaurantNo);
	}
	
}
