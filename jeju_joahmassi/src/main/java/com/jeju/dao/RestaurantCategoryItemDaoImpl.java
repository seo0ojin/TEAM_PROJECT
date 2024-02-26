package com.jeju.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.jeju.entity.RestaurantCategoryItem;
import com.jeju.repository.RestaurantCategoryItemRepository;
import com.jeju.repository.RestaurantCategoryRepository;

@Repository
public class RestaurantCategoryItemDaoImpl implements RestaurantCategoryItemDao{
	
	@Autowired
	private RestaurantCategoryItemRepository restaurantCategoryItemRepository;
	
	// 카테고리 아이템 추가
	@Override
	public RestaurantCategoryItem insert(RestaurantCategoryItem restaurantCategoryItem) {
		return restaurantCategoryItemRepository.save(restaurantCategoryItem);
	}
	// 카테고리 아이템 번호로 삭제
	@Override
	public void deleteByNo(Long rciNo) {
		restaurantCategoryItemRepository.deleteById(rciNo);
	}
	// 카테고리 아이템 수정
	@Override
	public RestaurantCategoryItem update(RestaurantCategoryItem restaurantCategoryItem) {
		return restaurantCategoryItemRepository.save(restaurantCategoryItem);
	}
	// 카테고리 아이템 전체 리스트
	@Override
	public List<RestaurantCategoryItem> findAll() {
		return restaurantCategoryItemRepository.findAll();
	}
	// 카테고리 아이템 번호로 찾기
	@Override
	public RestaurantCategoryItem findByNo(Long rciNo) {
		return restaurantCategoryItemRepository.findById(rciNo).get();
	}
	// 식당 번호로 카테고리 아이템 찾기
	@Override
	public List<RestaurantCategoryItem> findByRestaurantRestaurantNo(Long restaurantNo) {
		return restaurantCategoryItemRepository.findByRestaurantRestaurantNo(restaurantNo);
	}
	// 카테고리 번호로 카테고리 아이템 찾기
	@Override
	public List<RestaurantCategoryItem> findByRestaurantCategoryRcNo(Long rcNo) {
		return restaurantCategoryItemRepository.findByRestaurantCategoryRcNo(rcNo);
	}
	// 카테고리 번호로 카테고리 아이템 찾기 페이징
	@Override
	public Page<RestaurantCategoryItem> findByRestaurantCategoryRcNo(Long rcNo, Pageable pageable) {
		return restaurantCategoryItemRepository.findByRestaurantCategoryRcNo(rcNo, pageable);
	}
	
}
