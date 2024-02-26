package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jeju.dao.RestaurantBookingDao;
import com.jeju.dao.RestaurantCategoryItemDao;
import com.jeju.dao.RestaurantDao;
import com.jeju.dao.RestaurantImageDao;
import com.jeju.dao.RestaurantMenuDao;
import com.jeju.dao.RestaurantReviewDao;
import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantBooking;
import com.jeju.entity.RestaurantCategoryItem;
import com.jeju.entity.RestaurantImage;
import com.jeju.entity.RestaurantMenu;
import com.jeju.entity.RestaurantReview;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	private RestaurantDao restaurantDao; 
	@Autowired
	private RestaurantBookingDao restaurantBookingDao;
	@Autowired
	private RestaurantCategoryItemDao restaurantCategoryItemDao;
	@Autowired
	private RestaurantImageDao restaurantImageDao;
	@Autowired
	private RestaurantMenuDao restaurantMenuDao;
	@Autowired
	private RestaurantReviewDao restaurantReviewDao;
	
	// 식당 추가
	@Override
	public Restaurant insert(Restaurant restaurant) {
		return restaurantDao.insert(restaurant);
	}
	
	// 식당 수정
	@Override
	public Restaurant update(Restaurant restaurant) {
		return restaurantDao.update(restaurant);
	}
	
	// 식당 번호로 1개 삭제
	@Override
	public void deleteByNo(Long restaurantNo) {
		
		Restaurant findRestaurant = restaurantDao.findByNo(restaurantNo);
		List<RestaurantBooking> restaurantBookingList = restaurantBookingDao.findByRestaurantRestaurantNo(restaurantNo);
		for (RestaurantBooking restaurantBooking : restaurantBookingList) {
			restaurantBookingDao.deleteByNo(restaurantBooking.getRbNo());
		}
		
		List<RestaurantCategoryItem> restaurantCategoryItemList =
				restaurantCategoryItemDao.findByRestaurantRestaurantNo(restaurantNo);
		for (RestaurantCategoryItem restaurantCategoryItem : restaurantCategoryItemList) {
			restaurantCategoryItemDao.deleteByNo(restaurantCategoryItem.getRciNo());
		}
		
		List<RestaurantImage> restaurantImageList =
				restaurantImageDao.findByRestaurantRestaurantNo(restaurantNo);
		for (RestaurantImage restaurantImage : restaurantImageList) {
			restaurantImageDao.deleteByNo(restaurantImage.getImageNo());
		}
		
		List<RestaurantMenu> restaurantMenuList =
				restaurantMenuDao.findByRestaurantRestaurantNo(restaurantNo);
		for (RestaurantMenu restaurantMenu : restaurantMenuList) {
			restaurantMenuDao.deleteByNo(restaurantMenu.getRmNo());
		}
		
		List<RestaurantReview> restaurantReviewList =
				restaurantReviewDao.findByRestaurantRestaurantNo(restaurantNo);
		for (RestaurantReview restaurantReview : restaurantReviewList) {
			restaurantReviewDao.deleteByNo(restaurantReview.getRrNo());
		}
		
		restaurantDao.deleteByNo(restaurantNo);
	}
	
	// 식당 전체리스트
	@Override
	public List<Restaurant> findAll() {
		return restaurantDao.findAll();
	}
	
	// 식당 번호로 1개 찾기
	@Override
	public Restaurant findByNo(Long restaurantNo) {
		return restaurantDao.findByNo(restaurantNo);
	}
	
	// 식당 전체리스트 페이징
	@Override
	public Page<Restaurant> findAllPage(Pageable pageable) {
		return restaurantDao.findAllPage(pageable);
	}
	
	// 식당 카테고리로 찾기 페이징
	/*
	@Override
	public Page<Restaurant> findByRestaurantCategory(String restaurantCategory, Pageable pageable) {
		return restaurantDao.findByRestaurantCategory(restaurantCategory, pageable);
	}
	*/
	// 식당 이름으로 검색 찾기 페이징
	@Override
	public Page<Restaurant> findByRestaurantNameLike(String restaurantName, Pageable pageable) {
		restaurantName = "%"+restaurantName+"%";
		return restaurantDao.findByRestaurantNameLike(restaurantName, pageable);
	}
	
	// 식당 주소로 찾기 페이징
	@Override
	public Page<Restaurant> findByRestaurantAddressLike(String restaurantAddress, Pageable pageable) {
		restaurantAddress = "%"+restaurantAddress+"%";
		return restaurantDao.findByRestaurantAddressLike(restaurantAddress, pageable);
	}

	@Override
	public List<Restaurant> findByRestaurantNameLike(String restaurantName) {
		restaurantName = "%"+restaurantName+"%";
		return restaurantDao.findByRestaurantNameLike(restaurantName);
	}

	@Override
	public List<Restaurant> findByRestaurantAddressLike(String restaurantAddress) {
		restaurantAddress = "%"+restaurantAddress+"%";
		return restaurantDao.findByRestaurantAddressLike(restaurantAddress);
	}

	@Override
	public List<Restaurant> findRestaurantOrderByReviewCountDesc() {
		return restaurantDao.findRestaurantOrderByReviewCountDesc();
	}

	@Override
	public List<Restaurant> findAllByOrderByRestaurantStarDesc() {
		return restaurantDao.findAllByOrderByRestaurantStarDesc();
	}

	@Override
	public List<Restaurant> findAllByBookingCountDesc() {
		return restaurantDao.findAllByBookingCountDesc();
	}

	@Override
	public List<Restaurant> findByRestaurantCategoryItemsRestaurantCategoryRcName(String rcName) {
		return restaurantDao.findByRestaurantCategoryItemsRestaurantCategoryRcName(rcName);
	}

	@Override
	public List<Restaurant> findByRestaurantCategoryItemsRestaurantCategoryRcNo(Long rcNo) {
		return restaurantDao.findByRestaurantCategoryItemsRestaurantCategoryRcNo(rcNo);
	}

	@Override
	public List<Restaurant> findByCategoryNoOrderByBookingsDesc(Long categoryNo) {
		return restaurantDao.findByCategoryNoOrderByBookingsDesc(categoryNo);
	}

	@Override
	public List<Restaurant> findByCategoryNoOrderByStars(Long categoryNo) {
		return restaurantDao.findByCategoryNoOrderByStars(categoryNo);
	}

	@Override
	public List<Restaurant> findByCategoryNoOrderByReviewsDesc(Long categoryNo) {
		return restaurantDao.findByCategoryNoOrderByReviewsDesc(categoryNo);
	}

	@Override
	public List<Restaurant> findRestaurantLikeRestaurantNameOrderByReviewCountDesc(String searchKeyword) {
		return restaurantDao.findRestaurantLikeRestaurantNameOrderByReviewCountDesc(searchKeyword);
	}

	@Override
	public List<Restaurant> findRestaurantLikeRestaurantNameByBookingCountDesc(String searchKeyword) {
		return restaurantDao.findRestaurantLikeRestaurantNameByBookingCountDesc(searchKeyword);
	}

	@Override
	public List<Restaurant> findRestaurantLikeRestaurantNameByOrderByRestaurantStarDesc(String searchKeyword) {
		return restaurantDao.findRestaurantLikeRestaurantNameByOrderByRestaurantStarDesc(searchKeyword);
	}

	@Override
	public List<Restaurant> findRestaurantLikeRestaurantNameByCategoryNoOrderByBookingsDesc(Long categoryNo,
			String searchKeyword) {
		return restaurantDao.findRestaurantLikeRestaurantNameByCategoryNoOrderByBookingsDesc(categoryNo,searchKeyword);
	}

	@Override
	public List<Restaurant> findRestaurantLikeRestaurantNameByCategoryNoOrderByStars(Long categoryNo,
			String searchKeyword) {
		return restaurantDao.findRestaurantLikeRestaurantNameByCategoryNoOrderByStars(categoryNo,searchKeyword);
	}

	@Override
	public List<Restaurant> findRestaurantLikeRestaurantNameByCategoryNoOrderByReviewsDesc(Long categoryNo,
			String searchKeyword) {
		return restaurantDao.findRestaurantLikeRestaurantNameByCategoryNoOrderByReviewsDesc(categoryNo,searchKeyword);
	}

	@Override
	public List<Restaurant> findByRestaurantCategoryItemsRestaurantCategoryRcNoAndRestaurantNameLike(Long rcNo,
			String searchKeyword) {
		return restaurantDao.findByRestaurantCategoryItemsRestaurantCategoryRcNoAndRestaurantNameLike(rcNo,searchKeyword);
	}

	/*
	// 메뉴로 식당 찾기
	@Override
	public List<Restaurant> findByRestaurantMenusRmNameLike(String rmName) {
		rmName = "%"+rmName+"%";
		return restaurantDao.findByRestaurantMenusRmNameLike(rmName);
	}

	// 메뉴로 식당 찾기 페이징
	@Override
	public Page<Restaurant> findByRestaurantMenusRmNameLike(String rmName, Pageable pageable) {
		rmName = "%"+rmName+"%";
		return restaurantDao.findByRestaurantMenusRmNameLike(rmName, pageable);
	}
	*/
}
