package com.jeju.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jeju.entity.HotelCategoryItem;

public interface HotelCategoryItemRepository extends JpaRepository<HotelCategoryItem, Long>{

	// 호텔 번호로 카테고리 아이템 찾기 (호텔이 포함한 모든 카테고리 정보 리스트)
	List<HotelCategoryItem> findByHotelHotelNo(Long hotelNo);
	
	// 호텔 번호로 카테고리 아이템 찾기 (호텔이 포함한 모든 카테고리 정보 리스트)
	Page<HotelCategoryItem> findByHotelHotelNo(Long hotelNo, Pageable pageable);
	
	// 카테고리 번호로 카테고리 아이템 찾기
	List<HotelCategoryItem> findByHotelCategoryHcNo(Long hcNo);

	// 카테고리 번호로 카테고리 아이템 찾기
	Page<HotelCategoryItem> findByHotelCategoryHcNo(Long hcNo, Pageable pageable);
	
}
