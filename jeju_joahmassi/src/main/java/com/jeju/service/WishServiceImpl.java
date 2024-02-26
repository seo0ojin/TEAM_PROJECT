package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeju.dao.HotelDao;
import com.jeju.dao.RestaurantDao;
import com.jeju.dao.UserinfoDao;
import com.jeju.dao.WishDao;
import com.jeju.entity.Wish;

@Service
@Transactional
public class WishServiceImpl implements WishService {

	@Autowired
	WishDao wishDao;
	@Autowired
	HotelDao hotelDao;
	@Autowired
	RestaurantDao restaurantDao;
	@Autowired
	UserinfoDao userinfoDao;

	// 위시리스트에 호텔 담기
	@Override
	public Wish insertWishByHotel(Wish wish) {
	
		Wish findHotel = wishDao.findByUserNoHotelNo(wish.getUserinfo().getUserNo(), wish.getHotel().getHotelNo());
		
		if (findHotel != null) {
			System.out.println("이미 존재하는 상품입니다.");
		} else {
			Wish insertWish = new Wish();
			insertWish.setUserinfo(wish.getUserinfo());
			insertWish.setWishCategory(wish.getWishCategory());
			insertWish.setHotel(wish.getHotel());
			insertWish.setRestaurant(null);
			insertWish.setAttraction(null);
			insertWish.setWishCategory("호텔");
			
			wishDao.insertWish(insertWish);
		}
		
		return wish;
	}

	// 위시리스트에 맛집 담기
	@Override
	public Wish insertWishByRestaurant(Wish wish) {
		
		Wish findRestaurant = wishDao.findByUserNoRestaurantNo(wish.getUserinfo().getUserNo(), wish.getRestaurant().getRestaurantNo());
		
		if (findRestaurant != null) {
			System.out.println("이미 존재하는 상품입니다.");
		} else {
			Wish insertWish = new Wish();
			insertWish.setUserinfo(wish.getUserinfo());
			insertWish.setWishCategory(wish.getWishCategory());
			insertWish.setRestaurant(wish.getRestaurant());
			insertWish.setHotel(null);
			insertWish.setAttraction(null);
			insertWish.setWishCategory("맛집");
			
			wishDao.insertWish(insertWish);
		}
		
		return wish;
	}
	
	// 위시리스트에 명소 담기
	@Override
	public Wish insertWishByAttraction(Wish wish) {
		
		Wish findAttraction = wishDao.findByUserNoAttractionNo(wish.getUserinfo().getUserNo(), wish.getAttraction().getAttractionNo());
		
		if (findAttraction != null) {
			System.out.println("이미 존재하는 상품입니다.");
		} else {
			Wish insertWish = new Wish();
			insertWish.setUserinfo(wish.getUserinfo());
			insertWish.setWishCategory(wish.getWishCategory());
			insertWish.setAttraction(wish.getAttraction());
			insertWish.setHotel(null);
			insertWish.setRestaurant(null);
			insertWish.setWishCategory("명소");
			
			wishDao.insertWish(insertWish);
		}
		
		return wish;
	}
	
	// 위시 삭제
	@Override
	public void deleteWish(Long wishNo) {
		
		wishDao.deleteWish(wishNo);
	}
	
	// 위시리스트(userNo)
	@Override
	public List<Wish> findAllWishByUserNo(Long userNo) {
		
		return wishDao.findAllWishByUserNo(userNo);
	}
	
	// 위시리스트 상세
	@Override
	public Wish findByWishNo(Long no) {
		
		return wishDao.findByWishNo(no);
	}
	
	// 위시리스트에 있는 개수 출력(userNo)
	@Override
	public Integer countWishList(Long userNo) {
		
		return wishDao.countWishList(userNo);
	}
	
	// 위시리스트에 호텔 있는지 확인
	@Override
	public boolean existByUserNoAnHotelNo(Long userNo, Long hotelNo) {
		
		return wishDao.existByUserNoAnHotelNo(userNo, hotelNo);
	}
	
	// 위시리스트에 맛집 있는지 확인
	@Override
	public boolean existByUserNoAndRestaurantNo(Long userNo, Long restaurantNo) {
		
		return wishDao.existByUserNoAndRestaurantNo(userNo, restaurantNo);
	}
	
	// 위시리스트에 명소 있는지 확인
	@Override
	public boolean existByUserNoAndAttractionNo(Long userNo, Long attractionNo) {
		
		return wishDao.existByUserNoAndAttractionNo(userNo, attractionNo);
	}

	@Override
	public List<Wish> findByUserinfo_UserNoAndWishCategory(Long userNo, String wishCategory) {
		return wishDao.findByUserinfo_UserNoAndWishCategory(userNo, wishCategory);
	}

	@Override
	public void deleteByUserinfoUserNoAndRestaurantRestaurantNo(Long userNo, Long restaurantNo) {
		wishDao.deleteByUserinfoUserNoAndRestaurantRestaurantNo(userNo,restaurantNo);
	}

	@Override
	public void deleteByUserinfoUserNoAndHotelHotelNo(Long userNo, Long hotelNo) {
		wishDao.deleteByUserinfoUserNoAndHotelHotelNo(userNo,hotelNo);
	}

	@Override
	public void deleteByUserinfoUserNoAndAttractionAttractionNo(Long userNo, Long attractionNo) {
		wishDao.deleteByUserinfoUserNoAndAttractionAttractionNo(userNo,attractionNo);
	}
	
	
}
