package com.jeju.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Coupon {
	
	@Id
	@SequenceGenerator(name = "COUPON_NO_SEQ",sequenceName = "COUPON_NO_SEQ",allocationSize = 1,initialValue = 1)
	@GeneratedValue(generator = "COUPON_NO_SEQ",strategy = GenerationType.SEQUENCE)
	private Long couponNo;
	private String couponName;
	private Integer couponDiscount;
	private LocalDateTime couponPayday;
	private LocalDateTime couponExpireDate;
	
	@Builder.Default
	@JoinColumn(name = "user_no")
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Userinfo userinfo = new Userinfo();
	
	public void setCouponDate(Long days) {
		this.couponPayday = LocalDateTime.now();
		this.couponExpireDate = couponPayday.plusDays(days);
		
	}
	
}
