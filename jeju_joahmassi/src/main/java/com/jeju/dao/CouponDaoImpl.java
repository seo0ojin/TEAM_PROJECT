package com.jeju.dao;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeju.entity.Coupon;
import com.jeju.repository.CouponRepository;

@Repository
public class CouponDaoImpl implements CouponDao {

	@Autowired
	private CouponRepository couponRepository;
	
	// 쿠폰 생성
	@Override
	public Coupon createCoupon(Coupon coupon) {
		
		return couponRepository.save(coupon);
	}

	// 쿠폰 삭제
	@Override
	public void deleteByCouponNo(Long couponNo) {
		
		couponRepository.deleteById(couponNo);
	}

	// 쿠폰 찾기
	@Override
	public Coupon findByCouponNo(Long couponNo) {
		
		return couponRepository.findById(couponNo).get();
	}

	// 쿠폰 리스트
	@Override
	public List<Coupon> findAll() {
		
		return couponRepository.findAll();
	}
	
	// 유저 쿠폰 리스트
	@Override
	public List<Coupon> findAllByUserNo(Long userNo) {
		
		return couponRepository.findByUserinfo_UserNo(userNo);
	}

	// 만료된 쿠폰 찾기
	@Override
	public List<Coupon> autoDeleteExpiredCoupons(LocalDateTime expireDate) {
		
		return couponRepository.findByCouponExpireDateBefore(expireDate);
	}

	// 유저에 따른 만료 쿠폰 삭제
	@Override
	public void deleteExpireCouponByUserNo(LocalDateTime expireDate, Long userNo) {
		
		couponRepository.deleteByCouponExpireDateBeforeAndUserinfo_UserNo(expireDate, userNo);
	}

}
