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
import com.jeju.entity.RestaurantCategoryItem;
import com.jeju.entity.RestaurantReview;
import com.jeju.service.RestaurantCategoryService;
import com.jeju.service.RestaurantService;

import jakarta.transaction.Transactional;

class RestaurantCategoryItemDaoImplTest extends JejuJoahmassiApplicationTests{
	
	@Autowired
	private RestaurantCategoryItemDao restaurantCategoryItemDao;
	
	@Autowired
	private RestaurantCategoryService restaurantCategoryService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testInsert() {
		restaurantCategoryItemDao.insert(RestaurantCategoryItem.builder()
																.restaurant(restaurantService.findByNo(1L))
																.restaurantCategory(restaurantCategoryService.findByNo(1L))
																.build());
		restaurantCategoryItemDao.insert(RestaurantCategoryItem.builder()
				.restaurant(restaurantService.findByNo(1L))
				.restaurantCategory(restaurantCategoryService.findByNo(2L))
				.build());
	}
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testDeleteByNo() {
		restaurantCategoryItemDao.deleteByNo(1L);
	}
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testUpdate() {
		restaurantCategoryItemDao.update(RestaurantCategoryItem.builder()
																.rciNo(1L)
																.restaurant(restaurantService.findByNo(2L))
																.restaurantCategory(restaurantCategoryService.findByNo(1L))
																.build());
	}
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindAll() {
		System.out.println(restaurantCategoryItemDao.findAll());
	}
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindByNo() {
		System.out.println(restaurantCategoryItemDao.findByNo(1L));
	}
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindByRestaurantRestaurantNo() {
		System.out.println(restaurantCategoryItemDao.findByRestaurantRestaurantNo(1L));
	}
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testfindByRestaurantCategoryRcNo() {
		System.out.println(restaurantCategoryItemDao.findByRestaurantCategoryRcNo(1L));
	}
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testfindByRestaurantCategoryRcNoPage() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("rciNo")));
		Page<RestaurantCategoryItem> page = restaurantCategoryItemDao.findByRestaurantCategoryRcNo(1L, pageable);
		System.out.println(page.getContent());
	}
}
