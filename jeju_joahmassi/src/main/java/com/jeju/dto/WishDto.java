package com.jeju.dto;

import com.jeju.entity.Attraction;
import com.jeju.entity.Hotel;
import com.jeju.entity.Restaurant;
import com.jeju.entity.Userinfo;
import com.jeju.entity.Wish;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishDto {

	private Long wishNo;
	private Long hotelNo;
	private Long restaurantNo;
	private Long attractionNo;
	private Long userNo;
	private Integer status;
	
	public static Wish toEntity(WishDto dto) {
		
		Wish wish = Wish.builder()
				.hotel(Hotel.builder().hotelNo(dto.getHotelNo()).build())
				.restaurant(Restaurant.builder().restaurantNo(dto.getRestaurantNo()).build())
				.attraction(Attraction.builder().attractionNo(dto.getAttractionNo()).build())
				.userinfo(Userinfo.builder().userNo(dto.getUserNo()).build())
				.build();
		
		return wish;
	}
	
	public static WishDto toDto(Wish wish) {
		
		return WishDto.builder()
				.hotelNo(wish.getHotel().getHotelNo())
				.restaurantNo(wish.getRestaurant().getRestaurantNo())
				.attractionNo(wish.getAttraction().getAttractionNo())
				.userNo(wish.getUserinfo().getUserNo())
				.build();
	}
}
