package com.jeju.dto;

import java.time.LocalDate;

import com.jeju.entity.RestaurantReview;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RestaurantReviewDto {
	
	private Long rrNo;
	private String rrContent;
	private LocalDate rrDate;
	private Double rrStar;
	private Long restaurantNo;
	private Long userNo;
	private String userName;
	private String randomImageURL;
	
	public static RestaurantReviewDto toDto(RestaurantReview entity) {
		RestaurantReviewDto dto = RestaurantReviewDto.builder()
													.rrNo(entity.getRrNo())
													.restaurantNo(entity.getRestaurant().getRestaurantNo())
													.rrContent(entity.getRrContent())
													.rrDate(entity.getRrDate())
													.rrStar(entity.getRrStar())
													.userName(entity.getUserinfo().getUserName())
													.userNo(entity.getUserinfo().getUserNo())
													.build();
		return dto;
	}
	
}
