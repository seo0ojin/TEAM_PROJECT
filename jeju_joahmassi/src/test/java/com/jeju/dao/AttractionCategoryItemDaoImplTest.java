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
import com.jeju.entity.AttractionCategoryItem;
import com.jeju.service.AttractionCategoryService;
import com.jeju.service.AttractionService;

import jakarta.transaction.Transactional;

class AttractionCategoryItemDaoImplTest extends JejuJoahmassiApplicationTests {

	@Autowired
	private AttractionCategoryItemDao attractionCategoryItemDao;
	@Autowired
	private AttractionCategoryService attractionCategoryService;
	@Autowired
	private AttractionService attractionService;
	
	// 카테고리 아이템 추가
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testInsert() {
		attractionCategoryItemDao.insert(AttractionCategoryItem.builder()
				.attraction(attractionService.findByAttractionNo(11L))
				.attractionCategory(attractionCategoryService.findByNo(4L))
				.build());
		
		attractionCategoryItemDao.insert(AttractionCategoryItem.builder()
				.attraction(attractionService.findByAttractionNo(11L))
				.attractionCategory(attractionCategoryService.findByNo(5L))
				.build());
	}
	
	// 카테고리 아이템 삭제
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testDeleteByNo() {
		attractionCategoryItemDao.deleteByNo(4L);
	}
	
	// 카테고리 아이템 수정
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testUpdate() {
		attractionCategoryItemDao.update(AttractionCategoryItem.builder()
				.aciNo(3L)
				.attraction(attractionService.findByAttractionNo(10L))
				.attractionCategory(attractionCategoryService.findByNo(5L))
				.build());
	}
	
	// 카테고리 아이템 찾기
	@Test
	@Disabled
	@Transactional
	void testFindByNo() {
		System.out.println(attractionCategoryItemDao.findByNo(3L));
	}
	
	// 카테고리 아이템 리스트
	@Test
	@Disabled
	@Transactional
	void testFindAll() {
		System.out.println(attractionCategoryItemDao.findAll());
	}
	
	// 명소 번호로 카테고리 아이템 찾기
	@Test
	@Disabled
	@Transactional
	void testFindByAttractionAttractionNo() {
		Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Order.desc("aciNo")));
		Page<AttractionCategoryItem> page = attractionCategoryItemDao.findByAttractionAttractionNo(11L, pageable);
		System.out.println(page.getContent());
	}
	
	// 카테고리 번호로 카테고리 아이템 찾기
	@Test
	@Disabled
	@Transactional
	void testFindByAttractionCategoryAcNo() {
		Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Order.desc("aciNo")));
		Page<AttractionCategoryItem> page = attractionCategoryItemDao.findByAttractionCategoryAcNo(4L, pageable);
		System.out.println(page.getContent());
	}

}
