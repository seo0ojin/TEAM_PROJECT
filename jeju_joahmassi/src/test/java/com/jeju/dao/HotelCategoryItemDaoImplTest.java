package com.jeju.dao;


import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.entity.HotelCategoryItem;

import jakarta.transaction.Transactional;

class HotelCategoryItemDaoImplTest extends JejuJoahmassiApplicationTests{

	@Autowired
	HotelCategoryItemDao hotelCategoryItemDao;
	@Autowired
	HotelCategoryDao hotelCategoryDao;
	@Autowired
	HotelDao hotelDao;
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void insert() {
		HotelCategoryItem item1 = HotelCategoryItem.builder()
				.hciNo(null)
				.hotelCategory(hotelCategoryDao.findByNo(1L))
				.hotel(hotelDao.findByHotelNo(1L))
				.build();
		hotelCategoryItemDao.insert(item1);
		
		HotelCategoryItem item2 = HotelCategoryItem.builder()
				.hciNo(null)
				.hotelCategory(hotelCategoryDao.findByNo(2L))
				.hotel(hotelDao.findByHotelNo(1L))
				.build();
		hotelCategoryItemDao.insert(item2);
		
		HotelCategoryItem item3 = HotelCategoryItem.builder()
				.hciNo(null)
				.hotelCategory(hotelCategoryDao.findByNo(3L))
				.hotel(hotelDao.findByHotelNo(1L))
				.build();
		hotelCategoryItemDao.insert(item3);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void deleteByNo() {
		hotelCategoryItemDao.deleteByNo(4L);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void update() {
		HotelCategoryItem item = hotelCategoryItemDao.findByNo(1L);
		item.setHotelCategory(hotelCategoryDao.findByNo(3L));
		hotelCategoryItemDao.update(item);
		System.out.println(item);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByNo() {
		HotelCategoryItem item = hotelCategoryItemDao.findByNo(1L);
		System.out.println(item);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findAll() {
		List<HotelCategoryItem> list = hotelCategoryItemDao.findAll();
		System.out.println(list);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHotelHotelNo() {
		List<HotelCategoryItem> list = hotelCategoryItemDao.findByHotelHotelNo(1L);
		System.out.println(list);
	}


}
