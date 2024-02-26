package com.jeju.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.jeju.entity.AttractionReview;
import com.jeju.repository.AttractionReviewRepository;

@Repository
public class AttractionReviewDaoImpl implements AttractionReviewDao{

	@Autowired
	private AttractionReviewRepository attractionReviewRepository;
	
	@Override
	public AttractionReview insert(AttractionReview review) {
		return attractionReviewRepository.save(review);
	}

	@Override
	public AttractionReview findByArNo(Long arNo) {
		return attractionReviewRepository.findById(arNo).get();
	}

	@Override
	public AttractionReview update(AttractionReview update) {
		return attractionReviewRepository.save(update);
	}

	@Override
	public void deleteByArNo(Long arNo) {
		attractionReviewRepository.deleteById(arNo);
	}

	@Override
	public List<AttractionReview> findAll() {
		return attractionReviewRepository.findAll();
	}

	@Override
	public List<AttractionReview> findByUserinfoUserNo(Long userNo) {
		
		return attractionReviewRepository.findByUserinfoUserNo(userNo);
	}

	@Override
	public List<AttractionReview> findByAttractionAttractionNo(Long attractionNo) {
		
		return attractionReviewRepository.findByAttractionAttractionNo(attractionNo);
	}

	@Override
	public List<AttractionReview> findByAttractionAttractionNoOrderByArStarDesc(Long attractionNo) {
		
		return attractionReviewRepository.findByAttractionAttractionNoOrderByArStarDesc(attractionNo);
	}

	@Override
	public List<AttractionReview> findByAttractionAttractionNoOrderByArStarAsc(Long attractionNo) {
		
		return attractionReviewRepository.findByAttractionAttractionNoOrderByArStarAsc(attractionNo);
	}

	@Override
	public List<AttractionReview> findByAttractionAttractionNoOrderByArDateDesc(Long attractionNo) {
		
		return attractionReviewRepository.findByAttractionAttractionNoOrderByArDateDesc(attractionNo);
	}

	@Override
	public List<AttractionReview> findByAttractionAttractionNoOrderByArDateAsc(Long attractionNo) {
		
		return attractionReviewRepository.findByAttractionAttractionNoOrderByArDateAsc(attractionNo);
	}
	
	/*
	@Override
	public Page<AttractionReview> findByUserinfoUserNo(Long userNo, Pageable pageable) {
		return attractionReviewRepository.findByUserinfoUserNo(userNo, pageable);
	}

	@Override
	public Page<AttractionReview> findByAttractionAttractionNo(Long attractionNo, Pageable pageable) {
		return attractionReviewRepository.findByAttractionAttractionNo(attractionNo, pageable);
	}

	@Override
	public Page<AttractionReview> findByAttractionAttractionNoOrderByArStarDesc(Long attractionNo, Pageable pageable) {
		return attractionReviewRepository.findByAttractionAttractionNoOrderByArStarDesc(attractionNo, pageable);
	}

	@Override
	public Page<AttractionReview> findByAttractionAttractionNoOrderByArStarAsc(Long attractionNo, Pageable pageable) {
		return attractionReviewRepository.findByAttractionAttractionNoOrderByArStarAsc(attractionNo, pageable);
	}

	@Override
	public Page<AttractionReview> findByAttractionAttractionNoOrderByArDateDesc(Long attractionNo, Pageable pageable) {
		return attractionReviewRepository.findByAttractionAttractionNoOrderByArDateDesc(attractionNo, pageable);
	}

	@Override
	public Page<AttractionReview> findByAttractionAttractionNoOrderByArDateAsc(Long attractionNo, Pageable pageable) {
		return attractionReviewRepository.findByAttractionAttractionNoOrderByArDateAsc(attractionNo, pageable);
	}
	*/
	
	/*
	@Override
	public Double calculateAverageStarRatingWithFloor(Long attractionNo) {
		return attractionReviewRepository.calculateAverageStarRatingWithFloor(attractionNo);
	}
	*/
}
