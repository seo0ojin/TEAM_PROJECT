package com.jeju.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeju.entity.HotelCategory;
import com.jeju.repository.HotelCategoryRepository;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public class HotelCategoryDaoImpl implements HotelCategoryDao{

	@Autowired
	HotelCategoryRepository hotelCategoryRepository;
	
	@Override
	// 호텔 카테고리 추가
	public HotelCategory insertCategory(HotelCategory hotelCategory) {
		return hotelCategoryRepository.save(hotelCategory);
	}

	@Override
	// 호텔 카테고리 삭제
	public void deleteCategory(Long hcNo) {
		hotelCategoryRepository.deleteById(hcNo);
	}

	@Override
	// 호텔 카테고리 수정
	public HotelCategory updateCategory(HotelCategory updateHc) {
		return hotelCategoryRepository.save(updateHc);
	}

	// 호텔 카테고리 번호로 찾기
	public HotelCategory findByNo(Long hcNo) {
		return hotelCategoryRepository.findById(hcNo).get();
	}
	
	@Override
	// 호텔 카테고리 전체 리스트
	public List<HotelCategory> findAll() {
		return hotelCategoryRepository.findAll();
	}

}
