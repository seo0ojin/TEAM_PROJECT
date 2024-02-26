package com.jeju.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.entity.Restaurant;

import jakarta.transaction.Transactional;

class RestaurantServiceImplTest extends JejuJoahmassiApplicationTests{
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Disabled
	@Test
	void testInsert() {
		
		Restaurant restaurant = Restaurant.builder()
				.restaurantAddress("부산")
				//.restaurantBookings(null)
				//.restaurantCategory("고기")
				//.restaurantMenus(null)
				.restaurantName("승범식당")
				//.restaurantReviews(null)
				.restaurantStar(5.0)
				.restaurantTel("010-1234-4567")
				.build();
		restaurantService.insert(restaurant);
		
		Restaurant restaurant2 = Restaurant.builder()
				.restaurantAddress("서울")
				//.restaurantBookings(null)
				//.restaurantCategory("고기")
				//.restaurantMenus(null)
				.restaurantName("아현식당")
				//.restaurantReviews(null)
				.restaurantStar(2.5)
				.restaurantTel("010-4787-8282")
				.build();
		restaurantService.insert(restaurant2);
	}
	
	@Disabled
	@Test
	void testUpdate() {
		Restaurant restaurant = Restaurant.builder()
				.restaurantNo(2L)
				.restaurantAddress("부산")
				//.restaurantBookings(null)
				//.restaurantCategory("고기집")
				//.restaurantMenus(null)
				.restaurantName("승범식당2")
				//.restaurantReviews(null)
				.restaurantStar(4.8)
				.restaurantTel("010-4321-0987")
				.build();
		restaurantService.update(restaurant);
	}
	
	@Disabled
	@Test
	void testDeleteByNo() {
		restaurantService.deleteByNo(2L);
	}
	
	@Disabled
	@Transactional
	@Test
	void testFindAll() {
		System.out.println(restaurantService.findAll());
	}
	
	@Disabled
	@Transactional
	@Test
	void testFindByNo() {
		System.out.println(restaurantService.findByNo(2L));
	}
	
	@Disabled
	@Transactional
	@Test
	void testFindAllPage() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("restaurantNo")));
		Page<Restaurant> page = restaurantService.findAllPage(pageable);
		System.out.println(page.getContent());
	}
	
	@Disabled
	@Transactional
	@Test
	void testFindByRestaurantCategory() {
		//Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("restaurantNo")));
		//Page<Restaurant> page = restaurantService.findByRestaurantCategory("고기집",pageable);
		//System.out.println(page.getContent());
	}
	
	@Disabled
	@Transactional
	@Test
	void testFindByRestaurantNameLike() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("restaurantNo")));
		Page<Restaurant> page = restaurantService.findByRestaurantNameLike("승",pageable);
		System.out.println(page.getContent());
	}
	
	@Disabled
	@Transactional
	@Test
	void testFindByRestaurantAddressLike() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("restaurantNo")));
		Page<Restaurant> page = restaurantService.findByRestaurantAddressLike("산",pageable);
		System.out.println(page.getContent());
	}
}
