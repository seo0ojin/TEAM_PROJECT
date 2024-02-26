package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.dao.RestaurantCategoryDao;
import com.jeju.entity.RestaurantCategory;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RestaurantCategoryServiceImpl implements RestaurantCategoryService{
	
	@Autowired
	private RestaurantCategoryDao restaurantCategoryDao;
	
	// 식당 카테고리 추가
	@Override
	public RestaurantCategory insert(RestaurantCategory restaurantCategory) {
		return restaurantCategoryDao.insert(restaurantCategory);
	}
	
	// 식당 카테고리 삭제
	@Override
	public void delete(Long rcNo) {
		restaurantCategoryDao.delete(rcNo);
	}
	
	// 식당 카테고리 수정
	@Override
	public RestaurantCategory update(RestaurantCategory restaurantCategory) {
		return restaurantCategoryDao.update(restaurantCategory);
	}
	
	// 식당 카테고리 전체리스트
	@Override
	public List<RestaurantCategory> findAll() {
		return restaurantCategoryDao.findAll();
	}
	
	// 식당 카테고리 1개 찾기
	@Override
	public RestaurantCategory findByNo(Long rcNo) {
		return restaurantCategoryDao.findByNo(rcNo);
	}

}
