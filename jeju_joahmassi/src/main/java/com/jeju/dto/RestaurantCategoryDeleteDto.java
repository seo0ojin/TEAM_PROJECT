package com.jeju.dto;

import java.util.List;

import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RestaurantCategoryDeleteDto {
	private Long rcNo;
	private String rcName;
	
	public static RestaurantCategory toEntity(RestaurantCategoryDeleteDto dto) {
		RestaurantCategory entity = RestaurantCategory.builder()
										.rcNo(dto.getRcNo())
										.rcName(dto.getRcName())
										.build();
		return entity;
	}
	
	public static RestaurantCategoryDeleteDto toDto(RestaurantCategoryDeleteDto entity) {
		RestaurantCategoryDeleteDto dto = RestaurantCategoryDeleteDto.builder()
													.rcName(entity.getRcName())
													.rcNo(entity.getRcNo())
													.build();
		
		return dto;
	}
	
}
