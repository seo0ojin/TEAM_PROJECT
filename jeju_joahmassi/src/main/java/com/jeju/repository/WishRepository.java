package com.jeju.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeju.entity.Wish;

public interface WishRepository extends JpaRepository<Wish, Long> {
	
	// 위시리스트(userNo)
	List<Wish> findByUserinfo_UserNo(Long userNo);
	
	// 위시리스트에 있는 개수 출력(userNo)
	Integer countByUserinfo_UserNo(Long userNo);
	
	// 위시리스트에서 userNo, hotelNo로 찾아오기
	Wish findByUserinfo_UserNoAndHotel_HotelNo(Long userNo, Long hotelNo);
	
	// 위시리스트에서 userNo, restaurantNo로 찾아오기
	Wish findByUserinfo_UserNoAndRestaurant_RestaurantNo(Long userNo, Long hotelNo);
	
	// 위시리스트에서 userNo, attractionNo로 찾아오기
	Wish findByUserinfo_UserNoAndAttraction_AttractionNo(Long userNo, Long hotelNo);	
	
	// 위시리스트에 호텔 있는지 확인
	boolean existsByUserinfo_UserNoAndHotel_HotelNo(Long userNo, Long hotelNo);
	
	// 위시리스트에 맛집 있는지 확인
	boolean existsByUserinfo_UserNoAndRestaurant_RestaurantNo(Long userNo, Long restaurantNo);
	
	// 위시리스트에 명소 있는지 확인
	boolean existsByUserinfo_UserNoAndAttraction_AttractionNo(Long userNo, Long attractionNo);
	
	// 식당 카테고리 위시 리스트
	public List<Wish> findByUserinfo_UserNoAndWishCategory(Long userNo , String wishCategory);
	
	// 해당 유저의 식당 위시 삭제
	public void deleteByUserinfoUserNoAndRestaurantRestaurantNo(Long userNo,Long restaurantNo);
	
	// 해당 유저의 호텔 위시 삭제
	public void deleteByUserinfoUserNoAndHotelHotelNo(Long userNo,Long hotelNo);
	
	// 해당 유저의 명소 위시 삭제
	public void deleteByUserinfoUserNoAndAttractionAttractionNo(Long userNo,Long attractionNo);
	
}