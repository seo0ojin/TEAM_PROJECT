package com.jeju.dto;


import java.util.List;

import com.jeju.entity.Hotel;

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
public class HotelUpdateDto {

	private Long hotelNo;
	private Integer hotelPrice;
	private String hotelDesc;
	private String hotelImage;
	private Long hcNo;
	private List<String> imageName;
	
	public static HotelUpdateDto toDto(Hotel entity) {
		HotelUpdateDto update = HotelUpdateDto.builder()
				.hotelNo(entity.getHotelNo())
				.hotelPrice(entity.getHotelPrice())
				.hotelDesc(entity.getHotelDesc())
				.build();
		return update;
	}
	
	public static Hotel toEntity(HotelUpdateDto dto) {
		Hotel hotel = Hotel.builder()
				.hotelNo(dto.getHotelNo())
				.hotelPrice(dto.getHotelPrice())
				.hotelDesc(dto.getHotelDesc())
				.build();
		return hotel;
	}
}
