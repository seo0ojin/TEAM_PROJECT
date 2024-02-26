package com.jeju.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.entity.RestaurantMenu;

import jakarta.transaction.Transactional;

class RestaurantMenuServiceImplTest extends JejuJoahmassiApplicationTests{
	
	@Autowired
	private RestaurantMenuService restaurantMenuService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testInsert() {
		restaurantMenuService.insert(RestaurantMenu.builder()
				.restaurant(restaurantService.findByNo(2L))
				.rmImage(null)
				.rmName("아메리카노")
				.rmPrice(4500)
				.build());
	}

	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testDeleteByNo() {
		restaurantMenuService.deleteByNo(2L);
	}

	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testUpdate() {
		restaurantMenuService.update(RestaurantMenu.builder()
									.restaurant(restaurantService.findByNo(2L))
									.rmImage(null)
									.rmName("아메리카노")
									.rmPrice(5000)
									.rmNo(1L)
									.build());
	}

	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindAll() {
		System.out.println(restaurantMenuService.findAll());
	}

	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindByNo() {
		System.out.println(restaurantMenuService.findByNo(1L));
	}

	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindByRestaurantRestaurantNo() {
		System.out.println(restaurantMenuService.findByRestaurantRestaurantNo(2L));
	}

}
