package com.jeju.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.entity.RestaurantMenu;
import com.jeju.service.RestaurantService;

import jakarta.transaction.Transactional;

class RestaurantMenuDaoImplTest extends JejuJoahmassiApplicationTests{
	
	@Autowired
	private RestaurantMenuDao restaurantMenuDao;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testInsert() {
		restaurantMenuDao.insert(RestaurantMenu.builder()
												.restaurant(restaurantService.findByNo(1L))
												.rmImage(null)
												.rmName("삼겹살")
												.rmPrice(14000)
												.build());
	}

	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testDeleteByNo() {
		restaurantMenuDao.deleteByNo(1L);
	}

	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testUpdate() {
		restaurantMenuDao.update(RestaurantMenu.builder()
								.restaurant(restaurantService.findByNo(1L))
								.rmImage(null)
								.rmName("삼겹살")
								.rmPrice(16000)
								.rmNo(1L)
								.build());
	}

	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindAll() {
		System.out.println(restaurantMenuDao.findAll());
	}

	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindByNo() {
		System.out.println(restaurantMenuDao.findByNo(1L));
	}

	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindByRestaurantRestaurantNo() {
		System.out.println(restaurantMenuDao.findByRestaurantRestaurantNo(1L));
	}

}
