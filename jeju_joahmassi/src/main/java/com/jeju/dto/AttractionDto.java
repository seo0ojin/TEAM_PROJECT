package com.jeju.dto;

import java.util.LinkedHashSet;
import java.util.List;

import com.jeju.entity.Attraction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttractionDto {

	private Long attractionNo;
	private String attractionName;
	private String attractionAddress;
	private String attractionDesc;
	private Integer attractionStar;
	private Long acNo;
	private List<String> imageName;
	private Integer pageSize;
	private Integer page;
	private Integer currentPage;
	private Integer reviewSize;
	private Integer order;
	private Integer attractionSize;
	private Long categoryNo;
	private String searchKeyword;
	private List<AttractionReviewDto> attractionReviewDto;
	private List<AttractionCategoryDto> categoryList;
	private List<AttractionImageDto> attractionImageDto;
	private Integer previousSize;
	private Integer nextSize;
	@Builder.Default
	private boolean wishBool = false;
	
	public static AttractionDto toDto(Attraction entity) {
		
		AttractionDto attractionDto = AttractionDto.builder()
				.attractionNo(entity.getAttractionNo())
				.attractionName(entity.getAttractionName())
				.attractionAddress(entity.getAttractionAddress())
				.attractionDesc(entity.getAttractionDesc())
				.attractionStar(entity.getAttractionStar())
				.build();
		
		return attractionDto;
	}
	
	public static Attraction toEntity(AttractionDto dto) {
		
		Attraction attraction = Attraction.builder()
				.attractionNo(dto.getAttractionNo())
				.attractionName(dto.getAttractionName())
				.attractionAddress(dto.getAttractionAddress())
				.attractionDesc(dto.getAttractionDesc())
				.attractionStar(dto.getAttractionStar())
				.build();
		
		return attraction;
	}
	
}
