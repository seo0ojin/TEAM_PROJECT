package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jeju.dao.HotelDao;
import com.jeju.entity.Hotel;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelDao hotelDao;
	
	@Override
	// 호텔 추가
	public Hotel insertHotel(Hotel hotel) {
		return hotelDao.insertHotel(hotel);
	}

	@Override
	// 호텔 삭제
	public void deleteByHotelNo(Long no) {
		hotelDao.deleteByHotelNo(no);
	}

	@Override
	// 호텔 정보수정
	public Hotel updateHotel(Hotel updateHotel) {
		return hotelDao.updateHotel(updateHotel);
	}

	@Override
	// 호텔 찾기
	public Hotel findByHotelNo(Long hotelNo) {
		return hotelDao.findByHotelNo(hotelNo);
	}

	@Override
	// 호텔 리스트
	public List<Hotel> findAllHotels() {
		return hotelDao.findAllHotels();
	}

	@Override
	// 호텔 검색
	public Page<Hotel> findByHotelNameLike(String hotelName, Pageable pageable) {
		return hotelDao.findByHotelNameLike("%" + hotelName + "%", pageable);
	}

	/*
	@Override
	// 카테고리로 검색
	public Page<Hotel> findByHotelCategoryLike(String hotelCategory, Pageable pageable) {
		return hotelDao.findByHotelCategoryLike(hotelCategory, pageable);
	}
	*/
	
	@Override
	// 지역명으로 검색
	public Page<Hotel> findByHotelLocalLike(String hotelLocal, Pageable pageable) {
		return hotelDao.findByHotelLocalLike("%" + hotelLocal + "%", pageable);
	}
	
	@Override
	// 호텔 페이징
	public Page<Hotel> hotelFindAllPage(Pageable pageable) {
		Page<Hotel> hotelList = hotelDao.hotelFindAllPage(pageable);
		return hotelList;
	}

	@Override
	public List<Hotel> findByHotelNameLike(String hotelName) {
		return hotelDao.findByHotelNameLike("%" + hotelName + "%");
	}

	@Override
	public List<Hotel> findByHotelLocalLike(String hotelLocal) {
		return hotelDao.findByHotelLocalLike("%" + hotelLocal + "%");
	}

	@Override
	public List<Hotel> findAllByOrderByHotelStarDesc() {
		return hotelDao.findAllByOrderByHotelStarDesc();
	}

	@Override
	public List<Hotel> findAllByOrderByHotelPriceDesc() {
		return hotelDao.findAllByOrderByHotelPriceDesc();
	}

	@Override
	public List<Hotel> findAllByOrderByHotelPriceAsc() {
		return hotelDao.findAllByOrderByHotelPriceAsc();
	}

	@Override
	public List<Hotel> findHotelOrderByReviewCountDesc() {
		return hotelDao.findHotelOrderByReviewCountDesc();
	}

	@Override
	public List<Hotel> findHotelOrderByBookingCountDesc() {
		return hotelDao.findHotelOrderByBookingCountDesc();
	}

	@Override
	public List<Hotel> findByHotelCategoryItemsHotelCategoryHcNo(Long hcNo) {
		return hotelDao.findByHotelCategoryItemsHotelCategoryHcNo(hcNo);
	}

	@Override
	public List<Hotel> findByCategoryNoOrderByStars(Long categoryNo) {
		return hotelDao.findByCategoryNoOrderByStars(categoryNo);
	}

	@Override
	public List<Hotel> findByCategoryNoOrderByReviewsDesc(Long categoryNo) {
		return hotelDao.findByCategoryNoOrderByReviewsDesc(categoryNo);
	}

	@Override
	public List<Hotel> findByCategoryNoOrderByBookingsDesc(Long categoryNo) {
		return hotelDao.findByCategoryNoOrderByBookingsDesc(categoryNo);
	}

	@Override
	public List<Hotel> findByCategoryNoOrderByPriceDesc(Long categoryNo) {
		return hotelDao.findByCategoryNoOrderByPriceDesc(categoryNo);
	}

	@Override
	public List<Hotel> findByCategoryNoOrderByPriceAsc(Long categoryNo) {
		return hotelDao.findByCategoryNoOrderByPriceAsc(categoryNo);
	}
	
	
	
	/**********************************삼중정렬************************************/
	
	
	
	@Override
	public List<Hotel> findHotelLikeHotelNameByCategoryNoOrderByBookingsDesc(Long categoryNo, String searchKeyword) {
		return hotelDao.findHotelLikeHotelNameByCategoryNoOrderByBookingsDesc(categoryNo, searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelNameByCategoryNoOrderByReviewsDesc(Long categoryNo, String searchKeyword) {
		return hotelDao.findHotelLikeHotelNameByCategoryNoOrderByReviewsDesc(categoryNo, searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelNameByCategoryNoOrderByStars(Long categoryNo, String searchKeyword) {
		return hotelDao.findHotelLikeHotelNameByCategoryNoOrderByStars(categoryNo, searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelNameByCategoryNoOrderByPriceDesc(Long categoryNo, String searchKeyword) {
		return hotelDao.findHotelLikeHotelNameByCategoryNoOrderByPriceDesc(categoryNo, searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelNameByCategoryNoOrderByPriceAsc(Long categoryNo, String searchKeyword) {
		return hotelDao.findHotelLikeHotelNameByCategoryNoOrderByPriceAsc(categoryNo, searchKeyword);
	}
	
	/*
	@Override
	public List<Hotel> findHotelLikeHotelLocalByCategoryNoOrderByBookingsDesc(Long categoryNo, String searchKeyword) {
		return hotelDao.findHotelLikeHotelLocalByCategoryNoOrderByBookingsDesc(categoryNo, searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelLocalByCategoryNoOrderByReviewsDesc(Long categoryNo, String searchKeyword) {
		return hotelDao.findHotelLikeHotelLocalByCategoryNoOrderByReviewsDesc(categoryNo, searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelLocalByCategoryNoOrderByStars(Long categoryNo, String searchKeyword) {
		return hotelDao.findHotelLikeHotelLocalByCategoryNoOrderByStars(categoryNo, searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelLocalByCategoryNoOrderByPriceDesc(Long categoryNo, String searchKeyword) {
		return hotelDao.findHotelLikeHotelLocalByCategoryNoOrderByPriceDesc(categoryNo, searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelLocalByCategoryNoOrderByPriceAsc(Long categoryNo, String searchKeyword) {
		return hotelDao.findHotelLikeHotelLocalByCategoryNoOrderByPriceAsc(categoryNo, searchKeyword);
	}
	*/
	
	
	
	
	/**********************************삼중정렬 끝************************************/
	
	
	
	
	
	@Override
	public List<Hotel> findHotelLikeHotelNameByBookingCountDesc(String searchKeyword) {
		return hotelDao.findHotelLikeHotelNameByBookingCountDesc(searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelNameOrderByReviewCountDesc(String searchKeyword) {
		return hotelDao.findHotelLikeHotelNameOrderByReviewCountDesc(searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelNameByOrderByHotelStarDesc(String searchKeyword) {
		return hotelDao.findHotelLikeHotelNameByOrderByHotelStarDesc(searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelNameByOrderByHotelPriceDesc(String searchKeyword) {
		return hotelDao.findHotelLikeHotelNameByOrderByHotelPriceDesc(searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelNameByOrderByHotelPriceAsc(String searchKeyword) {
		return hotelDao.findHotelLikeHotelNameByOrderByHotelPriceAsc(searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelLocalByBookingCountDesc(String searchKeyword) {
		return hotelDao.findHotelLikeHotelLocalByBookingCountDesc(searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelLocalOrderByReviewCountDesc(String searchKeyword) {
		return hotelDao.findHotelLikeHotelLocalOrderByReviewCountDesc(searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelLocalByOrderByHotelStarDesc(String searchKeyword) {
		return hotelDao.findHotelLikeHotelLocalByOrderByHotelStarDesc(searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelLocalByOrderByHotelPriceDesc(String searchKeyword) {
		return hotelDao.findHotelLikeHotelLocalByOrderByHotelPriceDesc(searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelLocalByOrderByHotelPriceAsc(String searchKeyword) {
		return hotelDao.findHotelLikeHotelLocalByOrderByHotelPriceAsc(searchKeyword);
	}

	@Override
	public List<Hotel> findByHotelCategoryItemsHotelCategoryHcNoAndHotelNameLike(Long hcNo, String searchKeyword) {
		return hotelDao.findByHotelCategoryItemsHotelCategoryHcNoAndHotelNameLike(hcNo, searchKeyword);
	}

	@Override
	public List<Hotel> findByHotelCategoryItemsHotelCategoryHcNoAndHotelLocalLike(Long hcNo, String searchKeyword) {
		return hotelDao.findByHotelCategoryItemsHotelCategoryHcNoAndHotelLocalLike(hcNo, searchKeyword);
	}

	/*
	@Override
	// 카테고리 아이템 번호를 가지고 있는 모든 호텔 리스트
	public List<Hotel> findByHotelCategoryItemsHciNo(Long hciNo) {
		return hotelDao.findByHotelCategoryItemsHciNo(hciNo);
	}

	@Override
	// 카테고리 아이템 번호를 가지고 있는 모든 호텔 리스트 (페이징)
	public Page<Hotel> findByHotelCategoryItemsHciNo(Long hciNo, Pageable pageable) {
		return hotelDao.findByHotelCategoryItemsHciNo(hciNo, pageable);
	}
	*/
	
}
