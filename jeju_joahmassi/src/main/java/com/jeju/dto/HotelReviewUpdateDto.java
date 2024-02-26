package com.jeju.dto;

import com.jeju.entity.HotelReview;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HotelReviewUpdateDto {

	private String hrContent;
	private Double hrStar;
	private Long hrNo;
	
	public static HotelReviewUpdateDto toDto(HotelReview entity) {
		HotelReviewUpdateDto update = HotelReviewUpdateDto.builder()
				.hrContent(entity.getHrContent())
				.hrStar(entity.getHrStar())
				.hrNo(entity.getHrNo())
				.build();
		return update;
	}
	
	public static HotelReview toEntity(HotelReviewUpdateDto dto) {
		HotelReview review = HotelReview.builder()
				.hrContent(dto.getHrContent())
				.hrStar(dto.getHrStar())
				.hrNo(dto.getHrNo())
				.build();
		return review;
	}
}
