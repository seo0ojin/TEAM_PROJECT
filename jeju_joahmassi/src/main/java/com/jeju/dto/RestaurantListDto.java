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
public class RestaurantListDto {
	
	private Long restaurantNo;
	private String restaurantName;
	private String restaurantAddress;
	private Double restaurantStar;
	private String restaurantTel;
	private String restaurantDesc;
	private Long rcNo;
	private List<String> imageName;
	private Integer pageSize;
	private Integer page;
	private Integer currentPage;
	private Integer reviewSize;
	private Integer order;
	private Long categoryNo;
	private Integer restaurantSize;
	private List<RestaurantCategoryInsertDto> categoryList;
	private List<RestaurantImageDto> restaurantImageList;
	private List<RestaurantCategoryItemDto> restaurantCategoryItems;
	private String searchKeyword;
	private Integer previousSize;
	private Integer nextSize;
	@Builder.Default
	private boolean wishBool = false;
	
	public static Restaurant toEntity(RestaurantListDto dto) {
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
	
	public static RestaurantListDto toDto(Restaurant entity) {
		RestaurantListDto dto = RestaurantListDto.builder()
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
