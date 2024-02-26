package com.jeju.service;


import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.entity.HotelCategoryItem;

import jakarta.transaction.Transactional;

class HotelCategoryItemServiceImplTest extends JejuJoahmassiApplicationTests{

	@Autowired
	HotelCategoryItemService hotelCategoryItemService;
	@Autowired
	HotelService hotelService;
	@Autowired
	HotelCategoryService hotelCategoryService;
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void insert() {
		HotelCategoryItem item1 = HotelCategoryItem.builder()
				.hciNo(null)
				.hotelCategory(hotelCategoryService.findByNo(2L))
				.hotel(hotelService.findByHotelNo(2L))
				.build();
		hotelCategoryItemService.insert(item1);
		
		HotelCategoryItem item2 = HotelCategoryItem.builder()
				.hciNo(null)
				.hotelCategory(hotelCategoryService.findByNo(2L))
				.hotel(hotelService.findByHotelNo(4L))
				.build();
		hotelCategoryItemService.insert(item2);
		
		HotelCategoryItem item3 = HotelCategoryItem.builder()
				.hciNo(null)
				.hotelCategory(hotelCategoryService.findByNo(2L))
				.hotel(hotelService.findByHotelNo(3L))
				.build();
		hotelCategoryItemService.insert(item3);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void deleteByNo() {
		hotelCategoryItemService.deleteByNo(5L);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void update() {
		HotelCategoryItem item = hotelCategoryItemService.findByNo(2L);
		item.setHotelCategory(hotelCategoryService.findByNo(4L));
		hotelCategoryItemService.update(item);
		System.out.println(item);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByNo() {
		HotelCategoryItem item = hotelCategoryItemService.findByNo(2L);
		System.out.println(item);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findAll() {
		List<HotelCategoryItem> list = hotelCategoryItemService.findAll();
		System.out.println(list);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHotelHotelNo() {
		List<HotelCategoryItem> list = hotelCategoryItemService.findByHotelHotelNo(1L);
		System.out.println(list);
	}

}
