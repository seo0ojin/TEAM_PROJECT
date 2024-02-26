package com.jeju.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.jeju.entity.Restaurant;
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
public class RestaurantReviewInsertDto {
	
	private Long rrNo;
	private String rrContent;
	private LocalDate rrDate;
	private Double rrStar;
	private Long restaurantNo;
	private Long userNo;
	
	public static RestaurantReview toEntity(RestaurantReviewInsertDto dto) {
		RestaurantReview entity = RestaurantReview.builder()
										.rrNo(dto.getRrNo())
										.rrContent(dto.getRrContent())
										.rrDate(dto.getRrDate())
										.rrStar(dto.getRrStar())
										.restaurant(Restaurant.builder().restaurantNo(dto.getRestaurantNo()).build())
										.userinfo(Userinfo.builder().userNo(dto.getUserNo()).build())
										.build();
		return entity;
	}
	
	public static RestaurantReviewInsertDto toDto(RestaurantReview entity) {
		RestaurantReviewInsertDto dto = RestaurantReviewInsertDto.builder()
													.rrNo(entity.getRrNo())
													.restaurantNo(entity.getRestaurant().getRestaurantNo())
													.rrContent(entity.getRrContent())
													.rrDate(entity.getRrDate())
													.rrStar(entity.getRrStar())
													.userNo(entity.getUserinfo().getUserNo())
													.build();
		return dto;
	}
	
}
