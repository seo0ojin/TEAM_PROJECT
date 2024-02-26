package com.jeju.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.entity.RestaurantCategory;

import jakarta.transaction.Transactional;

class RestaurantCategoryDaoImplTest extends JejuJoahmassiApplicationTests{
	
	@Autowired
	private RestaurantCategoryDao restaurantCategoryDao;
	
	@Disabled
	@Test
	void testInsert() {
		restaurantCategoryDao.insert(RestaurantCategory.builder()
														.rcName("고깃집")
														.build());
	}
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testDelete() {
		restaurantCategoryDao.delete(1L);
	}
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testUpdate() {
		restaurantCategoryDao.update(RestaurantCategory.builder()
														.rcNo(1L)
														.rcName("해산물")
														.build());
	}
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindAll() {
		System.out.println(restaurantCategoryDao.findAll());
	}
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindByNo() {
		System.out.println(restaurantCategoryDao.findByNo(1L));
	}

}
