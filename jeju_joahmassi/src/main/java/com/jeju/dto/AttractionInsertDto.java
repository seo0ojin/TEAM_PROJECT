package com.jeju.dto;

import java.util.List;

import com.jeju.entity.Attraction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AttractionInsertDto {

	private Long attractionNo;
	private String attractionName;
	private String attractionAddress;
	private Integer attractionStar;
	private String attractionDesc;
	private Long acNo;
	private List<String> imageName;
	
	public static Attraction toEntity(AttractionInsertDto dto) {
		Attraction entity = Attraction.builder()
				.attractionNo(dto.getAttractionNo())
				.attractionName(dto.getAttractionName())
				.attractionAddress(dto.getAttractionAddress())
				.attractionStar(dto.getAttractionStar())
				.attractionDesc(dto.getAttractionDesc())
				.build();
		
		return entity;
	}
	
	public static AttractionInsertDto toDto(Attraction entity) {
		AttractionInsertDto dto = AttractionInsertDto.builder()
				.attractionNo(entity.getAttractionNo())
				.attractionName(entity.getAttractionName())
				.attractionAddress(entity.getAttractionAddress())
				.attractionStar(entity.getAttractionStar())
				.attractionDesc(entity.getAttractionDesc())
				.build();
		
		return dto;
	}
}
