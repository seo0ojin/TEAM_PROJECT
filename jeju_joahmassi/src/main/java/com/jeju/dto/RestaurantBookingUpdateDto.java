package com.jeju.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantBooking;
import com.jeju.entity.RestaurantReview;
import com.jeju.entity.Userinfo;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RestaurantBookingUpdateDto {
	private Long rbNo;
	private String rbName;
	private String rbPhone;
	private LocalDate rbDate;
	private String rbTime;
	private Integer rbPersons;
	private Long restaurantNo;
	private Long userNo;
	
	public static RestaurantBooking toEntity(RestaurantBookingUpdateDto dto) {
		RestaurantBooking entity = RestaurantBooking.builder()
										.rbDate(dto.getRbDate())
										.rbName(dto.getRbName())
										.rbNo(dto.getRbNo())
										.rbPersons(dto.getRbPersons())
										.rbPhone(dto.getRbPhone())
										.rbTime(dto.getRbTime())
										.restaurant(Restaurant.builder().restaurantNo(dto.getRestaurantNo()).build())
										.userinfo(Userinfo.builder().userNo(dto.getUserNo()).build())
										.build();
		return entity;
	}
	
	public static RestaurantBookingUpdateDto toDto(RestaurantBooking entity) {
		RestaurantBookingUpdateDto dto = RestaurantBookingUpdateDto.builder()
													.rbDate(entity.getRbDate())
													.rbName(entity.getRbName())
													.rbNo(entity.getRbNo())
													.rbPersons(entity.getRbPersons())
													.rbPhone(entity.getRbPhone())
													.rbTime(entity.getRbTime())
													.restaurantNo(entity.getRestaurant().getRestaurantNo())
													.userNo(entity.getUserinfo().getUserNo())
													.build();
		return dto;
	}
	
}
