package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jeju.dao.HotelReviewDao;
import com.jeju.entity.HotelReview;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class HotelReviewServiceImpl implements HotelReviewService{

	@Autowired
	HotelReviewDao hotelReviewDao;
	
	@Override
	public HotelReview insertHr(HotelReview review) {
		return hotelReviewDao.insertHr(review);
	}

	@Override
	public HotelReview findByHrNo(Long hrNo) {
		return hotelReviewDao.findByHrNo(hrNo);
	}

	@Override
	public HotelReview updateHr(HotelReview updateHr) {
		return hotelReviewDao.updateHr(updateHr);
	}

	@Override
	public void deleteByHrNo(Long hrNo) {
		hotelReviewDao.deleteByHrNo(hrNo);
	}

	@Override
	public List<HotelReview> findAll() {
		return hotelReviewDao.findAll();
	}

	@Override
	public Page<HotelReview> findByUserinfoUserNo(Long userNo, Pageable pageable) {
		return hotelReviewDao.findByUserinfoUserNo(userNo, pageable);
	}

	@Override
	public Page<HotelReview> findByHotelHotelNo(Long hotelNo, Pageable pageable) {
		return hotelReviewDao.findByHotelHotelNo(hotelNo, pageable);
	}

	@Override
	public Page<HotelReview> findByHotelHotelNoOrderByHrStarDesc(Long hotelNo, Pageable pageable) {
		return hotelReviewDao.findByHotelHotelNoOrderByHrStarDesc(hotelNo, pageable);
	}

	@Override
	public Page<HotelReview> findByHotelHotelNoOrderByHrStarAsc(Long hotelNo, Pageable pageable) {
		return hotelReviewDao.findByHotelHotelNoOrderByHrStarAsc(hotelNo, pageable);
	}

	@Override
	public Page<HotelReview> findByHotelHotelNoOrderByHrDateDesc(Long hotelNo, Pageable pageable) {
		return hotelReviewDao.findByHotelHotelNoOrderByHrDateDesc(hotelNo, pageable);
	}

	@Override
	public Page<HotelReview> findByHotelHotelNoOrderByHrDateAsc(Long hotelNo, Pageable pageable) {
		return hotelReviewDao.findByHotelHotelNoOrderByHrDateAsc(hotelNo, pageable);
	}

	@Override
	public List<HotelReview> findByUserinfoUserNo(Long userNo) {
		return hotelReviewDao.findByUserinfoUserNo(userNo);
	}

	@Override
	public List<HotelReview> findByHotelHotelNo(Long hotelNo) {
		return hotelReviewDao.findByHotelHotelNo(hotelNo);
	}

	@Override
	public List<HotelReview> findByHotelHotelNoOrderByHrStarDesc(Long hotelNo) {
		return hotelReviewDao.findByHotelHotelNoOrderByHrStarDesc(hotelNo);
	}

	@Override
	public List<HotelReview> findByHotelHotelNoOrderByHrStarAsc(Long hotelNo) {
		return hotelReviewDao.findByHotelHotelNoOrderByHrStarAsc(hotelNo);
	}

	@Override
	public List<HotelReview> findByHotelHotelNoOrderByHrDateDesc(Long hotelNo) {
		return hotelReviewDao.findByHotelHotelNoOrderByHrDateDesc(hotelNo);
	}

	@Override
	public List<HotelReview> findByHotelHotelNoOrderByHrDateAsc(Long hotelNo) {
		return hotelReviewDao.findByHotelHotelNoOrderByHrDateAsc(hotelNo);
	}

	@Override
	public List<HotelReview> findByUserinfoUserNoAndHotelHotelNo(Long userNo, Long hotelNo) {
		return hotelReviewDao.findByUserinfoUserNoAndHotelHotelNo(userNo, hotelNo);
	}
	
	@Override
	public List<HotelReview> findByHotelHotelNoOrderByHrNoDesc(Long hotelNo) {
		return hotelReviewDao.findByHotelHotelNoOrderByHrNoDesc(hotelNo);
	}
	/*
	@Override
	public Double findAverageHrStarByHotel_HotelNo(Long hotelNo) {
		return null;
	}
	*/
}
