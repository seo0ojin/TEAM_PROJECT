package com.jeju.dto;

import java.util.ArrayList;
import java.util.List;

import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantCategory;
import com.jeju.entity.RestaurantCategoryItem;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RestaurantCategoryItemDto {

	private Long rciNo;
	private Long restaurantNo;
	private Long rcNo;
	private String rcName;
	
	public static RestaurantCategoryItem toEntity(RestaurantCategoryItemDto dto) {
		RestaurantCategoryItem categoryItem = RestaurantCategoryItem.builder()
																	.rciNo(dto.getRciNo())
																	.restaurant(Restaurant.builder().restaurantNo(dto.getRestaurantNo()).build())
																	.restaurantCategory(RestaurantCategory.builder().rcNo(dto.getRcNo()).build())
																	.build();
		
		return categoryItem;
	}
	
	public static RestaurantCategoryItemDto toDto(RestaurantCategoryItem item) {
		RestaurantCategoryItemDto restaurantCategoryItemDto = RestaurantCategoryItemDto.builder()
																						.rciNo(item.getRciNo())
																						.rcNo(item.getRestaurantCategory().getRcNo())
																						.rcName(item.getRestaurantCategory().getRcName())
																						.restaurantNo(item.getRestaurant().getRestaurantNo())
																						.build();
		return restaurantCategoryItemDto;
	}
}
