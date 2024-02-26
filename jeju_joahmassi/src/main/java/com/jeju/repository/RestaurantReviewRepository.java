package com.jeju.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jeju.entity.RestaurantReview;

public interface RestaurantReviewRepository extends JpaRepository<RestaurantReview, Long>{
	
	// 식당 번호로 리뷰 찾기
	public List<RestaurantReview> findByRestaurantRestaurantNo(Long restaurantNo);
	
	// 유저 번호로 리뷰 찾기
	public List<RestaurantReview> findByUserinfoUserNo(Long userNo);
	
	// 식당 번호로 리뷰 찾기 페이징
	public Page<RestaurantReview> findByRestaurantRestaurantNo(Long restaurantNo,Pageable pageable);
	
	// 유저 번호로 리뷰 찾기 페이징
	public Page<RestaurantReview> findByUserinfoUserNo(Long userNo,Pageable pageable);
	
	// 유저,식당번호로 리뷰찾기
	public List<RestaurantReview> findByUserinfoUserNoAndRestaurantRestaurantNo(Long userNo,Long RestaurantNo);
	
	// 리뷰 최신순 정렬
	public List<RestaurantReview> findByRestaurantRestaurantNoOrderByRrDateDesc(Long restaurantNo);
	
}
