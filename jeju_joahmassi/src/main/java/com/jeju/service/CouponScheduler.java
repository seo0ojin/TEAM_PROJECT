package com.jeju.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeju.entity.Coupon;
import com.jeju.entity.Userinfo;

@Component
@Service
public class CouponScheduler {

	@Autowired
	CouponService couponService;
	@Autowired
	UserinfoService userInfoService;

	@Scheduled(cron = "0 0 0 * * ?")
	@Transactional
	public void createBirthdayCoupon() {
		List<Userinfo> userList = userInfoService.findAll();
		Coupon birthCoupon = Coupon.builder().couponDiscount(30).couponName("생일쿠폰").build();
		birthCoupon.setCouponDate(30L);

		for (Userinfo userinfo : userList) {
			if (userinfo.getUserCouponYear() == null || LocalDateTime.now().getYear() != userinfo.getUserCouponYear()) {
				String userResident = userinfo.getUserResident();
				if (userResident != null && userResident.length() >= 6) {
					String birthdateStr = userResident.substring(0, userResident.indexOf("-"));
					LocalDate birthdate = LocalDate.parse(birthdateStr, DateTimeFormatter.ofPattern("yyMMdd"));
					System.out.println(birthdate);

					if (LocalDateTime.now().getMonthValue() == birthdate.getMonthValue()
							&& LocalDateTime.now().getDayOfMonth() == birthdate.getDayOfMonth()) {
						birthCoupon.setUserinfo(userinfo);
						couponService.createCoupon(birthCoupon);
						userinfo.setUserCouponYear(LocalDateTime.now().getYear());
						userInfoService.updateUser(userinfo);
					}
				}
			}
		}
	}

	@Scheduled(cron = "0 0 0 * * ?")
	@Transactional
	public void deleteCoupon() {
		List<Coupon> couponList = couponService.findAll();

		for (Coupon coupon : couponList) {
			if (LocalDateTime.now().getMonthValue() == coupon.getCouponExpireDate().getMonthValue()
					&& LocalDateTime.now().getDayOfMonth() == coupon.getCouponExpireDate().getDayOfMonth()) {
				couponService.deleteByCouponNo(coupon.getCouponNo());
			}
		}
	}
}
