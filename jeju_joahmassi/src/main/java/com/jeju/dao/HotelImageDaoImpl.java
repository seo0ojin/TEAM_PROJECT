package com.jeju.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeju.entity.HotelImage;
import com.jeju.repository.HotelImageRepository;

@Repository
public class HotelImageDaoImpl implements HotelImageDao{

	@Autowired
	private HotelImageRepository hotelImageRepository;

	@Override
	public HotelImage insert(HotelImage insertImage) {
		return hotelImageRepository.save(insertImage);
	}

	@Override
	public void deleteByNo(Long imageNo) {
		hotelImageRepository.deleteById(imageNo);
	}

	@Override
	public HotelImage update(HotelImage updateImage) {
		return hotelImageRepository.save(updateImage);
	}

	@Override
	public HotelImage findByNo(Long iamgeNo) {
		return hotelImageRepository.findById(iamgeNo).get();
	}

	@Override
	public List<HotelImage> findAll() {
		return hotelImageRepository.findAll();
	}

	@Override
	public List<HotelImage> findByHotelHotelNo(Long hotelNo) {
		return hotelImageRepository.findByHotelHotelNo(hotelNo);
	}
	
}
