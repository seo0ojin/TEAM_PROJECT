package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jeju.dao.AttractionReviewDao;
import com.jeju.entity.AttractionReview;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AttractionReviewServiceImpl implements AttractionReviewService{

	@Autowired
	AttractionReviewDao attractionReviewDao;
	
	@Override
	public AttractionReview insert(AttractionReview review) {
		
		return attractionReviewDao.insert(review);
	}

	@Override
	public AttractionReview findByArNo(Long arNo) {
		
		return attractionReviewDao.findByArNo(arNo);
	}

	@Override
	public AttractionReview update(AttractionReview update) {
		
		return attractionReviewDao.update(update);
	}

	@Override
	public void deleteByArNo(Long arNo) {
		
		attractionReviewDao.deleteByArNo(arNo);
	}

	@Override
	public List<AttractionReview> findAll() {
		
		return attractionReviewDao.findAll();
	}

	@Override
	public List<AttractionReview> findByUserinfoUserNo(Long userNo) {
		
		return attractionReviewDao.findByUserinfoUserNo(userNo);
	}

	@Override
	public List<AttractionReview> findByAttractionAttractionNo(Long attractionNo) {
		
		return attractionReviewDao.findByAttractionAttractionNo(attractionNo);
	}

	@Override
	public List<AttractionReview> findByAttractionAttractionNoOrderByArStarDesc(Long attractionNo) {
		
		return attractionReviewDao.findByAttractionAttractionNoOrderByArStarDesc(attractionNo);
	}

	@Override
	public List<AttractionReview> findByAttractionAttractionNoOrderByArStarAsc(Long attractionNo) {
		
		return attractionReviewDao.findByAttractionAttractionNoOrderByArStarAsc(attractionNo);
	}

	@Override
	public List<AttractionReview> findByAttractionAttractionNoOrderByArDateDesc(Long attractionNo) {

		return attractionReviewDao.findByAttractionAttractionNoOrderByArDateDesc(attractionNo);
	}

	@Override
	public List<AttractionReview> findByAttractionAttractionNoOrderByArDateAsc(Long attractionNo) {
		
		return attractionReviewDao.findByAttractionAttractionNoOrderByArDateAsc(attractionNo);
	}

	/*
	@Override
	public Page<AttractionReview> findByUserinfoUserNo(Long userNo, Pageable pageable) {
		return attractionServiceDao.findByUserinfoUserNo(userNo, pageable);
	}

	@Override
	public Page<AttractionReview> findByAttractionAttractionNo(Long attractionNo, Pageable pageable) {
		return attractionServiceDao.findByAttractionAttractionNo(attractionNo, pageable);
	}

	@Override
	public Page<AttractionReview> findByAttractionAttractionNoOrderByArStarDesc(Long attractionNo, Pageable pageable) {
		return attractionServiceDao.findByAttractionAttractionNoOrderByArStarDesc(attractionNo, pageable);
	}

	@Override
	public Page<AttractionReview> findByAttractionAttractionNoOrderByArStarAsc(Long attractionNo, Pageable pageable) {
		return attractionServiceDao.findByAttractionAttractionNoOrderByArStarAsc(attractionNo, pageable);
	}

	@Override
	public Page<AttractionReview> findByAttractionAttractionNoOrderByArDateDesc(Long attractionNo, Pageable pageable) {
		return attractionServiceDao.findByAttractionAttractionNoOrderByArDateDesc(attractionNo, pageable);
	}

	@Override
	public Page<AttractionReview> findByAttractionAttractionNoOrderByArDateAsc(Long attractionNo, Pageable pageable) {
		return attractionServiceDao.findByAttractionAttractionNoOrderByArDateAsc(attractionNo, pageable);
	}
	*/

	/*
	@Override
	public Double calculateAverageStarRatingWithFloor(Long attractionNo) {
		return attractionServiceDao.calculateAverageStarRatingWithFloor(attractionNo);
	}
	*/
}
