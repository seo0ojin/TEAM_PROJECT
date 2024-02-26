package com.jeju.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jeju.entity.AttractionCategoryItem;

public interface AttractionCategoryItemDao {

	// 카테고리 아이템 추가
	public AttractionCategoryItem insert(AttractionCategoryItem attractionCategoryItem);
	
	// 카테고리 아이템 삭제
	public void deleteByNo(Long aciNo);
	
	// 카테고리 아이템 수정
	public AttractionCategoryItem update(AttractionCategoryItem attractionCategoryItem);
	
	// 카테고리 아이템 찾기
	public AttractionCategoryItem findByNo(Long aciNo);
	
	// 카테고리 아이템 리스트
	public List<AttractionCategoryItem> findAll();
	
	// 명소 번호로 카테고리 아이템 찾기
	public Page<AttractionCategoryItem> findByAttractionAttractionNo(Long attractionNo, Pageable pageable);
	
	// 카테고리 번호로 카테고리 아이템 찾기
	public Page<AttractionCategoryItem> findByAttractionCategoryAcNo(Long acNo, Pageable pageable);
	
	// 카테고리 번호로 카테고리 아이템 찾기
	public List<AttractionCategoryItem> findByAttractionCategoryAcNo(Long acNo);
}
