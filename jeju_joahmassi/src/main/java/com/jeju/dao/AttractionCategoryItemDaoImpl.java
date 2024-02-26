package com.jeju.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.jeju.entity.AttractionCategoryItem;
import com.jeju.repository.AttractionCategoryItemRepository;
import com.jeju.repository.AttractionCategoryRepository;

@Repository
public class AttractionCategoryItemDaoImpl implements AttractionCategoryItemDao {

	@Autowired
	AttractionCategoryItemRepository attractionCategoryItemRepository;

	// 카테고리 아이템 추가
	@Override
	public AttractionCategoryItem insert(AttractionCategoryItem attractionCategoryItem) {
		
		return attractionCategoryItemRepository.save(attractionCategoryItem);
	}
	
	// 카테고리 아이템 삭제
	@Override
	public void deleteByNo(Long aciNo) {
		
		attractionCategoryItemRepository.deleteById(aciNo);
	}
	
	// 카테고리 아이템 수정
	@Override
	public AttractionCategoryItem update(AttractionCategoryItem attractionCategoryItem) {
		
		return attractionCategoryItemRepository.save(attractionCategoryItem);
	}
	
	// 카테고리 아이템 찾기
	@Override
	public AttractionCategoryItem findByNo(Long aciNo) {
		
		return attractionCategoryItemRepository.findById(aciNo).get();
	}
	
	// 카테고리 아이템 리스트
	@Override
	public List<AttractionCategoryItem> findAll() {
		
		return attractionCategoryItemRepository.findAll();
	}
	
	// 명소 번호로 카테고리 아이템 찾기
	@Override
	public Page<AttractionCategoryItem> findByAttractionAttractionNo(Long attractionNo, Pageable pageable) {
		
		return attractionCategoryItemRepository.findByAttractionAttractionNo(attractionNo, pageable);
	}
	
	// 카테고리 번호로 카테고리 아이템 찾기
	@Override
	public Page<AttractionCategoryItem> findByAttractionCategoryAcNo(Long acNo, Pageable pageable) {
		
		return attractionCategoryItemRepository.findByAttractionCategoryAcNo(acNo, pageable);
	}
	

	@Override
	public List<AttractionCategoryItem> findByAttractionCategoryAcNo(Long acNo) {
		
		return attractionCategoryItemRepository.findByAttractionCategoryAcNo(acNo);
	}
}
