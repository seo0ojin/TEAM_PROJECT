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
import com.jeju.entity.AttractionCategoryItem;

import jakarta.transaction.Transactional;

class AttractionCategoryItemServiceImplTest extends JejuJoahmassiApplicationTests{
	
	@Autowired
	private AttractionCategoryItemService attractionCategoryItemService;
	
	@Autowired
	private AttractionCategoryService attractionCategoryService;
	@Autowired
	private AttractionService attractionService;
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testInsert() {
		attractionCategoryItemService.insert(AttractionCategoryItem.builder()
				.attraction(attractionService.findByAttractionNo(11L))
				.attractionCategory(attractionCategoryService.findByNo(4L))
				.build());
		
		attractionCategoryItemService.insert(AttractionCategoryItem.builder()
				.attraction(attractionService.findByAttractionNo(11L))
				.attractionCategory(attractionCategoryService.findByNo(5L))
				.build());
	}

	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testDeleteByNo() {
		attractionCategoryItemService.deleteByNo(7L);
		attractionCategoryItemService.deleteByNo(8L);
	}

	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testUpdate() {
		attractionCategoryItemService.update(AttractionCategoryItem.builder()
				.aciNo(3L)
				.attraction(attractionService.findByAttractionNo(8L))
				.attractionCategory(attractionCategoryService.findByNo(5L))
				.build());
	}

	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindByNo() {
		System.out.println(attractionCategoryItemService.findByNo(1L));
		
	}

	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindAll() {
		System.out.println(attractionCategoryItemService.findAll());
	}

	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindByAttractionAttractionNo() {
		Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Order.desc("aciNo")));
		Page<AttractionCategoryItem> page = attractionCategoryItemService.findByAttractionAttractionNo(11L, pageable);
		System.out.println(page.getContent());
	}

	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindByAttractionCategoryAcNo() {
		Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Order.desc("aciNo")));
		Page<AttractionCategoryItem> page = attractionCategoryItemService.findByAttractionCategoryAcNo(4L, pageable);
		System.out.println(page.getContent());
	}

}
