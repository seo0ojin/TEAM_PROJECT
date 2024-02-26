package com.jeju.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeju.entity.RestaurantCategory;
import com.jeju.repository.RestaurantCategoryRepository;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public class RestaurantCategoryDaoImpl implements RestaurantCategoryDao{
	
	@Autowired
	private RestaurantCategoryRepository restaurantCategoryRepository;
	
	// 식당 카테고리 추가
	@Override
	public RestaurantCategory insert(RestaurantCategory restaurantCategory) {
		return restaurantCategoryRepository.save(restaurantCategory);
	}
	
	// 식당 카테고리 번호로 삭제
	@Override
	public void delete(Long rcNo) {
		restaurantCategoryRepository.deleteById(rcNo);
	}
	
	// 식당 카테고리 수정
	@Override
	public RestaurantCategory update(RestaurantCategory restaurantCategory) {
		return restaurantCategoryRepository.save(restaurantCategory);
	}
	
	// 식당 카테고리 전체리스트
	@Override
	public List<RestaurantCategory> findAll() {
		return restaurantCategoryRepository.findAll();
	}
	
	// 식당 카테고리 1개 찾기
	@Override
	public RestaurantCategory findByNo(Long rcNo) {
		return restaurantCategoryRepository.findById(rcNo).get();
	}
	
}
