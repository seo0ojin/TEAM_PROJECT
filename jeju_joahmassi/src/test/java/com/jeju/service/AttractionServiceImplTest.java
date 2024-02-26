package com.jeju.service;

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

class AttractionServiceImplTest extends JejuJoahmassiApplicationTests {
	
	@Autowired
	private AttractionService attractionService;
	
	// 명소 추가
	@Test
	@Disabled
	void testInsertAttraction() {
		Attraction attraction1 = Attraction.builder()
				.attractionAddress("서울3")
				.attractionName("에버랜드3")
				.attractionStar(5)
				.build();
		attractionService.insertAttraction(attraction1);

		Attraction attraction2 = Attraction.builder()
				.attractionAddress("강원2")
				.attractionName("레고랜드2")
				.attractionStar(5)
				.build();
		attractionService.insertAttraction(attraction2);

		Attraction attraction3 = Attraction.builder()
				.attractionAddress("부산2")
				.attractionName("롯데월드2")
				.attractionStar(5)
				.build();
		attractionService.insertAttraction(attraction3);
	}
	
	// 명소 삭제
	@Test
	@Disabled
	@Rollback(false)
	void testDeleteAttraction() {
		
		attractionService.deleteAttraction(9L);
	}
	
	// 명소 수정
	@Test
	@Disabled
	void testUpdateAttraction() {
		Attraction attraction2 = Attraction.builder()
				.attractionNo(10L)
				.attractionAddress("강원3")
				.attractionName("레고랜드3")
				.attractionStar(5)
				.build();
		attractionService.insertAttraction(attraction2);
	}
	
	// 명소 리스트
	@Test
	@Disabled
	@Transactional
	void testFindAll() {
		System.out.println(attractionService.findAll());
	}
	
	// 명소 찾기
	@Test
	@Disabled
	@Transactional
	void testFindByAttractionNo() {
		System.out.println(attractionService.findByAttractionNo(11L));
	}
	
	/*
	// 명소 페이징
	@Test
	@Disabled
	@Transactional
	void testFindAllPage() {
		Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Order.desc("attractionNo")));
		Page<Attraction> page = attractionService.findAllPage(pageable);
		System.out.println(page.getContent());
	}
	
	// 명소 이름 검색
	@Test
	//@Disabled
	@Transactional
	void testFindByAttractionNameLike() {
		Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Order.desc("attractionNo")));
		Page<Attraction> page = attractionService.findByAttractionNameLike("스누피", pageable);
		System.out.println(page.getContent());
	}
	
	// 명소 주소 검색
	@Test
	@Disabled
	@Transactional
	void testFindByAttractionAddressLike() {
		Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Order.desc("attractionNo")));
		Page<Attraction> page = attractionService.findByAttractionAddressLike("강", pageable);
		System.out.println(page.getContent());
	}
	*/
}
