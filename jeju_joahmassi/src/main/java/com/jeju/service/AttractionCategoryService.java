package com.jeju.service;

import java.util.List;

import com.jeju.entity.AttractionCategory;

public interface AttractionCategoryService {

	// 명소 카테고리 추가
	public AttractionCategory insert(AttractionCategory attractionCategory);
	
	// 명소 카테고리 삭제
	public void delete(Long acNo);
	
	// 명소 카테고리 수정
	public AttractionCategory update(AttractionCategory attractionCategory);
	
	// 명소 카테고리 리스트
	public List<AttractionCategory> findAll();
	
	// 명소 카테고리 찾기
	public AttractionCategory findByNo(Long acNo);
}
