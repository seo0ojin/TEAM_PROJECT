package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeju.dao.AttractionDao;
import com.jeju.entity.Attraction;

@Service
@Transactional
public class AttractionServiceImpl implements AttractionService {

	@Autowired
	private AttractionDao attractionDao;
	
	// 명소 추가
	@Override
	public Attraction insertAttraction(Attraction attraction) {
		
		return attractionDao.insertAttraction(attraction);
	}
	
	// 명소 삭제
	@Override
	public void deleteAttraction(Long attractionNo) {
		
		attractionDao.deleteAttraction(attractionNo);
	}
	
	// 명소 수정
	@Override
	public Attraction updateAttraction(Attraction attraction) {
		
		return attractionDao.updateAttraction(attraction);
	}
	
	// 명소 리스트
	@Override
	public List<Attraction> findAll() {
		
		return attractionDao.findAll();
	}
	
	// 명소 찾기
	@Override
	public Attraction findByAttractionNo(Long attractionNo) {
		
		return attractionDao.findByAttractionNo(attractionNo);
	}

	// 명소 이름 검색
	@Override
	public List<Attraction> findByAttractionNameLike(String attractionName) {
		
		return attractionDao.findByAttractionNameLike("%" + attractionName + "%");
	}

	// 명소 주소 검색
	@Override
	public List<Attraction> findByAttractionAddressLike(String attractionAddress) {
		
		return attractionDao.findByAttractionAddressLike("%" + attractionAddress + "%");
	}

	// 리뷰 많은 순
	@Override
	public List<Attraction> findAttractionOrderByReviewCountDesc() {
		
		return attractionDao.findAttractionOrderByReviewCountDesc();
	}

	// 별점 높은 순
	@Override
	public List<Attraction> findAllByOrderByAttractionStarDesc() {
		
		return attractionDao.findAllByOrderByAttractionStarDesc();
	}

	// 평균 별점 업데이트
	@Override
	public void updateAttractionStar(Attraction attraction) {
		
		attractionDao.updateAttractionStar(attraction);
	}

	// 별점 정렬
	@Override
	public List<Attraction> findByAttractionStar(int attractionStar) {
		
		return attractionDao.findByAttractionStar(attractionStar);
	}

	// 카테고리 번호로 명소 뽑기
	@Override
	public List<Attraction> findByAttractionCategoryItemsAttractionCategoryAcNo(Long acNo) {
		
		return attractionDao.findByAttractionCategoryItemsAttractionCategoryAcNo(acNo);
	}
	
	/********** 이중정렬 **********/
	// 별점 높은 순 + 카테고리
	@Override
	public List<Attraction> findByCategoryNoOrderByStars(Long categoryNo) {
		
		return attractionDao.findByCategoryNoOrderByStars(categoryNo);
	}

	// 리뷰 많은 순 + 카테고리
	@Override
	public List<Attraction> findByCategoryNoOrderByReviewsDesc(Long categoryNo) {
		
		return attractionDao.findByCategoryNoOrderByReviewsDesc(categoryNo);
	}

	// 한 개의 카테고리에 몇 개의 명소가 있는지 카운트
	@Override
	public Integer countByAttractionCategoryItemAcNo(Long acNo) {
		
		return attractionDao.countByAttractionCategoryItemAcNo(acNo);
	}

	// 검색 + 카테고리 + 별점순
	@Override
	public List<Attraction> findAttractionLikeAttractionNameByCategoryNoOrderByStars(Long categoryNo,
			String searchKeyword) {
		
		return attractionDao.findAttractionLikeAttractionNameByCategoryNoOrderByStars(categoryNo, searchKeyword);
	}

	// 검색 + 카테고리 + 리뷰 많은순
	@Override
	public List<Attraction> findAttractionLikeAttractionNameByCategoryNoOrderByReviewsDesc(Long categoryNo,
			String searchKeyword) {
		
		return attractionDao.findAttractionLikeAttractionNameByCategoryNoOrderByReviewsDesc(categoryNo, searchKeyword);
	}

	// 검색 + 별점순
	@Override
	public List<Attraction> findAttractionLikeAttractionNameByOrderByAttractionStarDesc(String searchKeyword) {
		
		return attractionDao.findAttractionLikeAttractionNameByOrderByAttractionStarDesc(searchKeyword);
	}

	// 검색 + 리뷰 많은순
	@Override
	public List<Attraction> findAttractionLikeAttractionNameOrderByReviewCountDesc(String searchKeyword) {
		
		return attractionDao.findAttractionLikeAttractionNameOrderByReviewCountDesc(searchKeyword);
	}

	// 검색 + 카테고리
	@Override
	public List<Attraction> findByAttractionCategoryItemsAttractionCategoryAcNoAndAttractionNameLike(Long acNo,
			String searchKeyword) {
		
		return attractionDao.findByAttractionCategoryItemsAttractionCategoryAcNoAndAttractionNameLike(acNo, searchKeyword);
	}
	
	/*
	// 명소 페이징
	@Override
	public Page<Attraction> findAllPage(Pageable pageable) {
		
		return attractionDao.findAllPage(pageable);
	}
	
	// 명소 이름 검색
	@Override
	public Page<Attraction> findByAttractionNameLike(String attractionName, Pageable pageable) {
		
		return attractionDao.findByAttractionNameLike("%" + attractionName + "%", pageable);
	}
	
	// 명소 주소 검색
	@Override
	public Page<Attraction> findByAttractionAddressLike(String attractionAddress, Pageable pageable) {
		
		return attractionDao.findByAttractionAddressLike("%" + attractionAddress + "%", pageable);
	}
	*/
}
