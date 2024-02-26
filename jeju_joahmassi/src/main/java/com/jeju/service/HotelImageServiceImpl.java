package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.dao.HotelImageDao;
import com.jeju.entity.HotelImage;

@Service
public class HotelImageServiceImpl implements HotelImageService{

	@Autowired
	private HotelImageDao hotelImageDao;
	
	@Override
	public HotelImage insert(HotelImage insertImage) {
		return hotelImageDao.insert(insertImage);
	}

	@Override
	public void deleteByNo(Long imageNo) {
		hotelImageDao.deleteByNo(imageNo);
	}

	@Override
	public HotelImage update(HotelImage updateImage) {
		return hotelImageDao.update(updateImage);
	}

	@Override
	public HotelImage findByNo(Long imageNo) {
		return hotelImageDao.findByNo(imageNo);
	}

	@Override
	public List<HotelImage> findAll() {
		return hotelImageDao.findAll();
	}

	@Override
	public List<HotelImage> findByHotelHotelNo(Long hotelNo) {
		return hotelImageDao.findByHotelHotelNo(hotelNo);
	}

}
