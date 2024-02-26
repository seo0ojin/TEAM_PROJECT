package com.jeju.dto;

import java.util.List;

import com.jeju.entity.Hotel;
import com.jeju.entity.HotelAmenity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class HotelAmenityDto {
	private Long haNo;
	private Integer haCheck;
	
	public static HotelAmenityDto toDto(HotelAmenity entity) {
			
		HotelAmenityDto hotelAmenityDto = HotelAmenityDto.builder()
				.haNo(entity.getHaNo())
				.haCheck(entity.getHaCheck())
				.build();
		return hotelAmenityDto;
	}
	
	public static HotelAmenity toEntity(HotelAmenityDto dto) {
		
		HotelAmenity hotelAmenity = HotelAmenity.builder()
				.haNo(dto.getHaNo())
				.haCheck(dto.getHaCheck())
				.build();
		return hotelAmenity;
	}
}
