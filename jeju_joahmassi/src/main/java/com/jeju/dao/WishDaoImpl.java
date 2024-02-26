package com.jeju.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeju.entity.Wish;
import com.jeju.repository.WishRepository;

@Repository
public class WishDaoImpl implements WishDao {

	@Autowired
	WishRepository wishRepository;
	
	// 위시리스트에 담기
	@Override
	public Wish insertWish(Wish wish) {
		
		return wishRepository.save(wish);
	}

	// 위시 삭제
	@Override
	public void deleteWish(Long wishNo) {
		
		wishRepository.deleteById(wishNo);
	}

	// 위시리스트(userNo)
	@Override
	public List<Wish> findAllWishByUserNo(Long userNo) {
		
		return wishRepository.findByUserinfo_UserNo(userNo);
	}
	

	// 위시리스트 상세
	@Override
	public Wish findByWishNo(Long no) {
		
		return wishRepository.findById(no).get();
	}

	// 위시리스트에 있는 개수 출력(userNo)
	@Override
	public Integer countWishList(Long userNo) {
		
		return wishRepository.countByUserinfo_UserNo(userNo);
	}
	
	// 위시리스트에서 userNo, hotelNo로 찾아오기
	@Override
	public Wish findByUserNoHotelNo(Long userNo, Long hotelNo) {
		
		return wishRepository.findByUserinfo_UserNoAndHotel_HotelNo(userNo, hotelNo);
	}

	// 위시리스트에서 userNo, restaurantNo로 찾아오기
	@Override
	public Wish findByUserNoRestaurantNo(Long userNo, Long hotelNo) {
		
		return wishRepository.findByUserinfo_UserNoAndRestaurant_RestaurantNo(userNo, hotelNo);
	}

	// 위시리스트에서 userNo, attractionNo로 찾아오기
	@Override
	public Wish findByUserNoAttractionNo(Long userNo, Long hotelNo) {
		
		return wishRepository.findByUserinfo_UserNoAndAttraction_AttractionNo(userNo, hotelNo);
	}

	// 위시리스트에 호텔 있는지 확인
	@Override
	public boolean existByUserNoAnHotelNo(Long userNo, Long hotelNo) {
		
		return wishRepository.existsByUserinfo_UserNoAndHotel_HotelNo(userNo, hotelNo);
	}

	// 위시리스트에 맛집 있는지 확인
	@Override
	public boolean existByUserNoAndRestaurantNo(Long userNo, Long restaurantNo) {
		
		return wishRepository.existsByUserinfo_UserNoAndRestaurant_RestaurantNo(userNo, restaurantNo);
	}

	// 위시리스트에 명소 있는지 확인
	@Override
	public boolean existByUserNoAndAttractionNo(Long userNo, Long attractionNo) {
		
		return wishRepository.existsByUserinfo_UserNoAndAttraction_AttractionNo(userNo, attractionNo);
	}

	@Override
	public List<Wish> findByUserinfo_UserNoAndWishCategory(Long userNo, String wishCategory) {
		return wishRepository.findByUserinfo_UserNoAndWishCategory(userNo,wishCategory);
	}

	@Override
	public void deleteByUserinfoUserNoAndRestaurantRestaurantNo(Long userNo, Long restaurantNo) {
		wishRepository.deleteByUserinfoUserNoAndRestaurantRestaurantNo(userNo,restaurantNo);
	}

	@Override
	public void deleteByUserinfoUserNoAndHotelHotelNo(Long userNo, Long hotelNo) {
		wishRepository.deleteByUserinfoUserNoAndHotelHotelNo(userNo,hotelNo);
	}

	@Override
	public void deleteByUserinfoUserNoAndAttractionAttractionNo(Long userNo, Long attractionNo) {
		wishRepository.deleteByUserinfoUserNoAndAttractionAttractionNo(userNo,attractionNo);
	}
	
}
