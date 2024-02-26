package com.jeju.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.dao.HotelDao;
import com.jeju.dao.RestaurantDao;
import com.jeju.dao.UserinfoDao;
import com.jeju.entity.Wish;


class WishServiceImplTest extends JejuJoahmassiApplicationTests {

	@Autowired
	WishService wishService;
	@Autowired
	UserinfoDao userInfoDao;
	@Autowired
	HotelDao hotelDao;
	@Autowired
	RestaurantDao restaurantDao;
//	@Autowired
//	AttractionDao attractionDao;
	
	// 위시리스트에 호텔 담기
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testInsertWishByHotel() {
		Wish wish = Wish.builder()
				.hotel(hotelDao.findByHotelNo(3L))
				.userinfo(userInfoDao.findByUserNo(2L))
				.wishCategory("호텔")
				.build();
	
		wishService.insertWishByHotel(wish);
	}

	// 위시리스트에 맛집 담기
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testInsertWishByRestaurant() {
		Wish wish = Wish.builder()
				.hotel(null)
				.restaurant(restaurantDao.findByNo(1L))
				.attraction(null)
				.userinfo(userInfoDao.findByUserNo(1L))
				.wishCategory("맛집")
				.build();
	
		wishService.insertWishByRestaurant(wish);
	}

	// 위시리스트에 명소 담기
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testInsertWishByAttraction() {
		Wish wish = Wish.builder()
				.hotel(null)
				.restaurant(null)
				.attraction(null)
				.userinfo(userInfoDao.findByUserNo(1L))
				.wishCategory("명소")
				.build();
	
		wishService.insertWishByAttraction(wish);
	}

	// 위시 삭제
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testDeleteWish() {
		wishService.deleteWish(2L);
	}

	// 위시리스트(userNo)
	@Test
	@Disabled
	@Transactional
	void testFindAllWishByUserNo() {
		System.out.println(wishService.findAllWishByUserNo(2L));
	}

	// 위시리스트 상세
	@Test
	@Disabled
	@Transactional
	void testFindByWishNo() {
		System.out.println(wishService.findByWishNo(3L));
	}

	// 위시리스트에 있는 개수 출력(userNo)
	@Test
	@Disabled
	@Transactional
	void testCountWishList() {
		System.out.println(wishService.countWishList(2L));
	}

	// 위시리스트에 호텔 있는지 확인
	@Test
	@Disabled
	@Transactional
	void testExistByUserNoAnHotelNo() {
		System.out.println(wishService.existByUserNoAnHotelNo(1L, 2L));
	}

	// 위시리스트에 맛집 있는지 확인
	@Test
	@Disabled
	@Transactional
	void testExistByUserNoAndRestaurantNo() {
		System.out.println(wishService.existByUserNoAndRestaurantNo(1L, 2L));
	}

	// 위시리스트에 명소 있는지 확인
	@Test
	@Disabled
	@Transactional
	void testExistByUserNoAndAttractionNo() {
		System.out.println(wishService.existByUserNoAndAttractionNo(1L, 1L));
	}

}
