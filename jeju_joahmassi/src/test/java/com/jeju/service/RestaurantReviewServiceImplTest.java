package com.jeju.service;

import static org.junit.jupiter.api.Assertions.*;

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
import com.jeju.entity.RestaurantReview;

import jakarta.transaction.Transactional;

class RestaurantReviewServiceImplTest extends JejuJoahmassiApplicationTests{
	
	@Autowired
	private RestaurantReviewService restaurantReviewService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private UserinfoService userinfoService;
	
	@Transactional
	@Rollback(false)
	@Disabled
	@Test
	void testInsert() {
		restaurantReviewService.insert(RestaurantReview.builder()
								.restaurant(restaurantService.findByNo(2L))
								.userinfo(userinfoService.findByUserNo(2L))
								.rrContent("맛있어요")
								//.rrDate(LocalDateTime.now())
								.rrStar(3.0)
								.build());
	}

	@Transactional
	@Rollback(false)
	@Disabled
	@Test
	void testDeleteByNo() {
		fail("Not yet implemented");
	}

	@Transactional
	@Rollback(false)
	@Disabled
	@Test
	void testUpdate() {
		restaurantReviewService.update(RestaurantReview.builder()
									.restaurant(restaurantService.findByNo(2L))
									.userinfo(userinfoService.findByUserNo(2L))
									.rrContent("그저그럼")
									//.rrDate(LocalDateTime.now())
									.rrStar(3.0)
									.rrNo(4L)
									.build());
	}

	@Transactional
	@Rollback(false)
	@Disabled
	@Test
	void testFindAll() {
		System.out.println(restaurantReviewService.findAll());
	}

	@Transactional
	@Rollback(false)
	@Disabled
	@Test
	void testFindByNo() {
		System.out.println(restaurantReviewService.findByNo(3L));
	}

	@Transactional
	@Rollback(false)
	@Disabled
	@Test
	void testFindByRestaurantRestaurantNoLong() {
		System.out.println(restaurantReviewService.findByRestaurantRestaurantNo(2L));
	}

	@Transactional
	@Rollback(false)
	@Disabled
	@Test
	void testFindByUserinfoUserNoLong() {
		System.out.println(restaurantReviewService.findByUserinfoUserNo(1L));
	}

	@Transactional
	@Rollback(false)
	@Disabled
	@Test
	void testFindByRestaurantRestaurantNoLongPageable() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("rrStar")));
		Page<RestaurantReview> page = restaurantReviewService.findByRestaurantRestaurantNo(1L, pageable);
		System.out.println(page.getContent());
	}

	@Transactional
	@Rollback(false)
	@Disabled
	@Test
	void testFindByUserinfoUserNoLongPageable() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("rciNo")));
		Page<RestaurantReview> page = restaurantReviewService.findByUserinfoUserNo(1L, pageable);
		System.out.println(page.getContent());
	}

}
