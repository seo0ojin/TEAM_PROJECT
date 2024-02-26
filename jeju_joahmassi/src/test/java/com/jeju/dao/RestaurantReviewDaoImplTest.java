package com.jeju.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantReview;
import com.jeju.service.RestaurantService;
import com.jeju.service.UserinfoService;

import jakarta.transaction.Transactional;

class RestaurantReviewDaoImplTest extends JejuJoahmassiApplicationTests{
	
	@Autowired
	private RestaurantReviewDao restaurantReviewDao;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private UserinfoService userinfoService;
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testInsert() {
		restaurantReviewDao.insert(RestaurantReview.builder()
													.restaurant(restaurantService.findByNo(1L))
													.userinfo(userinfoService.findByUserNo(1L))
													.rrContent("맛있어요")
													//.rrDate(LocalDateTime.now())
													.rrStar(4.5)
													.build());
	}
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testDeleteByNo() {
		fail("Not yet implemented");
	}
	
	@Disabled
	@Transactional
	@Rollback(false)
	@Test	
	void testUpdate() {
		restaurantReviewDao.update(RestaurantReview.builder()
									.restaurant(restaurantService.findByNo(1L))
									.userinfo(userinfoService.findByUserNo(1L))
									.rrContent("맛있었습니다")
									//.rrDate(LocalDateTime.now())
									.rrStar(4.5)
									.rrNo(2L)
									.build());
	}

	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindAll() {
		System.out.println(restaurantReviewDao.findAll());
	}

	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindByNo() {
		System.out.println(restaurantReviewDao.findByNo(2L));
	}

	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindByRestaurantRestaurantNoLong() {
		System.out.println(restaurantReviewDao.findByRestaurantRestaurantNo(1L));
	}

	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindByUserinfoUserNoLong() {
		System.out.println(restaurantReviewDao.findByUserinfoUserNo(1L));
	}

	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindByRestaurantRestaurantNoLongPageable() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("rrStar")));
		Page<RestaurantReview> page = restaurantReviewDao.findByRestaurantRestaurantNo(1L, pageable);
		System.out.println(page.getContent());
	}

	@Disabled
	@Transactional
	@Rollback(false)
	@Test
	void testFindByUserinfoUserNoLongPageable() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("rrStar")));
		Page<RestaurantReview> page = restaurantReviewDao.findByUserinfoUserNo(1L, pageable);
		System.out.println(page.getContent());
	}

}
