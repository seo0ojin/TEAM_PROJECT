package com.jeju.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

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
import com.jeju.entity.RestaurantBooking;
import com.jeju.entity.Userinfo;

import jakarta.transaction.Transactional;

class RestaurantBookingServiceImplTest extends JejuJoahmassiApplicationTests{
	
	@Autowired
	private RestaurantBookingService restaurantBookingService;
	
	@Autowired
	private UserinfoService userinfoService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Disabled
	@Test
	void testInsert() {
		Userinfo userinfo = userinfoService.findByUserNo(1L);
		Restaurant restaurant = restaurantService.findByNo(1L);
		LocalDateTime date = LocalDateTime.of(2023, 12, 12, 00, 00);
		RestaurantBooking restaurantBooking = RestaurantBooking.builder()
																//.rbDate(date)
																.rbName("전아현")
																.rbPersons(4)
																.rbPhone("010-5094-3902")
																.rbTime("3시")
																.userinfo(userinfo)
																.restaurant(restaurant)
																.build();
		restaurantBookingService.insert(restaurantBooking);
	}
	
	@Transactional
	@Rollback(false)
	@Disabled
	@Test
	void testDeleteByNo() {
		restaurantBookingService.deleteByNo(1L);
	}
	
	@Transactional
	@Rollback(false)
	@Disabled
	@Test
	void testUpdate() {
		Userinfo userinfo = userinfoService.findByUserNo(1L);
		Restaurant restaurant = restaurantService.findByNo(1L);
		RestaurantBooking restaurantBooking = RestaurantBooking.builder()
																//.rbDate(LocalDateTime.now())
																.rbName("전아현23")
																.rbPersons(6)
																.rbPhone("010-5094-3902")
																.rbTime("4시")
																.userinfo(userinfo)
																.restaurant(restaurant)
																.rbNo(2L)
																.build();
		restaurantBookingService.update(restaurantBooking);
	}
	
	@Transactional
	@Disabled
	@Test
	void testFindByUserinfoUserinfo() {
		System.out.println(restaurantBookingService.findByUserinfoUserNo(1L));
		
	}
	
	@Transactional
	@Disabled
	@Test
	void testFindAll() {
		System.out.println(restaurantBookingService.findAll());
	}
	
	@Transactional
	@Disabled
	@Test
	void testFindByNo() {
		System.out.println(restaurantBookingService.findByNo(1L));
	}
	
	@Transactional
	@Disabled
	@Test
	void testFindByRestaurantRestaurant() {
		System.out.println(restaurantBookingService.findByRestaurantRestaurantNo(1L));
	}
	
	@Transactional
	@Disabled
	@Test
	void testFindByUserinfoUserinfoPageable() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("rbNo")));
		Page<RestaurantBooking> page = restaurantBookingService.findByUserinfoUserNo(1L,pageable);
		System.out.println(page.getContent());
	}
	
	@Transactional
	@Disabled
	@Test
	void testFindByRestaurantRestaurantPageable() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("rbNo")));
		Page<RestaurantBooking> page = restaurantBookingService.findByRestaurantRestaurantNo(1L, pageable);
		System.out.println(page.getContent());
	}
	
	@Transactional
	@Disabled
	@Test
	void testFindByRbDateBetweenAndUserinfoLocalDateTimeLocalDateTimeUserinfo() {
		LocalDateTime nowDate = LocalDateTime.now();
		LocalDateTime startDate = nowDate.minusMonths(1);
		LocalDateTime endDate = nowDate.plusMonths(1);
		Userinfo userinfo = userinfoService.findByUserNo(1L);
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("rbNo")));
		System.out.println(restaurantBookingService.findByRbDateBetweenAndUserinfoUserNo(startDate, endDate, userinfo.getUserNo()));
	}
	
	@Transactional
	@Disabled
	@Test
	void testFindByRbDateBetweenAndUserinfoLocalDateTimeLocalDateTimeUserinfoPageable() {
		LocalDateTime nowDate = LocalDateTime.now();
		LocalDateTime startDate = LocalDateTime.of(2023, 12, 12, 00, 00);
		LocalDateTime endDate = LocalDateTime.of(2023, 12, 13, 00, 00);
		Userinfo userinfo = userinfoService.findByUserNo(1L);
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("rbNo")));
		System.out.println(restaurantBookingService.findByRbDateBetweenAndUserinfoUserNo(startDate, endDate, userinfo.getUserNo(),pageable).getContent());
	}

}
