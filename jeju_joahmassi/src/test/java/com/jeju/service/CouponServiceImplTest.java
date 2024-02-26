package com.jeju.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.entity.Coupon;
import com.jeju.entity.Userinfo;

class CouponServiceImplTest extends JejuJoahmassiApplicationTests {
	
	@Autowired
	CouponService couponService;

	// 쿠폰 생성
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testCreateCoupon() {
		Userinfo userInfo = Userinfo.builder().userId("dddd").build();
		
		Coupon coupon = Coupon.builder()
								.couponDiscount(30)
								.couponName("가입쿠폰")
								.userinfo(userInfo)
								.build();
		coupon.setCouponDate(1L);
		couponService.createCoupon(coupon);
		
		Coupon coupon2 = Coupon.builder()
								.couponDiscount(30)
								.couponName("생일쿠폰")
								.userinfo(userInfo)
								.build();
		coupon2.setCouponDate(1L);
		couponService.createCoupon(coupon2);
		
		Coupon coupon3 = Coupon.builder()
				.couponDiscount(30)
				.couponName("깜짝쿠폰")
				.userinfo(userInfo)
				.build();
		coupon3.setCouponDate(1L);
		couponService.createCoupon(coupon3);
	}
	
	// 쿠폰 삭제
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testDeleteByCouponNo() {
		
		couponService.deleteByCouponNo(41L);
	}
	
	// 쿠폰 찾기
	@Test
	@Transactional
	@Disabled
	void testFindByCouponNo() {
		System.out.println(couponService.findByCouponNo(40L));
	}
	
	// 쿠폰 리스트
	@Test
	@Transactional
	@Disabled
	void testFindAll() {
		System.out.println(couponService.findAll());
	}
	
	// 유저 쿠폰 리스트
	@Test
	@Transactional
	@Disabled
	void testFindAllByUserNo() {
		System.out.println(couponService.findAllByUserNo(7L));
	}
	
	// 만료된 쿠폰 찾기
	@Test
	@Transactional
	@Disabled
	void testAutoDeleteExpiredCoupons() {
		LocalDateTime currentDate = LocalDateTime.now();
		System.out.println(couponService.autoDeleteExpiredCoupons(currentDate));
	}
	
	// 유저에 따른 만료 쿠폰 삭제
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testDeleteExpireCouponByUserNo() {
		LocalDateTime currentDate = LocalDateTime.now();
		couponService.deleteExpireCouponByUserNo(currentDate, 7L);
	}

}
