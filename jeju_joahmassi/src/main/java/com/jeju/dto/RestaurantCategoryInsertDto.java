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
public class RestaurantCategoryInsertDto {
	private Long rcNo;
	private String rcName;
	
	public static RestaurantCategory toEntity(RestaurantCategoryInsertDto dto) {
		RestaurantCategory entity = RestaurantCategory.builder()
										.rcName(dto.getRcName())
										.rcName(dto.getRcName())
										.build();
		return entity;
	}
	
	public static RestaurantCategoryInsertDto toDto(RestaurantCategory entity) {
		RestaurantCategoryInsertDto dto = RestaurantCategoryInsertDto.builder()
													.rcName(entity.getRcName())
													.rcNo(entity.getRcNo())
													.build();
		
		return dto;
	}
	
}
