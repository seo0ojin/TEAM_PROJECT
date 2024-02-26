package com.jeju.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.jeju.entity.HotelCategoryItem;
import com.jeju.repository.HotelCategoryItemRepository;

@Repository
public class HotelCategoryItemDaoImpl implements HotelCategoryItemDao{

	@Autowired
	HotelCategoryItemRepository hotelCategoryItemRepository;

	@Override
	// 카테고리 아이템 추가
	public HotelCategoryItem insert(HotelCategoryItem category) {
		return hotelCategoryItemRepository.save(category);
	}

	@Override
	// 카테고리 아이템 번호로 삭제
	public void deleteByNo(Long hciNo) {
		hotelCategoryItemRepository.deleteById(hciNo);
	}

	@Override
	// 카테고리 아이템 수정
	public HotelCategoryItem update(HotelCategoryItem update) {
		return hotelCategoryItemRepository.save(update);
	}

	@Override
	// 카테고리 아이템 번호로 찾기
	public HotelCategoryItem findByNo(Long hciNo) {
		return hotelCategoryItemRepository.findById(hciNo).get();
	}

	@Override
	// 카테고리 아이템 전체 리스트
	public List<HotelCategoryItem> findAll() {
		return hotelCategoryItemRepository.findAll();
	}

	@Override
	// 호텔 번호로 카테고리 아이템 찾기
	public List<HotelCategoryItem> findByHotelHotelNo(Long hotelNo) {
		return hotelCategoryItemRepository.findByHotelHotelNo(hotelNo);
	}

	// 호텔 번호로 카테고리 아이템 찾기 (호텔이 포함한 모든 카테고리 정보 리스트)
	public Page<HotelCategoryItem> findByHotelHotelNo(Long hotelNo, Pageable pageable){
		Page<HotelCategoryItem> list = hotelCategoryItemRepository.findByHotelHotelNo(hotelNo, pageable);
		return list;
	}

	@Override
	// 카테고리 번호로 카테고리 아이템 찾기
	public List<HotelCategoryItem> findByHotelCategoryHcNo(Long hcNo) {
		return hotelCategoryItemRepository.findByHotelCategoryHcNo(hcNo);
	}

	@Override
	// 카테고리 번호로 카테고리 아이템 찾기 (페이징)
	public Page<HotelCategoryItem> findByHotelCategoryHcNo(Long hcNo, Pageable pageable) {
		return hotelCategoryItemRepository.findByHotelCategoryHcNo(hcNo, pageable);
	}
	
	
	
}
