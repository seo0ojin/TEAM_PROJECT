package com.jeju.dao;


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
import com.jeju.entity.Hotel;

import jakarta.transaction.Transactional;

class HotelDaoImplTest extends JejuJoahmassiApplicationTests{

	@Autowired
	HotelDao hotelDao;

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void insertHotel() {
		
		Hotel hotel1 = Hotel.builder()
				.hotelNo(null)
				.hotelName("승범호텔")
				.hotelLocal("안성시 공도읍")
				.hotelPrice(140000)
				.hotelStar(0.0)
				.hotelDesc("우리 팀장은 바보예요")
				.build();
		hotelDao.insertHotel(hotel1);
		
		
		Hotel hotel2 = Hotel.builder()
				.hotelNo(null)
				.hotelName("서진호텔")
				.hotelLocal("강원도 홍천군")
				.hotelPrice(210000)
				.hotelStar(0.0)
				.hotelDesc("우리는 바보예요")
				.build();
		hotelDao.insertHotel(hotel2);
		
		Hotel hotel3 = Hotel.builder()
				.hotelNo(null)
				.hotelName("아현호텔")
				.hotelLocal("서울시 중랑구")
				.hotelPrice(170000)
				.hotelStar(0.0)
				.hotelDesc("우리는 멍청이에요")
				.build();
		hotelDao.insertHotel(hotel3);
		
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void updateHotel() {
		Hotel findHotel = hotelDao.findByHotelNo(1L);
		findHotel.setHotelName("바꿨음");
		System.out.println(findHotel);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findHotel() {
		Hotel findHotel = hotelDao.findByHotelNo(2L);
		System.out.println(findHotel);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	// 이거 안해봤음 해봐야댐 되겠지 머 ~
	void deleteHotel() {
		hotelDao.deleteByHotelNo(3L);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findAll() {
		List<Hotel> hotels = hotelDao.findAllHotels();
		System.out.println(hotels);
	}

	/*
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHciNo() {
		List<Hotel> hotels = hotelDao.findByHotelCategoryItemsHciNo(2L);
		System.out.println(hotels);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHciNoPage() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hciNo")));
		Page<Hotel> hotels = hotelDao.findByHotelCategoryItemsHciNo(2L, pageable);
		System.out.println(hotels.getContent());
	}
	*/
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void hotelFindAllPage() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hotelNo")));
		Page<Hotel> hotels = hotelDao.hotelFindAllPage(pageable);
		System.out.println(hotels.getContent());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void findByHotelNameLike() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hotelNo")));
		Page<Hotel> findHotel = hotelDao.findByHotelNameLike("%제주%", pageable);
		System.out.println(findHotel.getContent());
	}
	
	/*
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHotelCategoryLike() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hotelNo")));
		Page<Hotel> findHotel = hotelDao.findByHotelCategoryLike("%%", pageable);
		System.out.println(findHotel);
	}
	*/
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHotelLocalLike() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hotelNo")));
		Page<Hotel> findHotel = hotelDao.findByHotelLocalLike("%%", pageable);
		System.out.println(findHotel.getContent());
	}
	
}
