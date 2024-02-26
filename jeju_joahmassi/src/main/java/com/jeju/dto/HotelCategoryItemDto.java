package com.jeju.dto;


import com.jeju.entity.Hotel;
import com.jeju.entity.HotelCategory;
import com.jeju.entity.HotelCategoryItem;

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
public class HotelCategoryItemDto {

	private Long hciNo;
	
	private Long hotelNo;
	private Long hcNo;
	private String hcName;
	
	public static HotelCategoryItemDto toDto(HotelCategoryItem entity) {
		HotelCategoryItemDto hotelCategoryItemDto = HotelCategoryItemDto.builder()
				.hciNo(entity.getHciNo())
				.hotelNo(entity.getHotel().getHotelNo())
				.hcNo(entity.getHotelCategory().getHcNo())
				.hcName(entity.getHotelCategory().getHcName())
				.build();
		return hotelCategoryItemDto;
	}
	
	public static HotelCategoryItem toEntity(HotelCategoryItemDto dto) {
		HotelCategoryItem hotelCategoryItem = HotelCategoryItem.builder()
				.hciNo(dto.getHciNo())
				.hotel(Hotel.builder().hotelNo(dto.getHotelNo()).build())
				.hotelCategory(HotelCategory.builder().hcNo(dto.getHcNo()).hcName(dto.getHcName()).build())
				.build();
		return hotelCategoryItem;
	}
}
