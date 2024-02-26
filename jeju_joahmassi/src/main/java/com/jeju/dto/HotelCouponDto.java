package com.jeju.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class HotelCouponDto {

	private String couponName;
	private Integer couponStatus;
	private Integer couponDiscount;
	private Integer totalPrice;
}
