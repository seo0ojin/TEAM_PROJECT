package com.jeju.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jeju.entity.AttractionReview;

public interface AttractionReviewRepository extends JpaRepository<AttractionReview, Long>{
	
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
	//Double findAverageArStarByAttraction_AttractionNo(Long attractionNo);
	//@Query("SELECT FLOOR(AVG(ar.arStar) * 10) / 10 FROM AttractionReview ar WHERE ar.attraction.attractionNo = :attractionNo")
	//Double calculateAverageStarRatingWithFloor(@Param("attractionNo") Long attractionNo);
	
}
