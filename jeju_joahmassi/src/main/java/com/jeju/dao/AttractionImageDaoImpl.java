package com.jeju.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeju.entity.AttractionImage;
import com.jeju.repository.AttractionImageRepository;

@Repository
public class AttractionImageDaoImpl implements AttractionImageDao{

	@Autowired
	AttractionImageRepository attractionImageRepository;

	@Override
	public AttractionImage insert(AttractionImage attractionImage) {
		
		return attractionImageRepository.save(attractionImage);
	}

	@Override
	public void deleteByNo(Long imageNo) {
		
		attractionImageRepository.deleteById(imageNo);
	}

	@Override
	public AttractionImage update(AttractionImage attractionImage) {
		
		return attractionImageRepository.save(attractionImage);
	}

	@Override
	public AttractionImage findByNo(Long imageNo) {
		
		return attractionImageRepository.findById(imageNo).get();
	}

	@Override
	public List<AttractionImage> findAll() {
		
		return attractionImageRepository.findAll();
	}

	@Override
	public List<AttractionImage> findByAttractionAttractionNo(Long attractionNo) {
		
		return attractionImageRepository.findByAttractionAttractionNo(attractionNo);
	}
	
	
}
