package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jeju.dao.RestaurantReviewDao;
import com.jeju.entity.RestaurantReview;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RestaurantReviewServiceImpl implements RestaurantReviewService{
	
	@Autowired
	private RestaurantReviewDao restaurantReviewDao;
	
	// 식당 리뷰 쓰기
	@Override
	public RestaurantReview insert(RestaurantReview restaurantReview) {
		return restaurantReviewDao.insert(restaurantReview);
	}

	// 식당 리뷰 번호로 삭제
	@Override
	public void deleteByNo(Long rrNo) {
		restaurantReviewDao.deleteByNo(rrNo);
	}

	// 리뷰 수정
	@Override
	public RestaurantReview update(RestaurantReview restaurantReview) {
		return restaurantReviewDao.update(restaurantReview);
	}

	// 리뷰 전체 리스트
	@Override
	public List<RestaurantReview> findAll() {
		return restaurantReviewDao.findAll();
	}

	// 리뷰 번호로 1개 찾기
	@Override
	public RestaurantReview findByNo(Long rrNo) {
		return restaurantReviewDao.findByNo(rrNo);
	}

	// 식당 번호로 리뷰 찾기
	@Override
	public List<RestaurantReview> findByRestaurantRestaurantNo(Long restaurantNo) {
		return restaurantReviewDao.findByRestaurantRestaurantNo(restaurantNo);
	}

	// 유저 번호로 리뷰 찾기
	@Override
	public List<RestaurantReview> findByUserinfoUserNo(Long userNo) {
		return restaurantReviewDao.findByUserinfoUserNo(userNo);
	}

	// 식당 번호로 리뷰 찾기 페이징
	@Override
	public Page<RestaurantReview> findByRestaurantRestaurantNo(Long restaurantNo, Pageable pageable) {
		return restaurantReviewDao.findByRestaurantRestaurantNo(restaurantNo, pageable);
	}

	// 유저 번호로 리뷰 찾기 페이징
	@Override
	public Page<RestaurantReview> findByUserinfoUserNo(Long userNo, Pageable pageable) {
		return restaurantReviewDao.findByUserinfoUserNo(userNo, pageable);
	}

	// 유저,식당번호로 리뷰찾기
	@Override
	public List<RestaurantReview> findByUserinfoUserNoAndRestaurantRestaurantNo(Long userNo, Long RestaurantNo) {
		return restaurantReviewDao.findByUserinfoUserNoAndRestaurantRestaurantNo(userNo, RestaurantNo);
	}

	@Override
	public List<RestaurantReview> findByRestaurantRestaurantNoOrderByRrDateDesc(Long restaurantNo) {
		return restaurantReviewDao.findByRestaurantRestaurantNoOrderByRrDateDesc(restaurantNo);
	}

}
