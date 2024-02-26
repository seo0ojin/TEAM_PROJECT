package com.jeju.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jeju.entity.Attraction;

public interface AttractionService {

	// 명소 추가
	public Attraction insertAttraction(Attraction attraction);
	
	// 명소 삭제
	public void deleteAttraction(Long attractionNo);
	
	// 명소 수정
	public Attraction updateAttraction(Attraction attraction);
	
	// 명소 리스트
	public List<Attraction> findAll();
	
	// 명소 찾기
	public Attraction findByAttractionNo(Long attractionNo);
	
	// 명소 이름 검색
	public List<Attraction> findByAttractionNameLike(String attractionName);
	
	// 명소 주소 검색
	public List<Attraction> findByAttractionAddressLike(String attractionAddress);
	
	// 리뷰 많은 순
	public List<Attraction> findAttractionOrderByReviewCountDesc();
		
	// 별점 높은 순
	public List<Attraction> findAllByOrderByAttractionStarDesc();
	
	// 평균 별점 업데이트
	public void updateAttractionStar(Attraction attraction);
	
	// 별점 정렬
	public List<Attraction> findByAttractionStar(int attractionStar);
	
	// 카테고리 번호로 명소 뽑기
	public List<Attraction> findByAttractionCategoryItemsAttractionCategoryAcNo(Long acNo);
	
	/********** 이중정렬 **********/
	// 별점 높은 순 + 카테고리
	public List<Attraction> findByCategoryNoOrderByStars(@Param("categoryNo") Long categoryNo);
	
	// 리뷰 많은 순 + 카테고리
	public List<Attraction> findByCategoryNoOrderByReviewsDesc(@Param("categoryNo") Long categoryNo);
	
	// 한 개의 카테고리에 몇 개의 명소가 있는지 카운트
	public Integer countByAttractionCategoryItemAcNo(Long acNo);
	
	// 검색 + 카테고리 + 별점순
	public List<Attraction> findAttractionLikeAttractionNameByCategoryNoOrderByStars(Long categoryNo, String searchKeyword);
	
	// 검색 + 카테고리 + 리뷰 많은순
	public List<Attraction> findAttractionLikeAttractionNameByCategoryNoOrderByReviewsDesc(Long categoryNo , String searchKeyword );
	
	// 검색 + 별점순
	public List<Attraction> findAttractionLikeAttractionNameByOrderByAttractionStarDesc(String searchKeyword);
	
	// 검색 + 리뷰 많은순
	public List<Attraction> findAttractionLikeAttractionNameOrderByReviewCountDesc(String searchKeyword);
	
	// 검색 + 카테고리
	public List<Attraction> findByAttractionCategoryItemsAttractionCategoryAcNoAndAttractionNameLike(Long acNo, String searchKeyword);
	
	/*
	// 명소 페이징
	Page<Attraction> findAllPage(Pageable pageable);
	
	// 명소 이름 검색
	Page<Attraction> findByAttractionNameLike(String attractionName, Pageable pageable);
	
	// 명소 주소 검색
	Page<Attraction> findByAttractionAddressLike(String attractionAddress, Pageable pageable);
	*/
}
