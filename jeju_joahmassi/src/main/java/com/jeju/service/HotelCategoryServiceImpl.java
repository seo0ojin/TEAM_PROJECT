package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.dao.HotelCategoryDao;
import com.jeju.entity.HotelCategory;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class HotelCategoryServiceImpl implements HotelCategoryService{

	@Autowired
	HotelCategoryDao hotelCategoryDao;
	
	@Override
	// 호텔 카테고리 추가
	public HotelCategory insertCategory(HotelCategory hotelCategory) {
		return hotelCategoryDao.insertCategory(hotelCategory);
	}

	@Override
	// 호텔 카테고리 삭제
	public void deleteCategory(Long hcNo) {
		hotelCategoryDao.deleteCategory(hcNo);
	}

	@Override
	// 호텔 카테고리 수정
	public HotelCategory updateCategory(HotelCategory updateHc) {
		return hotelCategoryDao.updateCategory(updateHc);
	}

	// 호텔 카테고리 번호로 찾기
	public HotelCategory findByNo(Long hcNo) {
		return hotelCategoryDao.findByNo(hcNo);
	}
	
	@Override
	// 호텔 카테고리 전체 리스트
	public List<HotelCategory> findAll() {
		return hotelCategoryDao.findAll();
	}
}
