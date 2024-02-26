package com.jeju.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jeju.entity.HotelCategoryItem;

public interface HotelCategoryItemService {

	// 카테고리 아이템 추가
	HotelCategoryItem insert(HotelCategoryItem category);

	// 카테고리 번호로 삭제
	void deleteByNo(Long hciNo);

	// 카테고리 아이템 수정
	HotelCategoryItem update(HotelCategoryItem update);

	// 카테고리 아이템 번호로 찾기
	HotelCategoryItem findByNo(Long hciNo);

	// 카테고리 아이템 리스트
	List<HotelCategoryItem> findAll();

	// 호텔 번호로 카테고리 아이템 찾기
	List<HotelCategoryItem> findByHotelHotelNo(Long hotelNo);

	// 카테고리 번호로 카테고리 아이템 찾기
	List<HotelCategoryItem> findByHotelCategoryHcNo(Long hcNo);

	// 카테고리 번호로 카테고리 아이템 찾기
	Page<HotelCategoryItem> findByHotelCategoryHcNo(Long hcNo, Pageable pageable);

	// 호텔 번호로 카테고리 아이템 찾기 (호텔이 포함한 모든 카테고리 정보 리스트)
	//Page<HotelCategoryItem> findByHotelHotelNo(Long hotelNo, Pageable pageable);

	// 페이징
	//Page<HotelCategoryItem> hciFindAllPage(Pageable pageable);

}
