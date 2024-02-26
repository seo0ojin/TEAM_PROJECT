package com.jeju.dto;

import com.jeju.entity.HotelCategory;

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
public class HotelCategoryDto {

	private Long hcNo;
	private String hcName;
	
	public static HotelCategory toEntity(HotelCategoryDto dto) {
		HotelCategory entity = HotelCategory.builder()
				.hcNo(dto.getHcNo())
				.hcName(dto.getHcName())
				.build();
		return entity;
	}
	
	public static HotelCategoryDto toDto(HotelCategory entity) {
		HotelCategoryDto dto = HotelCategoryDto.builder()
				.hcNo(entity.getHcNo())
				.hcName(entity.getHcName())
				.build();
		return dto;
	}
}
