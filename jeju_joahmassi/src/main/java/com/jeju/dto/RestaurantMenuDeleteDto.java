package com.jeju.dto;

import java.time.LocalDateTime;

import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantMenu;
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
public class RestaurantMenuDeleteDto {
	
	private Long rmNo;
	private String rmName;
	private Integer rmPrice;
	private String rmImage;
	private Long restaurantNo;
	
	public static RestaurantMenu toEntity(RestaurantMenuDeleteDto dto) {
		RestaurantMenu entity = RestaurantMenu.builder()
										.restaurant(Restaurant.builder().restaurantNo(dto.getRestaurantNo()).build())
										.rmImage(dto.getRmImage())
										.rmName(dto.getRmName())
										.rmNo(dto.getRmNo())
										.rmPrice(dto.getRmPrice())
										.build();
		return entity;
	}
	
	public static RestaurantMenuDeleteDto toDto(RestaurantMenu entity) {
		RestaurantMenuDeleteDto dto = RestaurantMenuDeleteDto.builder()
													.restaurantNo(entity.getRestaurant().getRestaurantNo())
													.rmImage(entity.getRmImage())
													.rmName(entity.getRmName())
													.rmNo(entity.getRmNo())
													.rmPrice(entity.getRmPrice())
													.build();
		return dto;
	}
	
}
