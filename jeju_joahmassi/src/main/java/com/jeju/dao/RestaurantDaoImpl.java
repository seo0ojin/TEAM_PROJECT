package com.jeju.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.jeju.entity.Restaurant;
import com.jeju.repository.RestaurantRepository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RestaurantDaoImpl implements RestaurantDao{
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	// 식당 추가
	@Override
	public Restaurant insert(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}
	
	// 식당 수정
	@Override
	public Restaurant update(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}
	
	// 식당 1개 번호로 삭제
	@Override
	public void deleteByNo(Long restaurantNo) {
		restaurantRepository.deleteById(restaurantNo);
	}
	
	// 식당 전체 리스트
	@Override
	public List<Restaurant> findAll() {
		return restaurantRepository.findAll();
	}
	
	// 식당 1개를 번호로 찾기
	@Override
	public Restaurant findByNo(Long restaurantNo) {
		Optional<Restaurant> optional = restaurantRepository.findById(restaurantNo);
		return optional.get();
	}
	
	// 식당 전체리스트 페이징
	@Override
	public Page<Restaurant> findAllPage(Pageable pageable) {
		return restaurantRepository.findAll(pageable);
	}
	
	// 식당 카테고리로 페이징
	/*
	@Override
	public Page<Restaurant> findByRestaurantCategory(String restaurantCategory, Pageable pageable) {
		return restaurantRepository.findByRestaurantCategory(restaurantCategory, pageable);
	}
	*/
	// 식당 이름으로 검색 페이징
	@Override
	public Page<Restaurant> findByRestaurantNameLike(String restaurantName, Pageable pageable) {
		return restaurantRepository.findByRestaurantNameLike(restaurantName, pageable);
	}
	
	// 식당 주소로 찾기 페이징
	@Override
	public Page<Restaurant> findByRestaurantAddressLike(String restaurantAddress, Pageable pageable) {
		return restaurantRepository.findByRestaurantAddressLike(restaurantAddress, pageable);
	}
	
	// 식당 이름으로 검색
	@Override
	public List<Restaurant> findByRestaurantNameLike(String restaurantName) {
		return restaurantRepository.findByRestaurantNameLike(restaurantName);
	}
	
	// 식당 주소로 찾기
	@Override
	public List<Restaurant> findByRestaurantAddressLike(String restaurantAddress) {
		return restaurantRepository.findByRestaurantAddressLike(restaurantAddress);
	}

	@Override
	public List<Restaurant> findRestaurantOrderByReviewCountDesc() {
		return restaurantRepository.findRestaurantOrderByReviewCountDesc();
	}

	@Override
	public List<Restaurant> findAllByOrderByRestaurantStarDesc() {
		return restaurantRepository.findAllByOrderByRestaurantStarDesc();
	}

	@Override
	public List<Restaurant> findAllByBookingCountDesc() {
		return restaurantRepository.findAllByBookingCountDesc();
	}

	@Override
	public List<Restaurant> findByRestaurantCategoryItemsRestaurantCategoryRcName(String rcName) {
		return restaurantRepository.findByRestaurantCategoryItemsRestaurantCategoryRcName(rcName);
	}

	@Override
	public List<Restaurant> findByRestaurantCategoryItemsRestaurantCategoryRcNo(Long rcNo) {
		return restaurantRepository.findByRestaurantCategoryItemsRestaurantCategoryRcNo(rcNo);
	}

	@Override
	public List<Restaurant> findByCategoryNoOrderByBookingsDesc(Long categoryNo) {
		return restaurantRepository.findByCategoryNoOrderByBookingsDesc(categoryNo);
	}

	@Override
	public List<Restaurant> findByCategoryNoOrderByStars(Long categoryNo) {
		return restaurantRepository.findByCategoryNoOrderByStars(categoryNo);
	}

	@Override
	public List<Restaurant> findByCategoryNoOrderByReviewsDesc(Long categoryNo) {
		return restaurantRepository.findByCategoryNoOrderByReviewsDesc(categoryNo);
	}

	@Override
	public List<Restaurant> findRestaurantLikeRestaurantNameOrderByReviewCountDesc(String searchKeyword) {
		return restaurantRepository.findRestaurantLikeRestaurantNameOrderByReviewCountDesc(searchKeyword);
	}

	@Override
	public List<Restaurant> findRestaurantLikeRestaurantNameByBookingCountDesc(String searchKeyword) {
		return restaurantRepository.findRestaurantLikeRestaurantNameByBookingCountDesc(searchKeyword);
	}

	@Override
	public List<Restaurant> findRestaurantLikeRestaurantNameByOrderByRestaurantStarDesc(String searchKeyword) {
		return restaurantRepository.findRestaurantLikeRestaurantNameByOrderByRestaurantStarDesc(searchKeyword);
	}

	@Override
	public List<Restaurant> findRestaurantLikeRestaurantNameByCategoryNoOrderByBookingsDesc(Long categoryNo,
			String searchKeyword) {
		return restaurantRepository.findRestaurantLikeRestaurantNameByCategoryNoOrderByBookingsDesc(categoryNo,searchKeyword);
	}

	@Override
	public List<Restaurant> findRestaurantLikeRestaurantNameByCategoryNoOrderByStars(Long categoryNo,
			String searchKeyword) {
		return restaurantRepository.findRestaurantLikeRestaurantNameByCategoryNoOrderByStars(categoryNo,searchKeyword);
	}

	@Override
	public List<Restaurant> findRestaurantLikeRestaurantNameByCategoryNoOrderByReviewsDesc(Long categoryNo,
			String searchKeyword) {
		return restaurantRepository.findRestaurantLikeRestaurantNameByCategoryNoOrderByReviewsDesc(categoryNo,searchKeyword);
	}

	@Override
	public List<Restaurant> findByRestaurantCategoryItemsRestaurantCategoryRcNoAndRestaurantNameLike(Long rcNo,
			String searchKeyword) {
		return restaurantRepository.findByRestaurantCategoryItemsRestaurantCategoryRcNoAndRestaurantNameLike(rcNo,searchKeyword);
	}

	/*
	// 메뉴로 식당 찾기
	@Override
	public List<Restaurant> findByRestaurantMenusRmNameLike(String rmName) {
		return restaurantRepository.findByRestaurantMenusRmNameLike(rmName);
	}

	@Override
	public Page<Restaurant> findByRestaurantMenusRmNameLike(String rmName, Pageable pageable) {
		return restaurantRepository.findByRestaurantMenusRmNameLike(rmName, pageable);
	}
	*/
}
