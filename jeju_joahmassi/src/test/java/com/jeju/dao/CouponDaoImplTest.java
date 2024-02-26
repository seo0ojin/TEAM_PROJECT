package com.jeju.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.entity.Coupon;
import com.jeju.entity.Userinfo;

class CouponDaoImplTest extends JejuJoahmassiApplicationTests {
	
	@Autowired
	CouponDao couponDao;
	@Autowired
	UserinfoDao userInfoDao;

	// 쿠폰 생성
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testCreateCoupon() {
		Userinfo userInfo = userInfoDao.findByUserNo(1L);
		
		Coupon coupon = Coupon.builder()
								.couponDiscount(30)
								.couponName("가입쿠폰")
								.userinfo(userInfo)
								.build();
		coupon.setCouponDate(10000L);
		couponDao.createCoupon(coupon);
		
		Coupon coupon2 = Coupon.builder()
								.couponDiscount(30)
								.couponName("생일쿠폰")
								.userinfo(userInfo)
								.build();
		coupon2.setCouponDate(10000L);
		couponDao.createCoupon(coupon2);
		
		Coupon coupon3 = Coupon.builder()
				.couponDiscount(30)
				.couponName("깜짝쿠폰")
				.userinfo(userInfo)
				.build();
		coupon3.setCouponDate(10000L);
		couponDao.createCoupon(coupon3);
	}

	// 쿠폰 삭제
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testDeleteByCouponNo() {
		couponDao.deleteByCouponNo(3L);
	}

	// 쿠폰 찾기
	@Test
	@Transactional
	@Disabled
	void testFindByCouponNo() {
		System.out.println(couponDao.findByCouponNo(2L));
	}

	// 쿠폰 리스트
	@Test
	@Transactional
	@Disabled
	void testFindAll() {
		System.out.println(couponDao.findAll());
	}
	
	// 유저 쿠폰 리스트
	@Test
	@Transactional
	@Disabled
	void testFindAllByUserNo() {
		System.out.println(couponDao.findAllByUserNo(2L));
	}

	// 만료된 쿠폰 찾기
	@Test
	@Transactional
	@Disabled
	void testAutoDeleteExpiredCoupons() {
		LocalDateTime currentDate = LocalDateTime.now();
		System.out.println(couponDao.autoDeleteExpiredCoupons(currentDate));
	}

	// 유저에 따른 만료 쿠폰 삭제
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testDeleteExpireCouponByUserNo() {
		LocalDateTime currentDate = LocalDateTime.now();
		couponDao.deleteExpireCouponByUserNo(currentDate, 1L);
	}

}
