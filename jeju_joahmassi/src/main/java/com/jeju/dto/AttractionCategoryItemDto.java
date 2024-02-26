package com.jeju.dto;

import com.jeju.entity.Attraction;
import com.jeju.entity.AttractionCategory;
import com.jeju.entity.AttractionCategoryItem;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AttractionCategoryItemDto {

	private Long aciNo;
	private Long attractionNo;
	private Long acNo;
	
	public static AttractionCategoryItemDto toDto(AttractionCategoryItem entity) {
		
		AttractionCategoryItemDto attractionCategoryItemDto = AttractionCategoryItemDto.builder()
				.aciNo(entity.getAciNo())
				.attractionNo(entity.getAttraction().getAttractionNo())
				.acNo(entity.getAttractionCategory().getAcNo())
				.build();
		
		return attractionCategoryItemDto;
	}
	
	public static AttractionCategoryItem toEntity(AttractionCategoryItemDto dto) {
		AttractionCategoryItem attractionCategoryItem = AttractionCategoryItem.builder()
				.aciNo(dto.getAciNo())
				.attraction(Attraction.builder().attractionNo(dto.getAttractionNo()).build())
				.attractionCategory(AttractionCategory.builder().acNo(dto.getAcNo()).build())
				.build();
		
		return attractionCategoryItem;
	}
	
}
