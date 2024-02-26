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
public class HotelCategoryUpdateDto {

	private String hcName;
	
	public static HotelCategoryUpdateDto toDto(HotelCategory entity) {
		HotelCategoryUpdateDto update = HotelCategoryUpdateDto.builder()
				.hcName(entity.getHcName())
				.build();
		return update;
	}
	
	public static HotelCategory toEntity(HotelCategoryUpdateDto dto) {
		HotelCategory cate = HotelCategory.builder()
				.hcName(dto.getHcName())
				.build();
		return cate;
	}
}
