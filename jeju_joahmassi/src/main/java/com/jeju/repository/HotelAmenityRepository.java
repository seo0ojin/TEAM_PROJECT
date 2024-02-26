package com.jeju.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeju.entity.HotelAmenity;

public interface HotelAmenityRepository extends JpaRepository<HotelAmenity, Long>{
	
	// 호텔번호로 편의성 가져오기
	public List<HotelAmenity> findByHotelHotelNo(Long hotelNo);
	
}
