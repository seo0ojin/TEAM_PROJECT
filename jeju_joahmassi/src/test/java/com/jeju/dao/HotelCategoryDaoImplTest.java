package com.jeju.dao;


import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.entity.HotelCategory;

import jakarta.transaction.Transactional;

class HotelCategoryDaoImplTest extends JejuJoahmassiApplicationTests{

	@Autowired
	HotelCategoryDao hotelCategoryDao;
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void insertCategory() {
		HotelCategory category1 = HotelCategory.builder()
				.hcNo(null)
				.hcName("오션뷰")
				.build();
		hotelCategoryDao.insertCategory(category1);
		
		HotelCategory category2 = HotelCategory.builder()
				.hcNo(null)
				.hcName("한옥")
				.build();
		hotelCategoryDao.insertCategory(category2);
		
		HotelCategory category3 = HotelCategory.builder()
				.hcNo(null)
				.hcName("단독주택")
				.build();
		hotelCategoryDao.insertCategory(category3);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void deleteCategory() {
		hotelCategoryDao.deleteCategory(4L);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void updateCategory() {
		hotelCategoryDao.updateCategory(HotelCategory.builder()
				.hcNo(4L)
				.hcName("테스트수정")
				.build());
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findAll() {
		List<HotelCategory> list = hotelCategoryDao.findAll();
		System.out.println(list);
	}

}
