package com.jeju.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.entity.RestaurantCategoryItem;

import jakarta.transaction.Transactional;

class RestaurantCategoryItemServiceImplTest extends JejuJoahmassiApplicationTests{
	
	@Autowired
	private RestaurantCategoryItemService restaurantCategoryItemService;
	
	@Autowired
	private RestaurantCategoryService restaurantCategoryService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testInsert() {
		restaurantCategoryItemService.insert(RestaurantCategoryItem.builder()
				.restaurant(restaurantService.findByNo(1L))
				.restaurantCategory(restaurantCategoryService.findByNo(1L))
				.build());
		restaurantCategoryItemService.insert(RestaurantCategoryItem.builder()
				.restaurant(restaurantService.findByNo(2L))
				.restaurantCategory(restaurantCategoryService.findByNo(2L))
				.build());
	}
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testDeleteByNo() {
		restaurantCategoryItemService.deleteByNo(3L);
		restaurantCategoryItemService.deleteByNo(4L);
	}
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testUpdate() {
		restaurantCategoryItemService.update(RestaurantCategoryItem.builder()
												.rciNo(2L)
												.restaurant(restaurantService.findByNo(2L))
												.restaurantCategory(restaurantCategoryService.findByNo(1L))
												.build());
	}
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindAll() {
		System.out.println(restaurantCategoryItemService.findAll());
	}
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindByNo() {
		System.out.println(restaurantCategoryItemService.findByNo(1L));
	}
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindByRestaurantRestaurantNo() {
		System.out.println(restaurantCategoryItemService.findByRestaurantRestaurantNo(2L));
	}

}
