package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jeju.dao.AttractionCategoryItemDao;
import com.jeju.entity.AttractionCategoryItem;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AttractionCategoryItemServiceImpl implements AttractionCategoryItemService{
	
	@Autowired
	private AttractionCategoryItemDao attractionCategoryItemDao;
	
	// 카테고리 아이템 추가
	@Override
	public AttractionCategoryItem insert(AttractionCategoryItem attractionCategoryItem) {
		return attractionCategoryItemDao.insert(attractionCategoryItem);
	}
	
	// 카테고리 아이템 삭제
	@Override
	public void deleteByNo(Long aciNo) {
		attractionCategoryItemDao.deleteByNo(aciNo);
	}

	// 카테고리 아이템 수정
	@Override
	public AttractionCategoryItem update(AttractionCategoryItem attractionCategoryItem) {
		return attractionCategoryItemDao.update(attractionCategoryItem);
	}

	// 카테고리 아이템 찾기
	@Override
	public AttractionCategoryItem findByNo(Long aciNo) {
		return attractionCategoryItemDao.findByNo(aciNo);
	}

	// 카테고리 아이템 리스트
	@Override
	public List<AttractionCategoryItem> findAll() {
		return attractionCategoryItemDao.findAll();
	}

	// 명소 번호로 카테고리 아이템 찾기
	@Override
	public Page<AttractionCategoryItem> findByAttractionAttractionNo(Long attractionNo, Pageable pageable) {
		return attractionCategoryItemDao.findByAttractionAttractionNo(attractionNo, pageable);
	}

	// 카테고리 번호로 카테고리 아이템 찾기
	@Override
	public Page<AttractionCategoryItem> findByAttractionCategoryAcNo(Long acNo, Pageable pageable) {
		return attractionCategoryItemDao.findByAttractionCategoryAcNo(acNo, pageable);
	}

	// 카테고리 번호로 카테고리 아이템 찾기
	@Override
	public List<AttractionCategoryItem> findByAttractionCategoryAcNo(Long acNo) {
		
		return attractionCategoryItemDao.findByAttractionCategoryAcNo(acNo);
	}

}
