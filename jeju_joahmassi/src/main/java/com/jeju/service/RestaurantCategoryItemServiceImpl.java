package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.dao.RestaurantCategoryItemDao;
import com.jeju.entity.RestaurantCategoryItem;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RestaurantCategoryItemServiceImpl implements RestaurantCategoryItemService{
	
	@Autowired
	private RestaurantCategoryItemDao restaurantCategoryItemDao;
	
	// 카테고리 아이템 추가
	@Override
	public RestaurantCategoryItem insert(RestaurantCategoryItem restaurantCategoryItem) {
		return restaurantCategoryItemDao.insert(restaurantCategoryItem);
	}
	
	// 카테고리 아이템 번호로 삭제
	@Override
	public void deleteByNo(Long rciNo) {
		restaurantCategoryItemDao.deleteByNo(rciNo);
	}

	// 카테고리 아이템 수정
	@Override
	public RestaurantCategoryItem update(RestaurantCategoryItem restaurantCategoryItem) {
		return restaurantCategoryItemDao.update(restaurantCategoryItem);
	}

	// 카테고리 아이템 전체 리스트
	@Override
	public List<RestaurantCategoryItem> findAll() {
		return restaurantCategoryItemDao.findAll();
	}

	// 카테고리 아이템 번호로 찾기
	@Override
	public RestaurantCategoryItem findByNo(Long rciNo) {
		return restaurantCategoryItemDao.findByNo(rciNo);
	}

	// 식당 번호로 카테고리 아이템 찾기
	@Override
	public List<RestaurantCategoryItem> findByRestaurantRestaurantNo(Long restaurantNo) {
		return restaurantCategoryItemDao.findByRestaurantRestaurantNo(restaurantNo);
	}

}
