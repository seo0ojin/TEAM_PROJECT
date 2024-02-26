package com.jeju.dto;

import com.jeju.entity.HotelAmenity;
import com.jeju.entity.RestaurantAmenity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RestaurantAmenityDto {
	
	private Long raNo;
	private Integer raCheck;
	
	public static RestaurantAmenityDto toDto(RestaurantAmenity entity) {
			
		RestaurantAmenityDto hotelAmenityDto = RestaurantAmenityDto.builder()
				.raNo(entity.getRaNo())
				.raCheck(entity.getRaCheck())
				.build();
		return hotelAmenityDto;
	}
	
	public static RestaurantAmenity toEntity(RestaurantAmenityDto dto) {
		
		RestaurantAmenity restaurantAmenity = RestaurantAmenity.builder()
				.raNo(dto.getRaNo())
				.raCheck(dto.getRaCheck())
				.build();
		return restaurantAmenity;
	}
	
}
