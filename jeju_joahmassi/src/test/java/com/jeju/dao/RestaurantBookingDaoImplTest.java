package com.jeju.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantBooking;
import com.jeju.entity.Userinfo;
import com.jeju.service.RestaurantService;
import com.jeju.service.UserinfoService;

import jakarta.transaction.Transactional;

class RestaurantBookingDaoImplTest extends JejuJoahmassiApplicationTests{
	
	@Autowired
	private RestaurantBookingDao restaurantBookingDao;
	
	@Autowired
	private UserinfoService userinfoService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Disabled
	@Test
	void testInsert() {
		Userinfo userinfo = userinfoService.findByUserNo(3L);
		Restaurant restaurant = restaurantService.findByNo(2L);
		RestaurantBooking restaurantBooking = RestaurantBooking.builder()
																//.rbDate(LocalDateTime.now())
																.rbName("전아현")
																.rbPersons(4)
																.rbPhone("010-5094-3902")
																.rbTime("3시")
																.userinfo(userinfo)
																.restaurant(restaurant)
																.build();
		restaurantBookingDao.insert(restaurantBooking);
	}
	
	@Disabled
	@Test
	void testDeleteByNo() {
		restaurantBookingDao.deleteByNo(2L);
	}
	
	@Disabled
	@Test
	void testUpdate() {
		Userinfo userinfo = userinfoService.findByUserNo(3L);
		Restaurant restaurant = restaurantService.findByNo(2L);
		RestaurantBooking restaurantBooking = RestaurantBooking.builder()
																//.rbDate(LocalDateTime.now())
																.rbName("전아현23")
																.rbPersons(6)
																.rbPhone("010-5094-3902")
																.rbTime("4시")
																.userinfo(userinfo)
																.restaurant(restaurant)
																.rbNo(3L)
																.build();
		restaurantBookingDao.update(restaurantBooking);
	}
	
	@Disabled
	@Transactional
	@Test
	void testFindByUserinfoUserinfo() {
		//Userinfo userinfo = userinfoService.findByUserNo(3L);
		System.out.println(restaurantBookingDao.findByUserinfoUserNo(1L));
	}
	
	@Disabled
	@Transactional
	@Test
	void testFindAll() {
		System.out.println(restaurantBookingDao.findAll());
	}
	
	@Disabled
	@Transactional
	@Test
	void testFindByNo() {
		System.out.println(restaurantBookingDao.findByNo(3L));
	}
	
	@Disabled
	@Transactional
	@Test
	void testFindByRestaurant() {
		Restaurant restaurant = restaurantService.findByNo(2L);
		//System.out.println(restaurantBookingDao.findByRestaurant(restaurant));
	}
	
	@Disabled
	@Transactional
	@Test
	void testFindByUserinfoUserinfoPageable() {
		Userinfo userinfo = userinfoService.findByUserNo(3L);
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("rbNo")));
		//Page<RestaurantBooking> page = restaurantBookingDao.findByUserinfo(userinfo, pageable);
		//System.out.println(page.getContent());
	}
	
	@Disabled
	@Transactional
	@Test
	void testFindByRestaurantPageable() {
		Restaurant restaurant = restaurantService.findByNo(2L);
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("rbNo")));
		//Page<RestaurantBooking> page = restaurantBookingDao.findByRestaurant(restaurant, pageable);
		//System.out.println(page.getContent());
	}
	
	@Disabled
	@Transactional
	@Test
	void testFindByRbDateBetween() {
		LocalDateTime nowDate = LocalDateTime.now();
		LocalDateTime startDate = LocalDateTime.of(2023, 12, 12, 0, 0);
		LocalDateTime endDate = LocalDateTime.of(2023, 12, 13, 0, 0);
		//System.out.println(startDate);
		Userinfo userinfo = userinfoService.findByUserNo(1L);
		//System.out.println(restaurantBookingDao.findByRbDateBetweenAndUserinfo(startDate, endDate,userinfo));
		restaurantBookingDao.findByRbDateBetweenAndUserinfoUserNo(startDate,endDate,userinfo.getUserNo());
	}
	
	@Disabled
	@Transactional
	@Test
	void testFindByRbDateBetweenAndUserinfoPage() {
		LocalDateTime nowDate = LocalDateTime.now();
		LocalDateTime startDate = nowDate.minusMonths(1);
		LocalDateTime endDate = nowDate.plusMonths(1);
		Userinfo userinfo = userinfoService.findByUserNo(6L);
		//Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("rbNo")));
		//Page<RestaurantBooking> page = restaurantBookingDao.findByRbDateBetweenAndUserinfo(startDate, endDate, userinfo, pageable);
		//System.out.println(page.getContent());
	}
}
