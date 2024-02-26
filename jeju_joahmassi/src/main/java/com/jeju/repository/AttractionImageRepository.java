package com.jeju.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeju.entity.AttractionImage;

public interface AttractionImageRepository extends JpaRepository<AttractionImage, Long> {

	// 명소별 이미지
	List<AttractionImage> findByAttractionAttractionNo(Long attractionNo);
}
