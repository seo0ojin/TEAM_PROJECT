package com.jeju.dao;

import java.util.List;

import com.jeju.entity.Wish;

public interface WishDao {

	// 위시리스트에 담기
	Wish insertWish(Wish wish);
	
	// 위시 삭제
	void deleteWish(Long wishNo);
	
	// 위시리스트(userNo)
	List<Wish> findAllWishByUserNo(Long userNo);
	
	// 위시리스트 상세
	Wish findByWishNo(Long no);
	
	// 위시리스트에 있는 개수 출력(userNo)
	Integer countWishList(Long userNo);
	
	// 위시리스트에서 userNo, hotelNo로 찾아오기
	Wish findByUserNoHotelNo(Long userNo, Long hotelNo);
	
	// 위시리스트에서 userNo, restaurantNo로 찾아오기
	Wish findByUserNoRestaurantNo(Long userNo, Long restaurantNo);
	
	// 위시리스트에서 userNo, attractionNo로 찾아오기
	Wish findByUserNoAttractionNo(Long userNo, Long attractionNo);
	
	// 위시리스트에 호텔 있는지 확인
	boolean existByUserNoAnHotelNo(Long userNo, Long hotelNo);
	
	// 위시리스트에 맛집 있는지 확인
	boolean existByUserNoAndRestaurantNo(Long userNo, Long restaurantNo);
	
	// 위시리스트에 명소 있는지 확인
	boolean existByUserNoAndAttractionNo(Long userNo, Long attractionNo);
	
	// 카테고리 위시 리스트
	public List<Wish> findByUserinfo_UserNoAndWishCategory(Long userNo , String wishCategory);
	
	// 해당 유저의 식당 위시 삭제
	public void deleteByUserinfoUserNoAndRestaurantRestaurantNo(Long userNo,Long restaurantNo);
	
	// 해당 유저의 호텔 위시 삭제
	public void deleteByUserinfoUserNoAndHotelHotelNo(Long userNo,Long hotelNo);
	
	// 해당 유저의 명소 위시 삭제
	public void deleteByUserinfoUserNoAndAttractionAttractionNo(Long userNo,Long attractionNo);
	
}
