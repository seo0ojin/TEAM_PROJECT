package com.jeju.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jeju.entity.RestaurantReview;

public interface RestaurantReviewService {
	// 식당 리뷰 쓰기
	public RestaurantReview insert(RestaurantReview restaurantReview);
	
	// 식당 리뷰 번호로 삭제
	public void deleteByNo(Long rrNo);
	
	// 리뷰 수정
	public RestaurantReview update(RestaurantReview restaurantReview);
	
	// 리뷰 전체 리스트
	public List<RestaurantReview> findAll();
	
	// 리뷰 번호로 1개 찾기
	public RestaurantReview findByNo(Long rrNo);
	
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
