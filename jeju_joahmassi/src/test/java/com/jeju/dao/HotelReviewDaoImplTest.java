package com.jeju.dao;


import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.entity.HotelReview;

import jakarta.transaction.Transactional;

public class HotelReviewDaoImplTest extends JejuJoahmassiApplicationTests{

	@Autowired
	HotelReviewDao hotelReviewDao;
	@Autowired
	HotelDao hotelDao;
	@Autowired
	UserinfoDao userinfoDao;
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testInsertHr() {
		HotelReview review1 = HotelReview.builder()
				.hrNo(null)
				.hrContent("내가 해둔거 삭제됨")
				.hrDate(LocalDate.of(2023, 12, 11))
				.hrStar(3.0)
				.hotel(hotelDao.findByHotelNo(1L))
				.userinfo(userinfoDao.findByUserNo(1L))
				.build();
		hotelReviewDao.insertHr(review1);
		
		HotelReview review2 = HotelReview.builder()
				.hrNo(null)
				.hrContent("진짜 개열받아")
				.hrDate(LocalDate.of(2023, 12, 11))
				.hrStar(3.0)
				.hotel(hotelDao.findByHotelNo(2L))
				.userinfo(userinfoDao.findByUserNo(2L))
				.build();
		hotelReviewDao.insertHr(review2);
		
		HotelReview review3 = HotelReview.builder()
				.hrNo(null)
				.hrContent("정말 너무 슬퍼요")
				.hrDate(LocalDate.of(2023, 12, 11))
				.hrStar(3.0)
				.hotel(hotelDao.findByHotelNo(2L))
				.userinfo(userinfoDao.findByUserNo(2L))
				.build();
		hotelReviewDao.insertHr(review3);
		
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindByHrNo() {
		System.out.println(hotelReviewDao.findByHrNo(1L));
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testUpdateHr() {
		HotelReview find = hotelReviewDao.findByHrNo(1L);
		find.setHrContent("테스트 하는 중");
		System.out.println(find);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testDeleteByHrNo() {
		hotelReviewDao.deleteByHrNo(3L);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindAll() {
		System.out.println(hotelReviewDao.findAll());
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindByUserinfoUserNo() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hrDate")));
		System.out.println(hotelReviewDao.findByUserinfoUserNo(1L, pageable));
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindByHotelHotelNo() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hrDate")));
		System.out.println(hotelReviewDao.findByHotelHotelNo(1L, pageable));
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindByHotelHotelNoOrderByHrStarDesc() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hrDate")));
		System.out.println(hotelReviewDao.findByHotelHotelNoOrderByHrStarDesc(1L, pageable));
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindByHotelHotelNoOrderByHrStarAsc() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hrDate")));
		System.out.println(hotelReviewDao.findByHotelHotelNoOrderByHrStarAsc(1L, pageable));
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindByHotelHotelNoOrderByHrDateDesc() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hrDate")));
		System.out.println(hotelReviewDao.findByHotelHotelNoOrderByHrDateDesc(1L, pageable));
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindByHotelHotelNoOrderByHrDateAsc() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hrDate")));
		System.out.println(hotelReviewDao.findByHotelHotelNoOrderByHrDateAsc(1L, pageable));
	
	}

}
