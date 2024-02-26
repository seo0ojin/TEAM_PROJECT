package com.jeju.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeju.entity.AttractionCategory;
import com.jeju.repository.AttractionCategoryRepository;

@Repository
public class AttractionCategoryDaoImpl implements AttractionCategoryDao {

	@Autowired
	AttractionCategoryRepository attractionCategoryRepository;
	
	// 명소 카테고리 추가
	@Override
	public AttractionCategory insert(AttractionCategory attractionCategory) {
		
		return attractionCategoryRepository.save(attractionCategory);
	}
	
	// 명소 카테고리 삭제
	@Override
	public void delete(Long acNo) {
		
		attractionCategoryRepository.deleteById(acNo);
	}
	
	// 명소 카테고리 수정
	@Override
	public AttractionCategory update(AttractionCategory attractionCategory) {
		
		return attractionCategoryRepository.save(attractionCategory);
	}
	
	// 명소 카테고리 리스트
	@Override
	public List<AttractionCategory> findAll() {
		
		return attractionCategoryRepository.findAll();
	}
	
	// 명소 카테고리 찾기
	@Override
	public AttractionCategory findByNo(Long acNo) {
		
		return attractionCategoryRepository.findById(acNo).get();
	}

}
