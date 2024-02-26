package com.jeju.service;


import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.entity.HotelCategory;

import jakarta.transaction.Transactional;

class HotelCategoryServiceImplTest extends JejuJoahmassiApplicationTests{

	@Autowired
	HotelCategoryService hotelCategoryService;
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void insertCategory() {
		HotelCategory category1 = HotelCategory.builder()
				.hcNo(null)
				.hcName("호텔")
				.build();
		hotelCategoryService.insertCategory(category1);
		
		HotelCategory category2 = HotelCategory.builder()
				.hcNo(null)
				.hcName("모텔")
				.build();
		hotelCategoryService.insertCategory(category2);
		
		HotelCategory category3 = HotelCategory.builder()
				.hcNo(null)
				.hcName("게스트하우스")
				.build();
		hotelCategoryService.insertCategory(category3);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void deleteCategory() {
		hotelCategoryService.deleteCategory(7L);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void updateCategory() {
		hotelCategoryService.updateCategory(HotelCategory.builder()
				.hcNo(7L)
				.hcName("게스트 하우스")
				.build());
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findAll() {
		List<HotelCategory> list = hotelCategoryService.findAll();
		System.out.println(list);
	}

}
