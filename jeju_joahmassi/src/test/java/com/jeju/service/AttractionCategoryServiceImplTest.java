package com.jeju.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.entity.AttractionCategory;

import jakarta.transaction.Transactional;

class AttractionCategoryServiceImplTest extends JejuJoahmassiApplicationTests {
	
	@Autowired
	private AttractionCategoryService attractionCategoryService;
	
	// 명소 카테고리 추가
	@Test
	@Disabled
	void testInsert() {
		AttractionCategory attractionCategory1 = AttractionCategory.builder()
													.acName("놀이동산")
													.build();
		attractionCategoryService.insert(attractionCategory1);
		
		AttractionCategory attractionCategory2 = AttractionCategory.builder()
													.acName("해수욕장")
													.build();
		attractionCategoryService.insert(attractionCategory2);
		
		AttractionCategory attractionCategory3 = AttractionCategory.builder()
													.acName("미술관")
													.build();
		attractionCategoryService.insert(attractionCategory3);
	}
	
	// 명소 카테고리 삭제
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testDelete() {
		attractionCategoryService.delete(6L);
	}
	
	// 명소 카테고리 수정
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testUpdate() {
		AttractionCategory attractionCategory1 = AttractionCategory.builder()
													.acNo(5L)
													.acName("고궁")
													.build();
		attractionCategoryService.insert(attractionCategory1);
	}
	
	// 명소 카테고리 리스트
	@Test
	@Disabled
	@Transactional
	void testFindAll() {
		System.out.println(attractionCategoryService.findAll());
	}
	
	// 명소 카테고리 찾기
	@Test
	@Disabled
	@Transactional
	void testFindByNo() {
		System.out.println(attractionCategoryService.findByNo(4L));
	}

}
