package com.jeju.dto;

import java.util.List;

import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantImage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RestaurantImageDto {
	private Long imageNo;
	private String imageName;
	
	public static RestaurantImageDto toDto(RestaurantImage entity) {
		RestaurantImageDto dto = RestaurantImageDto.builder()
													.imageNo(entity.getImageNo())
													.imageName(entity.getImageName())
													.build();
		
		return dto;
	}
	
}
