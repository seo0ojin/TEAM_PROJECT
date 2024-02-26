package com.jeju.dto;

import java.util.List;

import com.jeju.entity.AttractionCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttractionCategoryDto {

	private Long acNo;
	private String acName;
	private int count;
	
	public static AttractionCategoryDto toDto(AttractionCategory entity) {
		
		AttractionCategoryDto attractionCategoryDto = AttractionCategoryDto.builder()
				.acNo(entity.getAcNo())
				.acName(entity.getAcName())
				.build();
		
		return attractionCategoryDto;
	}
	
	public static AttractionCategory toEntity(AttractionCategoryDto dto) {
		
		AttractionCategory attractionCategory = AttractionCategory.builder()
				.acNo(dto.getAcNo())
				.acName(dto.getAcName())
				.build();
		
		return attractionCategory;
	}
}
