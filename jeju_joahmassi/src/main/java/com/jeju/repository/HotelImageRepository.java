package com.jeju.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeju.entity.HotelImage;
import com.jeju.entity.HotelQnA;

public interface HotelImageRepository extends JpaRepository<HotelImage, Long>{

	// 호텔별 이미지
	List<HotelImage> findByHotelHotelNo(Long hotelNo);
}
