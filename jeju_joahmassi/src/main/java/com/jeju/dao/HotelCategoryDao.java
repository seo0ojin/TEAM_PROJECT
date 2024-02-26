package com.jeju.dao;

import java.util.List;

import com.jeju.entity.HotelCategory;

public interface HotelCategoryDao {

	// 호텔 카테고리 추가
	HotelCategory insertCategory(HotelCategory hotelCategory);
	
	// 호텔 카테고리 삭제 
	void deleteCategory(Long hcNo);
	
	// 호텔 카테고리 수정
	HotelCategory updateCategory(HotelCategory updateHc);
	
	// 호텔 카테고리 전체 리스트
	List<HotelCategory> findAll();
	
	// 호텔 카테고리 번호로 찾기
	HotelCategory findByNo(Long hcNo);
}
