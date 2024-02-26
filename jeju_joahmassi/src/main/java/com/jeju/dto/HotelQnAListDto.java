package com.jeju.dto;



import java.time.LocalDate;

import com.jeju.entity.Hotel;
import com.jeju.entity.HotelQnA;
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
public class HotelQnAListDto {

	private Long qnaNo;
	
	private LocalDate qnaDate;
	private String qnaName;
	private String qnaPassword;
	private String qnaTitle;
	private String qnaContent;
	private Integer qnaGroupNo;
	private Integer qnaStep;
	private Integer qnaDepth;
	
	private Long hotelNo;
	
	public static HotelQnAListDto toDto(HotelQnA entity) {
		HotelQnAListDto hotelDto = HotelQnAListDto.builder()
				.qnaNo(entity.getQnaNo())
				.qnaDate(entity.getQnaDate())
				.qnaName(entity.getQnaName())
				.qnaTitle(entity.getQnaTitle())
				.qnaContent(entity.getQnaContent())
				.hotelNo(entity.getHotel().getHotelNo())
				.build();
		return hotelDto;
	}
	
	public static HotelQnA toEntity(HotelQnAListDto dto) {
		HotelQnA hotelQnA = HotelQnA.builder()
				.qnaNo(dto.getQnaNo())
				.qnaDate(dto.getQnaDate())
				.qnaName(dto.getQnaName())
				.qnaTitle(dto.getQnaTitle())
				.qnaContent(dto.getQnaContent())
				.hotel(Hotel.builder().hotelNo(dto.getHotelNo()).build())
				.build();
		return hotelQnA;
	}
}
