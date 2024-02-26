package com.jeju.dao;

import java.util.List;

import com.jeju.entity.AttractionImage;

public interface AttractionImageDao {

	public AttractionImage insert(AttractionImage attractionImage);
	
	public void deleteByNo(Long imageNo);
	
	public AttractionImage update(AttractionImage attractionImage);
	
	public AttractionImage findByNo(Long imageNo);
	
	public List<AttractionImage> findAll();
	
	// 명소별 이미지
	List<AttractionImage> findByAttractionAttractionNo(Long attractionNo);
}
