package com.jeju.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.entity.Restaurant;
import com.jeju.entity.Userinfo;
import com.jeju.entity.Wish;

import jakarta.transaction.Transactional;

class WishDaoImplTest extends JejuJoahmassiApplicationTests {

	@Autowired
	WishDao wishDao;
	@Autowired
	UserinfoDao userInfoDao;
	@Autowired
	HotelDao hotelDao;
	@Autowired
	RestaurantDao restaurantDao;
	
	// 위시리스트에 담기
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testInsertWish() {
		Wish wish = Wish.builder()
					.hotel(hotelDao.findByHotelNo(1L))
					.restaurant(null)
					.attraction(null)
					.userinfo(userInfoDao.findByUserNo(1L))
					.wishCategory("호텔")
					.build();
		
		wishDao.insertWish(wish);
		
		Wish wish2 = Wish.builder()
				.hotel(null)
				.restaurant(restaurantDao.findByNo(1L))
				.attraction(null)
				.userinfo(userInfoDao.findByUserNo(1L))
				.wishCategory("맛")
				.build();
	
		wishDao.insertWish(wish2);
	}
	
	// 위시 삭제
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testDeleteWish() {
		wishDao.deleteWish(5L);
	}

	// 위시리스트(userNo)
	@Test
	@Disabled
	@Transactional
	void testFindAllWishByUserNo() {
		List<Wish> wishList = wishDao.findAllWishByUserNo(1L);
		
		System.out.println(wishList);
	}

	// 위시리스트 상세
	@Test
	@Disabled
	@Transactional
	void testFindByWishNo() {
		Wish wish = wishDao.findByWishNo(4L);
		
		System.out.println(wish);
	}

	// 위시리스트에 있는 개수 출력(userNo)
	@Test
	@Disabled
	@Transactional
	void testCountWishList() {
		int count = wishDao.countWishList(1L);
		
		System.out.println(count);
	}
	
	// 위시리스트에서 userNo, hotelNo로 찾아오기
	@Test
	@Disabled
	@Transactional
	void testFindByUserNoHotelNo() {
		
		System.out.println(wishDao.findByUserNoHotelNo(1L, 1L));
	}

	// 위시리스트에서 userNo, restaurantNo로 찾아오기
	@Test
	@Disabled
	@Transactional
	void testFindByUserNoRestaurantNo() {
		
		System.out.println(wishDao.findByUserNoRestaurantNo(1L, 1L));
	}

	// 위시리스트에서 userNo, attractionNo로 찾아오기
	@Test
	@Disabled
	@Transactional
	void testFindByUserNoAttractionNo() {
		
		wishDao.findByUserNoAttractionNo(null, null);
	}

	// 위시리스트에 호텔 있는지 확인
	@Test
	@Disabled
	@Transactional
	void testExistByUserNoAnHotelNo() {
		boolean hotel = wishDao.existByUserNoAnHotelNo(1L, 2L);
		
		System.out.println(hotel);
	}

	// 위시리스트에 맛집 있는지 확인
	@Test
	@Disabled
	@Transactional
	void testExistByUserNoAndRestaurantNo() {
		boolean restaurant = wishDao.existByUserNoAndRestaurantNo(1L, 2L);
		
		System.out.println(restaurant);
	}

	// 위시리스트에 명소 있는지 확인
	@Test
	@Disabled
	@Transactional
	void testExistByUserNoAndAttractionNo() {
		boolean attraction = wishDao.existByUserNoAndAttractionNo(1L, 1L);
		
		System.out.println(attraction);
	}

}
