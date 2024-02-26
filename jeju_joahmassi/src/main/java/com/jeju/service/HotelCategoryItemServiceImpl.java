package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jeju.dao.HotelCategoryItemDao;
import com.jeju.entity.HotelCategoryItem;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class HotelCategoryItemServiceImpl implements HotelCategoryItemService{

	@Autowired
	HotelCategoryItemDao hotelcategoryItemDao;
	
	@Override
	public HotelCategoryItem insert(HotelCategoryItem category) {
		return hotelcategoryItemDao.insert(category);
	}

	@Override
	public void deleteByNo(Long hciNo) {
		hotelcategoryItemDao.deleteByNo(hciNo);
	}

	@Override
	public HotelCategoryItem update(HotelCategoryItem update) {
		return hotelcategoryItemDao.update(update);
	}

	@Override
	public HotelCategoryItem findByNo(Long hciNo) {
		return hotelcategoryItemDao.findByNo(hciNo);
	}

	@Override
	public List<HotelCategoryItem> findAll() {
		return hotelcategoryItemDao.findAll();
	}

	@Override
	public List<HotelCategoryItem> findByHotelHotelNo(Long hotelNo) {
		return hotelcategoryItemDao.findByHotelHotelNo(hotelNo);
	}

	@Override
	public List<HotelCategoryItem> findByHotelCategoryHcNo(Long hcNo) {
		return hotelcategoryItemDao.findByHotelCategoryHcNo(hcNo);
	}

	@Override
	public Page<HotelCategoryItem> findByHotelCategoryHcNo(Long hcNo, Pageable pageable) {
		return hotelcategoryItemDao.findByHotelCategoryHcNo(hcNo, pageable);
	}


}
