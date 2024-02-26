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
import com.jeju.entity.AttractionReview;

import jakarta.transaction.Transactional;

class AttractionReviewServiceImplTest extends JejuJoahmassiApplicationTests{

	@Autowired
	AttractionReviewService attractionReviewService;
	@Autowired
	AttractionService attractionService;
	@Autowired
	UserinfoService userinfoService;
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testInsert() {
		AttractionReview review1 = AttractionReview.builder()
				.arNo(null)
				.arContent("그만할래요")
				.arDate(LocalDate.now())
				.arStar(5.0)
				.attraction(attractionService.findByAttractionNo(10L))
				.userinfo(userinfoService.findByUserNo(1L))
				.build();
		attractionReviewService.insert(review1);
		
		AttractionReview review2 = AttractionReview.builder()
				.arNo(null)
				.arContent("왜 끝이없어")
				.arDate(LocalDate.now())
				.arStar(2.0)
				.attraction(attractionService.findByAttractionNo(8L))
				.userinfo(userinfoService.findByUserNo(2L))
				.build();
		attractionReviewService.insert(review2);
		
		AttractionReview review3 = AttractionReview.builder()
				.arNo(null)
				.arContent("나한테 왜이래 ~")
				.arDate(LocalDate.now())
				.arStar(1.0)
				.attraction(attractionService.findByAttractionNo(11L))
				.userinfo(userinfoService.findByUserNo(3L))
				.build();
		attractionReviewService.insert(review3);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindByArNo() {
		System.out.println(attractionReviewService.findByArNo(1L));
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testUpdate() {
		AttractionReview find = attractionReviewService.findByArNo(1L);
		find.setArContent("수정 됐냐고요");
		System.out.println(find);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testDeleteByArNo() {
		attractionReviewService.deleteByArNo(4L);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindAll() {
		System.out.println(attractionReviewService.findAll());
	}
	/*
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindByUserinfoUserNo() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("arDate")));
		System.out.println(attractionReviewService.findByUserinfoUserNo(1L, pageable).getContent());
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindByAttractionAttractionNo() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("arDate")));
		System.out.println(attractionReviewService.findByAttractionAttractionNo(4L, pageable).getContent());
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindByAttractionAttractionNoOrderByArStarDesc() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("arStar")));
		System.out.println(attractionReviewService.findByAttractionAttractionNoOrderByArStarDesc(4L, pageable).getContent());
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindByAttractionAttractionNoOrderByArStarAsc() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("arStar")));
		System.out.println(attractionReviewService.findByAttractionAttractionNoOrderByArStarAsc(1L, pageable).getContent());
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindByAttractionAttractionNoOrderByArDateDesc() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("arDate")));
		System.out.println(attractionReviewService.findByAttractionAttractionNoOrderByArDateDesc(1L, pageable).getContent());
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testFindByAttractionAttractionNoOrderByArDateAsc() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("arDate")));
		System.out.println(attractionReviewService.findByAttractionAttractionNoOrderByArDateAsc(1L, pageable).getContent());
	}
	*/
	/*
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	// 테스트 죽어도 안된다 살려줘
	void calculateAverageStarRatingWithFloor() {
		System.out.println(attractionReviewService.calculateAverageStarRatingWithFloor(4L));
	}
	*/

}
