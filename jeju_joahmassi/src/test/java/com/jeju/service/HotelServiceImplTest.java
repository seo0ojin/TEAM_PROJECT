package com.jeju.service;

import static org.junit.jupiter.api.Assertions.*;

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

class HotelServiceImplTest extends JejuJoahmassiApplicationTests{

	@Autowired
	HotelService hotelService;
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void insertHotel() {
		// 근데 되긴 되는데 4번으로 insert 돼야 하는데 왜 52번???? ㅜㅜ
		Hotel hotel1 = Hotel.builder()
				.hotelNo(null)
				.hotelName("승범비앤비")
				.hotelLocal("안성시 공도읍")
				.hotelPrice(98000)
				.hotelStar(0.0)
				.hotelDesc("졸리다")
				.build();
		hotelService.insertHotel(hotel1);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findHotel() {
		Hotel findHotel = hotelService.findByHotelNo(52L);
		System.out.println(findHotel);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void updateHotel() {
		Hotel findHotel = hotelService.findByHotelNo(52L);
		findHotel.setHotelName("바뀜");
		System.out.println(findHotel);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void deleteHotel() {
		hotelService.deleteByHotelNo(52L);
	}


	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findAll() {
		List<Hotel> hotels = hotelService.findAllHotels();
		System.out.println(hotels);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHotelNameLike() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hotelNo")));
		Page<Hotel> findHotel = hotelService.findByHotelNameLike("%%", pageable);
		System.out.println(findHotel);
	}

	/*
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHotelCategoryLike() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hotelNo")));
		Page<Hotel> findHotel = hotelService.findByHotelCategoryLike("바보", pageable);
		System.out.println(findHotel);
	}
	*/
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHotelLocalLike() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hotelNo")));
		Page<Hotel> findHotel = hotelService.findByHotelLocalLike("안성", pageable);
		System.out.println(findHotel);
	}
	
	/*
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHciNo() {
		List<Hotel> hotels = hotelService.findByHotelCategoryItemsHciNo(2L);
		System.out.println(hotels);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHciNoPage() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hciNo")));
		Page<Hotel> hotels = hotelService.findByHotelCategoryItemsHciNo(2L, pageable);
		System.out.println(hotels);
	}
	*/
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void hotelFindAllPage() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hotelNo")));
		Page<Hotel> hotels = hotelService.hotelFindAllPage(pageable);
		System.out.println(hotels);
	}
	
}
