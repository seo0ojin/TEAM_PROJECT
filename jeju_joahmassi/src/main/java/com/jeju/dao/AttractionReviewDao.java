package com.jeju.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jeju.entity.AttractionReview;

public interface AttractionReviewDao {

	// 명소 리뷰 작성
	AttractionReview insert(AttractionReview review);
	
	// 명소 리뷰 하나 찾기
	AttractionReview findByArNo(Long arNo);
	
	// 명소 리뷰 수정
	AttractionReview update(AttractionReview update);
	
	// 명소 리뷰 삭제
	void deleteByArNo(Long arNo);
	
	// 명소 리뷰 전체출력 (관리자)
	List<AttractionReview> findAll();
	
	// 내가 쓴 명소 리뷰 전체보기
	List<AttractionReview> findByUserinfoUserNo(Long userNo);

	// 명소별 리뷰 전체보기
	List<AttractionReview> findByAttractionAttractionNo(Long attractionNo);

	// 명소별 높은 별점순 리뷰 정렬
	List<AttractionReview> findByAttractionAttractionNoOrderByArStarDesc(Long attractionNo);

	// 명소별 낮은 별점순 리뷰 정렬
	List<AttractionReview> findByAttractionAttractionNoOrderByArStarAsc(Long attractionNo);

	// 명소별 최신 리뷰 정렬
	List<AttractionReview> findByAttractionAttractionNoOrderByArDateDesc(Long attractionNo);

	// 명소별 오래된 리뷰 정렬
	List<AttractionReview> findByAttractionAttractionNoOrderByArDateAsc(Long attractionNo);
	
	/*
	// 내가 쓴 명소 리뷰 전체보기
	Page<AttractionReview> findByUserinfoUserNo(Long userNo, Pageable pageable);
	
	// 명소별 리뷰 전체보기
	Page<AttractionReview> findByAttractionAttractionNo(Long attractionNo, Pageable pageable);
	
	// 명소별 높은 별점순 리뷰 정렬
	Page<AttractionReview> findByAttractionAttractionNoOrderByArStarDesc(Long attractionNo, Pageable pageable);

	// 명소별 낮은 별점순 리뷰 정렬
	Page<AttractionReview> findByAttractionAttractionNoOrderByArStarAsc(Long attractionNo, Pageable pageable);
    
	// 명소별 최신 리뷰 정렬
	Page<AttractionReview> findByAttractionAttractionNoOrderByArDateDesc(Long attractionNo, Pageable pageable);

	// 명소별 오래된 리뷰 정렬
	Page<AttractionReview> findByAttractionAttractionNoOrderByArDateAsc(Long attractionNo, Pageable pageable);
    */
	// 명소별 평균 별점 계산
	//Double calculateAverageStarRatingWithFloor(Long attractionNo);
    
}
