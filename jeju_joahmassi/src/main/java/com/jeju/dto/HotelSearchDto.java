package com.jeju.dto;

import java.util.ArrayList;
import java.util.List;

import com.jeju.entity.Hotel;
import com.jeju.entity.HotelCategoryItem;
import com.jeju.entity.HotelImage;

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
public class HotelSearchDto {

	private Long hotelNo;
	
	private String hotelName;
	private String hotelLocal;
	private Integer hotelPrice;
	private Double hotelStar;
	private String hotelDesc;
	private Long hcNo;
	private List<String> imageName;
	
	public static HotelSearchDto toDto(Hotel entity) {
		
		HotelSearchDto hotelInsertDto = HotelSearchDto.builder()
				.hotelNo(entity.getHotelNo())
				.hotelName(entity.getHotelName())
				.hotelLocal(entity.getHotelLocal())
				.hotelPrice(entity.getHotelPrice())
				.hotelStar(entity.getHotelStar())
				.hotelDesc(entity.getHotelDesc())
				.build();
		return hotelInsertDto;
	}
	
	public static Hotel toEntity(HotelSearchDto dto) {
		
		Hotel hotel = Hotel.builder()
				.hotelNo(dto.getHotelNo())
				.hotelName(dto.getHotelName())
				.hotelLocal(dto.getHotelLocal())
				.hotelPrice(dto.getHotelPrice())
				.hotelStar(dto.getHotelStar())
				.hotelDesc(dto.getHotelDesc())
				.build();
		return hotel;
	}
	
}
