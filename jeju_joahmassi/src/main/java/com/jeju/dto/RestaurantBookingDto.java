package com.jeju.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RestaurantBookingDto {
	
	String restaurantNo;
	String restaurantBooking1Name;
	String restaurantBooking1Phone;
	String restaurantBooking1Date;
	String restaurantBooking1Time;
	String restaurantBooking1Personnel;
	Integer status;
}
