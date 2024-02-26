package com.jeju.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.jeju.entity.Hotel;
import com.jeju.repository.HotelRepository;

@Repository
public class HotelDaoImpl implements HotelDao{

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	// 호텔 추가
	public Hotel insertHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Override
	// 호텔 삭제
	public void deleteByHotelNo(Long no) {
		hotelRepository.deleteById(no);
	}

	@Override
	// 호텔 정보수정
	public Hotel updateHotel(Hotel updateHotel) {
		return hotelRepository.save(updateHotel);
	}

	@Override
	// 호텔 찾기
	public Hotel findByHotelNo(Long hotelNo) {
		return hotelRepository.findById(hotelNo).get();
	}

	@Override
	// 호텔 리스트
	public List<Hotel> findAllHotels() {
		return hotelRepository.findAll();
	}

	@Override
	// 호텔 이름 검색
	public Page<Hotel> findByHotelNameLike(String hotelName, Pageable pageable) {
		return hotelRepository.findByHotelNameLike(hotelName, pageable);
	}
	
	/*
	@Override
	// 카테고리로 검색
	public Page<Hotel> findByHotelCategoryLike(String hotelCategory, Pageable pageable) {
		return hotelRepository.findByHotelCategoryLike(hotelCategory, pageable);
	}
	*/
	
	@Override
	// 지역명으로 검색
	public Page<Hotel> findByHotelLocalLike(String hotelLocal, Pageable pageable) {
		return hotelRepository.findByHotelLocalLike(hotelLocal, pageable);
	}

	@Override
	// 호텔 페이징
	public Page<Hotel> hotelFindAllPage(Pageable pageable) {
		Page<Hotel> hotelList = hotelRepository.findAll(pageable);
		return hotelList;
	}

	@Override
	public List<Hotel> findByHotelNameLike(String hotelName) {
		return hotelRepository.findByHotelNameLike(hotelName);
	}

	@Override
	public List<Hotel> findByHotelLocalLike(String hotelLocal) {
		return hotelRepository.findByHotelLocalLike(hotelLocal);
	}

	@Override
	public List<Hotel> findAllByOrderByHotelStarDesc() {
		return hotelRepository.findAllByOrderByHotelStarDesc();
	}

	@Override
	public List<Hotel> findAllByOrderByHotelPriceDesc() {
		return hotelRepository.findAllByOrderByHotelPriceDesc();
	}

	@Override
	public List<Hotel> findAllByOrderByHotelPriceAsc() {
		return hotelRepository.findAllByOrderByHotelPriceAsc();
	}

	@Override
	public List<Hotel> findHotelOrderByReviewCountDesc() {
		return hotelRepository.findHotelOrderByReviewCountDesc();
	}

	@Override
	public List<Hotel> findHotelOrderByBookingCountDesc() {
		return hotelRepository.findHotelOrderByBookingCountDesc();
	}

	@Override
	public List<Hotel> findByHotelCategoryItemsHotelCategoryHcNo(Long hcNo) {
		return hotelRepository.findByHotelCategoryItemsHotelCategoryHcNo(hcNo);
	}

	@Override
	public List<Hotel> findByCategoryNoOrderByStars(Long categoryNo) {
		return hotelRepository.findByCategoryNoOrderByStars(categoryNo);
	}

	@Override
	public List<Hotel> findByCategoryNoOrderByReviewsDesc(Long categoryNo) {
		return hotelRepository.findByCategoryNoOrderByReviewsDesc(categoryNo);
	}

	@Override
	public List<Hotel> findByCategoryNoOrderByBookingsDesc(Long categoryNo) {
		return hotelRepository.findByCategoryNoOrderByBookingsDesc(categoryNo);
	}

	@Override
	public List<Hotel> findByCategoryNoOrderByPriceDesc(Long categoryNo) {
		return hotelRepository.findByCategoryNoOrderByPriceDesc(categoryNo);
	}

	@Override
	public List<Hotel> findByCategoryNoOrderByPriceAsc(Long categoryNo) {
		return hotelRepository.findByCategoryNoOrderByPriceAsc(categoryNo);
	}

	@Override
	public List<Hotel> findHotelLikeHotelNameByCategoryNoOrderByBookingsDesc(Long categoryNo, String searchKeyword) {
		return hotelRepository.findHotelLikeHotelNameByCategoryNoOrderByBookingsDesc(categoryNo, searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelNameByCategoryNoOrderByReviewsDesc(Long categoryNo, String searchKeyword) {
		return hotelRepository.findHotelLikeHotelNameByCategoryNoOrderByReviewsDesc(categoryNo, searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelNameByCategoryNoOrderByStars(Long categoryNo, String searchKeyword) {
		return hotelRepository.findHotelLikeHotelNameByCategoryNoOrderByStars(categoryNo, searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelNameByCategoryNoOrderByPriceDesc(Long categoryNo, String searchKeyword) {
		return hotelRepository.findHotelLikeHotelNameByCategoryNoOrderByPriceDesc(categoryNo, searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelNameByCategoryNoOrderByPriceAsc(Long categoryNo, String searchKeyword) {
		return hotelRepository.findHotelLikeHotelNameByCategoryNoOrderByPriceAsc(categoryNo, searchKeyword);
	}
	
	/*
	@Override
	public List<Hotel> findHotelLikeHotelLocalByCategoryNoOrderByBookingsDesc(Long categoryNo, String searchKeyword) {
		return hotelRepository.findHotelLikeHotelLocalByCategoryNoOrderByBookingsDesc(categoryNo, searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelLocalByCategoryNoOrderByReviewsDesc(Long categoryNo, String searchKeyword) {
		return hotelRepository.findHotelLikeHotelLocalByCategoryNoOrderByReviewsDesc(categoryNo, searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelLocalByCategoryNoOrderByStars(Long categoryNo, String searchKeyword) {
		return hotelRepository.findHotelLikeHotelLocalByCategoryNoOrderByStars(categoryNo, searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelLocalByCategoryNoOrderByPriceDesc(Long categoryNo, String searchKeyword) {
		return hotelRepository.findHotelLikeHotelLocalByCategoryNoOrderByPriceDesc(categoryNo, searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelLocalByCategoryNoOrderByPriceAsc(Long categoryNo, String searchKeyword) {
		return hotelRepository.findHotelLikeHotelLocalByCategoryNoOrderByPriceAsc(categoryNo, searchKeyword);
	}
	*/
	
	
	
	@Override
	public List<Hotel> findHotelLikeHotelNameByBookingCountDesc(String searchKeyword) {
		return hotelRepository.findHotelLikeHotelNameByBookingCountDesc(searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelNameOrderByReviewCountDesc(String searchKeyword) {
		return hotelRepository.findHotelLikeHotelNameOrderByReviewCountDesc(searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelNameByOrderByHotelStarDesc(String searchKeyword) {
		return hotelRepository.findHotelLikeHotelNameByOrderByHotelStarDesc(searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelNameByOrderByHotelPriceDesc(String searchKeyword) {
		return hotelRepository.findHotelLikeHotelNameByOrderByHotelPriceDesc(searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelNameByOrderByHotelPriceAsc(String searchKeyword) {
		return hotelRepository.findHotelLikeHotelNameByOrderByHotelPriceAsc(searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelLocalByBookingCountDesc(String searchKeyword) {
		return hotelRepository.findHotelLikeHotelLocalByBookingCountDesc(searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelLocalOrderByReviewCountDesc(String searchKeyword) {
		return hotelRepository.findHotelLikeHotelLocalOrderByReviewCountDesc(searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelLocalByOrderByHotelStarDesc(String searchKeyword) {
		return hotelRepository.findHotelLikeHotelLocalByOrderByHotelStarDesc(searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelLocalByOrderByHotelPriceDesc(String searchKeyword) {
		return hotelRepository.findHotelLikeHotelLocalByOrderByHotelPriceDesc(searchKeyword);
	}

	@Override
	public List<Hotel> findHotelLikeHotelLocalByOrderByHotelPriceAsc(String searchKeyword) {
		return hotelRepository.findHotelLikeHotelLocalByOrderByHotelPriceAsc(searchKeyword);
	}

	@Override
	public List<Hotel> findByHotelCategoryItemsHotelCategoryHcNoAndHotelNameLike(Long hcNo, String searchKeyword) {
		return hotelRepository.findByHotelCategoryItemsHotelCategoryHcNoAndHotelNameLike(hcNo, searchKeyword);
	}

	@Override
	public List<Hotel> findByHotelCategoryItemsHotelCategoryHcNoAndHotelLocalLike(Long hcNo, String searchKeyword) {
		return hotelRepository.findByHotelCategoryItemsHotelCategoryHcNoAndHotelLocalLike(hcNo, searchKeyword);
	}

	/*
	@Override
	// 카테고리 아이템 번호를 가지고 있는 모든 호텔 리스트
	public List<Hotel> findByHotelCategoryItemsHciNo(Long hciNo) {
		return hotelRepository.findByHotelCategoryItemsHciNo(hciNo);
	}

	@Override
	// 카테고리 아이템 번호를 가지고 있는 모든 호텔 리스트 (페이징)
	public Page<Hotel> findByHotelCategoryItemsHciNo(Long hciNo, Pageable pageable) {
		return hotelRepository.findByHotelCategoryItemsHciNo(hciNo, pageable);
	}
	*/
	
}
