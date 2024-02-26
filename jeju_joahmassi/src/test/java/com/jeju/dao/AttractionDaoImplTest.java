package com.jeju.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.entity.Attraction;

import jakarta.transaction.Transactional;

class AttractionDaoImplTest extends JejuJoahmassiApplicationTests {

	@Autowired
	private AttractionDao attractionDao;

	// 명소 추가
	@Test
	@Disabled
	void testInserAttraction() {
		
		Attraction attraction1 = Attraction.builder()
								.attractionAddress("서울")
								.attractionName("에버랜드")
								.attractionStar(5)
								.build();
		attractionDao.insertAttraction(attraction1);
		
		
		Attraction attraction2 = Attraction.builder()
								.attractionAddress("강원")
								.attractionName("레고랜드")
								.attractionStar(5)
								.build();
		attractionDao.insertAttraction(attraction2);

		Attraction attraction3 = Attraction.builder()
								.attractionAddress("부산")
								.attractionName("롯데월드")
								.attractionStar(5)
								.build();
		attractionDao.insertAttraction(attraction3);
	}
	
	// 명소 삭제
	@Test
	@Disabled
	@Rollback(false)
	void testDeleteAttraction() {
		attractionDao.deleteAttraction(6L);
	}
	
	// 명소 수정
	@Test
	@Disabled
	void testUpdateAttraction() {
		Attraction attraction1 = Attraction.builder()
								.attractionNo(5L)
								.attractionAddress("서울2")
								.attractionName("에버랜드2")
								.attractionStar(4)
								.build();
		attractionDao.insertAttraction(attraction1);
	}
	
	// 명소 리스트
	@Test
	@Disabled
	@Transactional
	void testAttractionList() {
		System.out.println(attractionDao.findAll());
	}
	
	// 명소 찾기
	@Test
	@Disabled
	@Transactional
	void testFindByAttractionNo() {
		System.out.println(attractionDao.findByAttractionNo(5L));
	}
	
	/*
	// 명소 페이징
	@Test
	@Disabled
	@Transactional
	void testAttractionFindAllPage() {
		Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Order.desc("attractionNo")));
		Page<Attraction> page = attractionDao.findAllPage(pageable);
		System.out.println(page.getContent());
	}
	
	// 명소 이름 검색
	@Test
	@Disabled
	@Transactional
	void testFindByAttractionNameLike() {
		Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Order.desc("attractionNo")));
		Page<Attraction> page = attractionDao.findByAttractionNameLike("%에버%", pageable);
		System.out.println(page.getContent());
	}
	
	// 명소 주소 검색
	@Test
	@Disabled
	@Transactional
	void testFindByAttractionAddressLike() {
		Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Order.desc("attractionNo")));
		Page<Attraction> page = attractionDao.findByAttractionAddressLike("%부산%", pageable);
		System.out.println(page.getContent());
	}
	*/
}
