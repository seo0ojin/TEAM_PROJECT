package com.jeju.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantMenu;

import jakarta.transaction.Transactional;

class RestaurantDaoImplTest extends JejuJoahmassiApplicationTests{
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	@Disabled
	@Test
	void testInsert() {
		List<RestaurantMenu> testMenu = new ArrayList<RestaurantMenu>();
		Restaurant restaurant = Restaurant.builder()
					.restaurantAddress("서울")
					//.restaurantBookings(null)
					//.restaurantCategory("오션뷰")
					//.restaurantMenus(testMenu)
					.restaurantName("아현식당")
					//.restaurantReviews(null)
					.restaurantStar(4.5)
					.restaurantTel("010")
					.build();
		restaurantDao.insert(restaurant);
	}
	
	@Disabled
	@Test
	void testUpdate() {
		Restaurant restaurant = Restaurant.builder()
				.restaurantNo(1L)
				.restaurantAddress("서울2")
				//.restaurantBookings(null)
				//.restaurantCategory("오션뷰2")
				//.restaurantMenus(null)
				.restaurantName("아현식당2")
				//.restaurantReviews(null)
				.restaurantStar(4.53)
				.restaurantTel("010-123")
				.build();
		restaurantDao.update(restaurant);
	}
	
	@Disabled
	@Rollback(false)
	@Test
	void testDeleteByNo() {
		restaurantDao.deleteByNo(1L);
	}
	
	@Disabled
	@Transactional
	@Test
	void testFindAll() {
		List<Restaurant> restaurants = restaurantDao.findAll();
		System.out.println(">>>>>>>>>>"+restaurants);
	}
	
	@Disabled
	@Test
	@Transactional
	void testFindByNo() {
		System.out.println(">>>>>>>>>>"+restaurantDao.findByNo(2L));
	}
	
	@Disabled
	@Test
	@Transactional
	void testFindAllPage() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("restaurantNo")));
		Page<Restaurant> page = restaurantDao.findAllPage(pageable);
		System.out.println(page.getContent());
	}
	
	@Disabled
	@Transactional
	@Test
	void testFindByRestaurantCategory() {
		//Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("restaurantNo")));
		//Page<Restaurant> page = restaurantDao.findByRestaurantCategory("오션뷰", pageable);
		//System.out.println(page.getContent());
	}
	
	@Disabled
	@Transactional
	@Test
	void testfindByRestaurantName() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("restaurantNo")));
		Page<Restaurant> page = restaurantDao.findByRestaurantNameLike("%아%", pageable);
		System.out.println(page.getContent());
	}
	
	@Disabled
	@Transactional
	@Test
	void testfindByRestaurantAddressLike() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("restaurantNo")));
		Page<Restaurant> page = restaurantDao.findByRestaurantAddressLike("%서%", pageable);
		System.out.println(page.getContent());
	}
	
	@Disabled
	@Transactional
	@Test
	void testfindByRestaurantMenusRmNameLike() {
		//System.out.println(restaurantDao.findByRestaurantMenusRmNameLike("%가%"));
	}
	
}
