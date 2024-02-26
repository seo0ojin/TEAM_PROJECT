package com.jeju.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jeju.entity.AttractionCategoryItem;

public interface AttractionCategoryItemRepository extends JpaRepository<AttractionCategoryItem, Long>{

	// 명소 번호로 카테고리 아이템 찾기
	public Page<AttractionCategoryItem> findByAttractionAttractionNo(Long attractionNo, Pageable pageable);
	
	// 카테고리 번호로 카테고리 아이템 찾기
	public Page<AttractionCategoryItem> findByAttractionCategoryAcNo(Long acNo, Pageable pageable);
	
	// 카테고리 번호로 카테고리 아이템 찾기
	public List<AttractionCategoryItem> findByAttractionCategoryAcNo(Long acNo);
}
