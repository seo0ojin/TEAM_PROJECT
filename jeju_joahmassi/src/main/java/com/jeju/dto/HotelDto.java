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
public class HotelDto {

	private Long hotelNo;
	
	private String hotelName;
	private String hotelLocal;
	private Integer hotelPrice;
	private Double hotelStar;
	private String hotelDesc;
	private Long hcNo;
	private List<String> imageName;
	private Integer pageSize;
	private Integer page;
	private Integer currentPage;
	private Integer reviewSize;
	private Integer hotelSize;
	private Integer order;
	private Long categoryNo;
	private List<HotelCategoryDto> categoryList;
	private List<HotelCategoryItemDto> hotelCategoryItems;
	private List<HotelReviewDto> hotelReviewDto;
	private List<HotelImageDto> hotelImageDto;
	private String searchKeyword;
	private Integer previousSize;
	private Integer nextSize;
	@Builder.Default
	private boolean wishBool = false;
	
	public static HotelDto toDto(Hotel entity) {
		
		HotelDto hotelInsertDto = HotelDto.builder()
				.hotelNo(entity.getHotelNo())
				.hotelName(entity.getHotelName())
				.hotelLocal(entity.getHotelLocal())
				.hotelPrice(entity.getHotelPrice())
				.hotelStar(entity.getHotelStar())
				.hotelDesc(entity.getHotelDesc())
				.build();
		return hotelInsertDto;
	}
	
	public static Hotel toEntity(HotelDto dto) {
		
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
