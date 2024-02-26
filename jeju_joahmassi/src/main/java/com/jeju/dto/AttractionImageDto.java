package com.jeju.dto;

import com.jeju.entity.Attraction;
import com.jeju.entity.AttractionImage;

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
public class AttractionImageDto {

	private Long imageNo;
	private String imageName;
	private Long attractionNo;
	
	public static AttractionImageDto toDto(AttractionImage entity) {
		
		AttractionImageDto attractionImageDto = AttractionImageDto.builder()
				.imageNo(entity.getImageNo())
				.imageName(entity.getImageName())
				.attractionNo(entity.getAttraction().getAttractionNo())
				.build();
		
		return attractionImageDto;
	}
	
	public static AttractionImage toEntity(AttractionImageDto dto) {
		AttractionImage attractionImage = AttractionImage.builder()
				.imageNo(dto.getImageNo())
				.imageName(dto.getImageName())
				.attraction(Attraction.builder().attractionNo(dto.getAttractionNo()).build())
				.build();
		
		return attractionImage;
	}
}
