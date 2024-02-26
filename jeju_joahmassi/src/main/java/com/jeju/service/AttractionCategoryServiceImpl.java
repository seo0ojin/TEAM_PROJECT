package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeju.dao.AttractionCategoryDao;
import com.jeju.dao.AttractionDao;
import com.jeju.entity.AttractionCategory;

@Service
@Transactional
public class AttractionCategoryServiceImpl implements AttractionCategoryService {

	@Autowired
	private AttractionCategoryDao attractionCategoryDao;
	
	// 명소 카테고리 추가
	@Override
	public AttractionCategory insert(AttractionCategory attractionCategory) {
		
		return attractionCategoryDao.insert(attractionCategory);
	}
	
	// 명소 카테고리 삭제
	@Override
	public void delete(Long acNo) {
		
		attractionCategoryDao.delete(acNo);
	}
	
	// 명소 카테고리 수정
	@Override
	public AttractionCategory update(AttractionCategory attractionCategory) {
		
		return attractionCategoryDao.update(attractionCategory);
	}
	
	// 명소 카테고리 리스트
	@Override
	public List<AttractionCategory> findAll() {
		
		return attractionCategoryDao.findAll();
	}
	
	// 명소 카테고리 찾기
	@Override
	public AttractionCategory findByNo(Long acNo) {
		
		return attractionCategoryDao.findByNo(acNo);
	}

}
