package com.jeju.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeju.dao.CouponDao;
import com.jeju.entity.Coupon;

@Service
@Transactional
public class CouponServiceImpl implements CouponService {
	
	@Autowired
	CouponDao couponDao;

	// 쿠폰 생성
	@Override
	public Coupon createCoupon(Coupon coupon) {
		
		return couponDao.createCoupon(coupon);
	}
	
	// 쿠폰 삭제
	@Override
	public void deleteByCouponNo(Long couponNo) {
		
		couponDao.deleteByCouponNo(couponNo);
	}
	
	// 쿠폰 찾기
	@Override
	public Coupon findByCouponNo(Long couponNo) {
		
		return couponDao.findByCouponNo(couponNo);
	}
	
	// 쿠폰 리스트
	@Override
	public List<Coupon> findAll() {
		
		return couponDao.findAll();
	}
	
	// 유저 쿠폰 리스트
	@Override
	public List<Coupon> findAllByUserNo(Long userNo) {
		
		return couponDao.findAllByUserNo(userNo);
	}
	
	// 만료된 쿠폰 찾기
	@Override
	public List<Coupon> autoDeleteExpiredCoupons(LocalDateTime expireDate) {
		
		return couponDao.autoDeleteExpiredCoupons(expireDate);
	}
	
	// 유저에 따른 만료 쿠폰 삭제
	@Override
	public void deleteExpireCouponByUserNo(LocalDateTime expireDate, Long userNo) {
		
		couponDao.deleteExpireCouponByUserNo(expireDate, userNo);
	}

}
