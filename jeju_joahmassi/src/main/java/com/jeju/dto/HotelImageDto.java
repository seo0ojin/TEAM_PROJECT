package com.jeju.dto;

import com.jeju.entity.Hotel;
import com.jeju.entity.HotelImage;

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
public class HotelImageDto {

	private Long imageNo;
	private String imageName;
	private Long hotelNo;

	public static HotelImageDto toDto(HotelImage entity) {
		HotelImageDto dto = HotelImageDto.builder()
				.imageNo(entity.getImageNo())
				.imageName(entity.getImageName())
				.hotelNo(entity.getHotel().getHotelNo())
				.build();
		return dto;
	}
	
	public static HotelImage toEntity(HotelImageDto dto) {
		HotelImage entity = HotelImage.builder()
				.imageNo(dto.getImageNo())
				.imageName(dto.getImageName())
				.hotel(Hotel.builder().hotelNo(dto.getHotelNo()).build())
				.build();
		return entity;
	}
}
