package com.jeju.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.jeju.entity.HotelReview;
import com.jeju.repository.HotelReviewRepository;

@Repository
public class HotelReviewDaoImpl implements HotelReviewDao{

	@Autowired
	HotelReviewRepository hotelReviewRepository;
	
	@Override
	public HotelReview insertHr(HotelReview review) {
		return hotelReviewRepository.save(review);
	}

	@Override
	public HotelReview findByHrNo(Long hrNo) {
		return hotelReviewRepository.findById(hrNo).get();
	}

	@Override
	public HotelReview updateHr(HotelReview updateHr) {
		return hotelReviewRepository.save(updateHr);
	}

	@Override
	public void deleteByHrNo(Long hrNo) {
		hotelReviewRepository.deleteById(hrNo);
	}

	@Override
	public List<HotelReview> findAll() {
		return hotelReviewRepository.findAll();
	}

	@Override
	public Page<HotelReview> findByUserinfoUserNo(Long userNo, Pageable pageable) {
		return hotelReviewRepository.findByUserinfoUserNo(userNo, pageable);
	}

	@Override
	public Page<HotelReview> findByHotelHotelNo(Long hotelNo, Pageable pageable) {
		return hotelReviewRepository.findByHotelHotelNo(hotelNo, pageable);
	}

	@Override
	public Page<HotelReview> findByHotelHotelNoOrderByHrStarDesc(Long hotelNo, Pageable pageable) {
		return hotelReviewRepository.findByHotelHotelNoOrderByHrStarDesc(hotelNo, pageable);
	}

	@Override
	public Page<HotelReview> findByHotelHotelNoOrderByHrStarAsc(Long hotelNo, Pageable pageable) {
		return hotelReviewRepository.findByHotelHotelNoOrderByHrStarAsc(hotelNo, pageable);
	}

	@Override
	public Page<HotelReview> findByHotelHotelNoOrderByHrDateDesc(Long hotelNo, Pageable pageable) {
		return hotelReviewRepository.findByHotelHotelNoOrderByHrDateDesc(hotelNo, pageable);
	}

	@Override
	public Page<HotelReview> findByHotelHotelNoOrderByHrDateAsc(Long hotelNo, Pageable pageable) {
		return hotelReviewRepository.findByHotelHotelNoOrderByHrDateAsc(hotelNo, pageable);
	}

	@Override
	public List<HotelReview> findByUserinfoUserNo(Long userNo) {
		return hotelReviewRepository.findByUserinfoUserNo(userNo);
	}

	@Override
	public List<HotelReview> findByHotelHotelNo(Long hotelNo) {
		return hotelReviewRepository.findByHotelHotelNo(hotelNo);
	}

	@Override
	public List<HotelReview> findByHotelHotelNoOrderByHrStarDesc(Long hotelNo) {
		return hotelReviewRepository.findByHotelHotelNoOrderByHrStarDesc(hotelNo);
	}

	@Override
	public List<HotelReview> findByHotelHotelNoOrderByHrStarAsc(Long hotelNo) {
		return hotelReviewRepository.findByHotelHotelNoOrderByHrStarAsc(hotelNo);
	}

	@Override
	public List<HotelReview> findByHotelHotelNoOrderByHrDateDesc(Long hotelNo) {
		return hotelReviewRepository.findByHotelHotelNoOrderByHrDateDesc(hotelNo);
	}

	@Override
	public List<HotelReview> findByHotelHotelNoOrderByHrDateAsc(Long hotelNo) {
		return hotelReviewRepository.findByHotelHotelNoOrderByHrDateAsc(hotelNo);
	}

	@Override
	public List<HotelReview> findByUserinfoUserNoAndHotelHotelNo(Long userNo, Long hotelNo) {
		return hotelReviewRepository.findByUserinfoUserNoAndHotelHotelNo(userNo, hotelNo);
	}
	
	@Override
	public List<HotelReview> findByHotelHotelNoOrderByHrNoDesc(Long hotelNo) {
		return hotelReviewRepository.findByHotelHotelNoOrderByHrNoDesc(hotelNo);
	}

}
