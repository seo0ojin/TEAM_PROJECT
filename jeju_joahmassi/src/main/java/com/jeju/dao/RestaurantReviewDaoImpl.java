package com.jeju.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.jeju.entity.RestaurantReview;
import com.jeju.repository.RestaurantReviewRepository;

@Repository
public class RestaurantReviewDaoImpl implements RestaurantReviewDao{
	
	@Autowired
	private RestaurantReviewRepository restaurantReviewRepository;
	
	// 식당 리뷰 쓰기
	@Override
	public RestaurantReview insert(RestaurantReview restaurantReview) {
		return restaurantReviewRepository.save(restaurantReview);
	}

	// 식당 리뷰 번호로 삭제
	@Override
	public void deleteByNo(Long rrNo) {
		restaurantReviewRepository.deleteById(rrNo);
	}

	// 리뷰 수정
	@Override
	public RestaurantReview update(RestaurantReview restaurantReview) {
		return restaurantReviewRepository.save(restaurantReview);
	}

	// 리뷰 전체 리스트
	@Override
	public List<RestaurantReview> findAll() {
		return restaurantReviewRepository.findAll();
	}

	// 리뷰 번호로 1개 찾기
	@Override
	public RestaurantReview findByNo(Long rrNo) {
		return restaurantReviewRepository.findById(rrNo).get();
	}

	// 식당 번호로 리뷰 찾기
	@Override
	public List<RestaurantReview> findByRestaurantRestaurantNo(Long restaurantNo) {
		return restaurantReviewRepository.findByRestaurantRestaurantNo(restaurantNo);
	}

	// 유저 번호로 리뷰 찾기
	@Override
	public List<RestaurantReview> findByUserinfoUserNo(Long userNo) {
		return restaurantReviewRepository.findByUserinfoUserNo(userNo);
	}

	// 식당 번호로 리뷰 찾기 페이징
	@Override
	public Page<RestaurantReview> findByRestaurantRestaurantNo(Long restaurantNo, Pageable pageable) {
		return restaurantReviewRepository.findByRestaurantRestaurantNo(restaurantNo, pageable);
	}

	// 유저 번호로 리뷰 찾기 페이징
	@Override
	public Page<RestaurantReview> findByUserinfoUserNo(Long userNo, Pageable pageable) {
		return restaurantReviewRepository.findByUserinfoUserNo(userNo, pageable);
	}
	
	// 유저,식당번호로 리뷰찾기
	@Override
	public List<RestaurantReview> findByUserinfoUserNoAndRestaurantRestaurantNo(Long userNo, Long RestaurantNo) {
		return restaurantReviewRepository.findByUserinfoUserNoAndRestaurantRestaurantNo(userNo, RestaurantNo);
	}

	@Override
	public List<RestaurantReview> findByRestaurantRestaurantNoOrderByRrDateDesc(Long restaurantNo) {
		return restaurantReviewRepository.findByRestaurantRestaurantNoOrderByRrDateDesc(restaurantNo);
	}

}
