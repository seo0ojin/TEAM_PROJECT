package com.jeju.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.entity.RestaurantCategory;

import jakarta.transaction.Transactional;

class RestaurantCategoryServiceImplTest extends JejuJoahmassiApplicationTests{
	
	@Autowired
	private RestaurantCategoryService restaurantCategoryService;
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testInsert() {
		restaurantCategoryService.insert(RestaurantCategory.builder()
															.rcName("고깃집")
															.build());
		
		restaurantCategoryService.insert(RestaurantCategory.builder()
															.rcName("카페")
															.build());
	}
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testDelete() {
		restaurantCategoryService.delete(3L);
	}
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testUpdate() {
		restaurantCategoryService.update(RestaurantCategory.builder()
															.rcNo(2L)
															.rcName("고깃집")
															.build());
	}
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindAll() {
		System.out.println(restaurantCategoryService.findAll());
	}
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindByNo() {
		System.out.println(restaurantCategoryService.findByNo(1L));
	}

}
