package com.jeju.dto;

import java.time.LocalDate;

import com.jeju.entity.Hotel;
import com.jeju.entity.HotelReview;
import com.jeju.entity.Userinfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class HotelReviewDto {

	private Long hrNo;
	
	private String hrContent;
	private LocalDate hrDate;
	private Double hrStar;
	
	private Long hotelNo;
	private Long userNo;
	private String userName;
	
	private String randomImageURL;
	
	public static HotelReviewDto toDto(HotelReview entity) {
		HotelReviewDto reviewDto = HotelReviewDto.builder()
				.hrNo(entity.getHrNo())
				.hrContent(entity.getHrContent())
				.hrDate(entity.getHrDate())
				.hrStar(entity.getHrStar())
				.hotelNo(entity.getHotel().getHotelNo())
				.userNo(entity.getUserinfo().getUserNo())
				.userName(entity.getUserinfo().getUserName())
				.build();
		return reviewDto;
	}
	
	public static HotelReview toEntity(HotelReviewDto dto) {
		HotelReview hotelReview = HotelReview.builder()
				.hrNo(dto.getHrNo())
				.hrContent(dto.getHrContent())
				.hrDate(dto.getHrDate())
				.hrStar(dto.getHrStar())
				.hotel(Hotel.builder().hotelNo(dto.getHotelNo()).build())
				.userinfo(Userinfo.builder().userNo(dto.getUserNo()).build())
				.build();
		return hotelReview;
	}
}
