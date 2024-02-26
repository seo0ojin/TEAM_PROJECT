package com.jeju.dto;

import java.time.LocalDate;

import com.jeju.entity.Attraction;
import com.jeju.entity.AttractionReview;
import com.jeju.entity.Userinfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttractionReviewDto {

	private Long arNo;
	private String arContent;
	private LocalDate arDate;
	private Double arStar;
	private Long attractionNo;
	private Long userNo;
	private String userName;
	private Double avgStars;
	private String randomImageURL;
	
	public static AttractionReviewDto toDto(AttractionReview entity) {
		
		AttractionReviewDto attractionReviewDto = AttractionReviewDto.builder()
				.arNo(entity.getArNo())
				.arContent(entity.getArContent())
				.arDate(entity.getArDate())
				.arStar(entity.getArStar())
				.attractionNo(entity.getAttraction().getAttractionNo())
				.userNo(entity.getUserinfo().getUserNo())
				.userName(entity.getUserinfo().getUserName())
				.build();
		
		return attractionReviewDto;
	}
	
	public static AttractionReview toEntity(AttractionReviewDto dto) {
		
		AttractionReview attractionReview = AttractionReview.builder()
				.arNo(dto.getArNo())
				.arContent(dto.getArContent())
				.arDate(dto.getArDate())
				.arStar(dto.getArStar())
				.attraction(Attraction.builder().attractionNo(dto.getAttractionNo()).build())
				.userinfo(Userinfo.builder().userNo(dto.getUserNo()).build())
				.build();
		
		return attractionReview;
	}
}
