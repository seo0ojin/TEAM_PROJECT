package com.jeju.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.jeju.entity.Hotel;

public interface HotelService {

	// 호텔 추가
	Hotel insertHotel(Hotel hotel);

	// 호텔 삭제
	void deleteByHotelNo(Long no);

	// 호텔 정보수정
	Hotel updateHotel(Hotel updateHotel);

	// 호텔 찾기
	Hotel findByHotelNo(Long hotelNo);

	// 호텔 리스트
	List<Hotel> findAllHotels();

	// 호텔 이름 검색
	Page<Hotel> findByHotelNameLike(String hotelName, Pageable pageable);
	List<Hotel> findByHotelNameLike(String hotelName);
	
	// 지역명으로 검색
	Page<Hotel> findByHotelLocalLike(String hotelLocal, Pageable pageable);
	List<Hotel> findByHotelLocalLike(String hotelLocal);
	
	// 카테고리 번호로 레스토랑 뽑기
	List<Hotel> findByHotelCategoryItemsHotelCategoryHcNo(Long hcNo);

	// 카테고리 아이템 번호를 가지고 있는 모든 호텔 리스트
	//List<Hotel> findByHotelCategoryItemsHciNo(Long hciNo);

	// 카테고리 아이템 번호를 가지고 있는 모든 호텔 리스트 (페이징)
	//Page<Hotel> findByHotelCategoryItemsHciNo(Long hciNo, Pageable pageable);

	// 별점 높은순 정렬
	List<Hotel> findAllByOrderByHotelStarDesc();

	// 가격 높은순 정렬
	List<Hotel> findAllByOrderByHotelPriceDesc();

	// 가격 낮은순 정렬
	List<Hotel> findAllByOrderByHotelPriceAsc();

	// 리뷰 많은순 정렬
	List<Hotel> findHotelOrderByReviewCountDesc();

	// 예약 많은순 정렬
	List<Hotel> findHotelOrderByBookingCountDesc();
	
	// 별점순 + 카테고리
	List<Hotel> findByCategoryNoOrderByStars(@Param("categoryNo") Long categoryNo);

	// 리뷰많은순 + 카테고리
	List<Hotel> findByCategoryNoOrderByReviewsDesc(@Param("categoryNo") Long categoryNo);

	// 예약많은순 + 카테고리
	List<Hotel> findByCategoryNoOrderByBookingsDesc(@Param("categoryNo") Long categoryNo);

	// 가격높은순 + 카테고리
	List<Hotel> findByCategoryNoOrderByPriceDesc(@Param("categoryNo") Long categoryNo);

	// 가격낮은순 + 카테고리
	List<Hotel> findByCategoryNoOrderByPriceAsc(@Param("categoryNo") Long categoryNo);

	
	
	/*************** 이름검색 + 카테고리 + 정렬 ****************/
	
	
	// 다른 테이블과 정렬
	// 이름검색 + 카테고리 + 예약 많은순(인기순)
	public List<Hotel> findHotelLikeHotelNameByCategoryNoOrderByBookingsDesc(Long categoryNo, String searchKeyword);

	// 이름검색 + 카테고리 + 리뷰 많은순
	public List<Hotel> findHotelLikeHotelNameByCategoryNoOrderByReviewsDesc(Long categoryNo, String searchKeyword);

	
	// 같은 테이블에서 정렬
	// 이름검색 + 카테고리 + 별점순
	public List<Hotel> findHotelLikeHotelNameByCategoryNoOrderByStars(Long categoryNo, String searchKeyword);

	// 이름검색 + 카테고리 + 가격높은순
	public List<Hotel> findHotelLikeHotelNameByCategoryNoOrderByPriceDesc(Long categoryNo, String searchKeyword);

	// 이름검색 + 카테고리 + 가격낮은순
	public List<Hotel> findHotelLikeHotelNameByCategoryNoOrderByPriceAsc(Long categoryNo, String searchKeyword);

	
	/*****************************************************/
	
	
	
	
	/*************** 주소검색 + 카테고리 + 정렬 ****************/
	
	/*
	// 다른 테이블과 정렬
	// 주소검색 + 카테고리 + 예약 많은순(인기순)
	public List<Hotel> findHotelLikeHotelLocalByCategoryNoOrderByBookingsDesc(Long categoryNo, String searchKeyword);

	// 주소검색 + 카테고리 + 리뷰 많은순
	public List<Hotel> findHotelLikeHotelLocalByCategoryNoOrderByReviewsDesc(Long categoryNo, String searchKeyword);

	
	// 같은 테이블에서 정렬
	// 주소검색 + 카테고리 + 별점순
	public List<Hotel> findHotelLikeHotelLocalByCategoryNoOrderByStars(Long categoryNo, String searchKeyword);

	// 주소검색 + 카테고리 + 가격높은순
	public List<Hotel> findHotelLikeHotelLocalByCategoryNoOrderByPriceDesc(Long categoryNo, String searchKeyword);

	// 주소검색 + 카테고리 + 가격낮은순
	public List<Hotel> findHotelLikeHotelLocalByCategoryNoOrderByPriceAsc(Long categoryNo, String searchKeyword);
	*/
	
	/*****************************************************/
	
	
	
	/******************* 이름검색 + 정렬 ********************/
	
	
	// 다른 테이블과 정렬
	// 이름검색 + 예약 많은순
	public List<Hotel> findHotelLikeHotelNameByBookingCountDesc(String searchKeyword);
	
	// 이름검색 + 리뷰 많은순
	public List<Hotel> findHotelLikeHotelNameOrderByReviewCountDesc(String searchKeyword);
	
	
	// 같은 테이블에서 정렬
	// 이름검색 + 별점 많은순
	public List<Hotel> findHotelLikeHotelNameByOrderByHotelStarDesc(String searchKeyword);
	// 이름검색 + 가격높은순
	public List<Hotel> findHotelLikeHotelNameByOrderByHotelPriceDesc(String searchKeyword);
	// 이름검색 + 가격낮은순
	public List<Hotel> findHotelLikeHotelNameByOrderByHotelPriceAsc(String searchKeyword);
	
	
	/****************************************************/
	
	
	
	/******************* 주소검색 + 정렬 ********************/
	
	
	// 다른 테이블과 정렬
	// 주소검색 + 예약 많은순
	public List<Hotel> findHotelLikeHotelLocalByBookingCountDesc(String searchKeyword);
	
	// 주소검색 + 리뷰 많은순
	public List<Hotel> findHotelLikeHotelLocalOrderByReviewCountDesc(String searchKeyword);
	
	
	// 같은 테이블에서 정렬
	// 주소검색 + 별점 많은순
	public List<Hotel> findHotelLikeHotelLocalByOrderByHotelStarDesc(String searchKeyword);
	// 주소검색 + 가격높은순
	public List<Hotel> findHotelLikeHotelLocalByOrderByHotelPriceDesc(String searchKeyword);
	// 주소검색 + 가격낮은순
	public List<Hotel> findHotelLikeHotelLocalByOrderByHotelPriceAsc(String searchKeyword);
	
	
	/****************************************************/
	
	
	
	/******************* 검색 + 카테고리 ********************/
	
	
	// 이름검색 + 카테고리
	public List<Hotel> findByHotelCategoryItemsHotelCategoryHcNoAndHotelNameLike(Long hcNo, String searchKeyword);

	// 주소검색 + 카테고리
	public List<Hotel> findByHotelCategoryItemsHotelCategoryHcNoAndHotelLocalLike(Long hcNo, String searchKeyword);
	
	
	/****************************************************/
	
	// 페이징
	Page<Hotel> hotelFindAllPage(Pageable pageable);
}
