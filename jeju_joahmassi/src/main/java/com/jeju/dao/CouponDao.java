package com.jeju.dao;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.jeju.entity.Coupon;

public interface CouponDao {
	
	// 쿠폰 생성
	public Coupon createCoupon(Coupon coupon);
	
	// 쿠폰 삭제
	public void deleteByCouponNo(Long couponNo);
	
	// 쿠폰 찾기
	public Coupon findByCouponNo(Long couponNo);
	
	// 쿠폰 리스트
	public List<Coupon> findAll();
		
	// 유저 쿠폰 리스트
	public List<Coupon> findAllByUserNo(Long userNo);
	
	// 만료된 쿠폰 찾기
	public List<Coupon> autoDeleteExpiredCoupons(LocalDateTime expireDate);
	
	// 유저에 따른 만료 쿠폰 삭제
	public void deleteExpireCouponByUserNo(LocalDateTime expireDate, Long userNo);
}
