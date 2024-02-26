package com.jeju.dto;

import java.util.ArrayList;
import java.util.List;

import com.jeju.entity.Attraction;
import com.jeju.entity.AttractionCategoryItem;
import com.jeju.entity.AttractionImage;
import com.jeju.entity.AttractionReview;
import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantCategoryItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RestaurantInsertDto {
	
	private Long restaurantNo;
	private String restaurantName;
	private String restaurantAddress;
	private Double restaurantStar;
	private String restaurantTel;
	private String restaurantDesc;
	private Long rcNo;
	private String rcName;
	private List<String> imageName;
	private List<RestaurantReviewInsertDto> restaurantReviews;
	private List<RestaurantImageDto> restaurantImages;
	private List<RestaurantCategoryItemDto> restaurantCategoryItems;
	@Builder.Default
	private boolean wishBool = false;
	
	public static Restaurant toEntity(RestaurantInsertDto dto) {
		Restaurant entity = Restaurant.builder()
										.restaurantNo(dto.getRestaurantNo())
										.restaurantAddress(dto.getRestaurantAddress())
										.restaurantName(dto.getRestaurantName())
										.restaurantStar(dto.getRestaurantStar())
										.restaurantTel(dto.getRestaurantTel())
										.restaurantDesc(dto.getRestaurantDesc())
										.build();
		return entity;
	}
	
	public static RestaurantInsertDto toDto(Restaurant entity) {
		RestaurantInsertDto dto = RestaurantInsertDto.builder()
													.restaurantNo(entity.getRestaurantNo())
													.restaurantAddress(entity.getRestaurantAddress())
													.restaurantName(entity.getRestaurantName())
													.restaurantStar(entity.getRestaurantStar())
													.restaurantTel(entity.getRestaurantTel())
													.restaurantDesc(entity.getRestaurantDesc())
													.build();
		
		return dto;
	}
	
}
