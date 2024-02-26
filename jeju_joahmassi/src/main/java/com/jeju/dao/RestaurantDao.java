package com.jeju.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jeju.entity.Restaurant;

public interface RestaurantDao {
	// 식당 추가
	public Restaurant insert(Restaurant restaurant);
	
	// 식당 수정
	public Restaurant update(Restaurant restaurant);
	
	// 식당 번호로 1개 삭제
	public void deleteByNo(Long restaurantNo);
	
	// 식당 전체리스트
	public List<Restaurant> findAll();
	
	// 식당 번호로 1개 찾기
	public Restaurant findByNo(Long restaurantNo);
	
	// 식당 전체리스트 페이징
	public Page<Restaurant> findAllPage(Pageable pageable);
	
	// 식당 카테고리로 찾기 페이징
	//public Page<Restaurant> findByRestaurantCategory(String restaurantCategory, Pageable pageable);
	
	// 식당 이름으로 검색 찾기 페이징
	public Page<Restaurant> findByRestaurantNameLike(String restaurantName, Pageable pageable);
	
	public List<Restaurant> findByRestaurantNameLike(String restaurantName);
	
	// 식당 주소로 찾기 페이징
	public List<Restaurant> findByRestaurantAddressLike(String restaurantAddress);
	
	// 리뷰 많은순
	public Page<Restaurant> findByRestaurantAddressLike(String restaurantAddress, Pageable pageable);
	
	// 별점 높은순
	public List<Restaurant> findAllByOrderByRestaurantStarDesc();
	
	// 예약 많은순
	public List<Restaurant> findAllByBookingCountDesc();
	
	/*
	// 메뉴로 식당 찾기
	List<Restaurant> findByRestaurantMenusRmNameLike(String rmName);
	
	// 메뉴로 식당찾기 페이징
	Page<Restaurant> findByRestaurantMenusRmNameLike(String rmName,Pageable pageable);
	*/
	
	public List<Restaurant> findRestaurantOrderByReviewCountDesc();
	
	// 카테고리 이름으로 레스토랑 뽑기
	public List<Restaurant> findByRestaurantCategoryItemsRestaurantCategoryRcName(String rcName);
	
	// 카테고리 번호로 레스토랑 뽑기
	public List<Restaurant> findByRestaurantCategoryItemsRestaurantCategoryRcNo(Long rcNo);
	
	// 예약많은순 + 카테고리
	public List<Restaurant> findByCategoryNoOrderByBookingsDesc(@Param("categoryNo") Long categoryNo);
	
	// 별점많은순 + 카테고리
	public List<Restaurant> findByCategoryNoOrderByStars(@Param("categoryNo") Long categoryNo);
	
	// 리뷰많은순 + 카테고리
	public List<Restaurant> findByCategoryNoOrderByReviewsDesc(@Param("categoryNo") Long categoryNo);
	
	// 검색 + 카테고리 + 예약 많은순 
	public List<Restaurant> findRestaurantLikeRestaurantNameByCategoryNoOrderByBookingsDesc(@Param("categoryNo") Long categoryNo , String searchKeyword );
	
	// 검색 + 카테고리 + 별점순
	public List<Restaurant> findRestaurantLikeRestaurantNameByCategoryNoOrderByStars(@Param("categoryNo") Long categoryNo, String searchKeyword);
	
	// 검색 + 카테고리 + 리뷰 많은순
	public List<Restaurant> findRestaurantLikeRestaurantNameByCategoryNoOrderByReviewsDesc(@Param("categoryNo") Long categoryNo , String searchKeyword );
	
	// 검색 + 예약 많은순
	public List<Restaurant> findRestaurantLikeRestaurantNameByBookingCountDesc(String searchKeyword);
	
	// 검색 + 별점 많은순
	public List<Restaurant> findRestaurantLikeRestaurantNameByOrderByRestaurantStarDesc(String searchKeyword);
	
	// 검색 + 리뷰 많은순
	public List<Restaurant> findRestaurantLikeRestaurantNameOrderByReviewCountDesc(String searchKeyword);
	
	// 검색 + 카테고리
	public List<Restaurant> findByRestaurantCategoryItemsRestaurantCategoryRcNoAndRestaurantNameLike(Long rcNo,String searchKeyword);
}
