package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.dao.AttractionImageDao;
import com.jeju.entity.AttractionImage;
import com.jeju.entity.RestaurantImage;

@Service
public class AttractionImageServiceImpl implements AttractionImageService {

	@Autowired
	AttractionImageDao attractionImageDao;

	@Override
	public AttractionImage insert(AttractionImage attractionImage) {
		
		return attractionImageDao.insert(attractionImage);
	}

	@Override
	public void deleteByNo(Long imageNo) {
		
		attractionImageDao.deleteByNo(imageNo);
		
	}

	@Override
	public AttractionImage update(AttractionImage attractionImage) {
		
		return attractionImageDao.update(attractionImage);
	}

	@Override
	public AttractionImage findByNo(Long imageNo) {
		
		return attractionImageDao.findByNo(imageNo);
	}

	@Override
	public List<AttractionImage> findAll() {
		
		return attractionImageDao.findAll();
	}

	@Override
	public List<AttractionImage> findByAttractionAttractionNo(Long attractionNo) {
		
		return attractionImageDao.findByAttractionAttractionNo(attractionNo);
	}

	
	
	
}
