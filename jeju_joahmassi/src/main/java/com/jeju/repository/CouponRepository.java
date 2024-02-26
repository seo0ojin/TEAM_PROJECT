package com.jeju.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeju.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

	// 유저 쿠폰 리스트
	List<Coupon> findByUserinfo_UserNo(Long userNo);
	
	// 만료된 쿠폰 찾기
	List<Coupon> findByCouponExpireDateBefore(LocalDateTime expireDate);
	
	// 유저에 따른 만료 쿠폰 삭제
	void deleteByCouponExpireDateBeforeAndUserinfo_UserNo(LocalDateTime expireDate, Long userNo);
}
