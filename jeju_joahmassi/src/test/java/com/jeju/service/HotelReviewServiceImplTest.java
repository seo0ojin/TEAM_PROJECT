package com.jeju.service;


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

class HotelReviewServiceImplTest extends JejuJoahmassiApplicationTests{

	@Autowired
	HotelReviewService hotelReviewService;
	@Autowired
	HotelService hotelService;
	@Autowired
	UserinfoService userinfoService;
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testInsertHr() {
		HotelReview review1 = HotelReview.builder()
				.hrNo(null)
				.hrContent("이것만 하면")
				.hrDate(LocalDate.of(2023, 12, 11))
				.hrStar(2.0)
				.hotel(hotelService.findByHotelNo(1L))
				.userinfo(userinfoService.findByUserNo(1L))
				.build();
		hotelReviewService.insertHr(review1);
		
		HotelReview review2 = HotelReview.builder()
				.hrNo(null)
				.hrContent("잘 수 있어")
				.hrDate(LocalDate.of(2023, 12, 11))
				.hrStar(1.0)
				.hotel(hotelService.findByHotelNo(2L))
				.userinfo(userinfoService.findByUserNo(2L))
				.build();
		hotelReviewService.insertHr(review2);
		
		HotelReview review3 = HotelReview.builder()
				.hrNo(null)
				.hrContent("목이 너무 아파요")
				.hrDate(LocalDate.of(2023, 12, 11))
				.hrStar(3.0)
				.hotel(hotelService.findByHotelNo(3L))
				.userinfo(userinfoService.findByUserNo(2L))
				.build();
		hotelReviewService.insertHr(review3);
		
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindByHrNo() {
		System.out.println(hotelReviewService.findByHrNo(1L));
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testUpdateHr() {
		HotelReview find = hotelReviewService.findByHrNo(1L);
		find.setHrContent("테스트 하는 중");
		System.out.println(find);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testDeleteByHrNo() {
		hotelReviewService.deleteByHrNo(3L);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindAll() {
		System.out.println(hotelReviewService.findAll());
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindByUserinfoUserNo() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hrDate")));
		System.out.println(hotelReviewService.findByUserinfoUserNo(1L, pageable));
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindByHotelHotelNo() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hrDate")));
		System.out.println(hotelReviewService.findByHotelHotelNo(1L, pageable));
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindByHotelHotelNoOrderByHrStarDesc() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hrDate")));
		System.out.println(hotelReviewService.findByHotelHotelNoOrderByHrStarDesc(1L, pageable));
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindByHotelHotelNoOrderByHrStarAsc() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hrDate")));
		System.out.println(hotelReviewService.findByHotelHotelNoOrderByHrStarAsc(1L, pageable));
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindByHotelHotelNoOrderByHrDateDesc() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hrDate")));
		System.out.println(hotelReviewService.findByHotelHotelNoOrderByHrDateDesc(1L, pageable));
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindByHotelHotelNoOrderByHrDateAsc() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hrDate")));
		System.out.println(hotelReviewService.findByHotelHotelNoOrderByHrDateAsc(1L, pageable));
	
	}
	
}
