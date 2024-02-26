package com.jeju.dto;

import java.time.LocalDate;

import com.jeju.entity.HotelQnA;

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
public class HotelQnAPageDto {
	private Long qnaNo;
	private LocalDate qnaDate;
	private String qnaName;
	private String qnaTitle;
	private String qnaContent;
	private Integer qnaSecretCheck;
	private Integer qnaStatus;
	private String qnaAnswer;
	private Long hotelNo;
	private Long userNo;
	
	private Integer totalPage;
	private Integer page;
	private Integer pageSize;
	private Integer nextSize;
	private Integer preSize;
	
	public static HotelQnAPageDto toDto(HotelQnA entity) {
		HotelQnAPageDto hotelDto = HotelQnAPageDto.builder()
				.qnaNo(entity.getQnaNo())
				.qnaDate(entity.getQnaDate())
				.qnaName(entity.getQnaName())
				.qnaTitle(entity.getQnaTitle())
				.qnaContent(entity.getQnaContent())
				.qnaSecretCheck(entity.getQnaSecretCheck())
				.qnaStatus(entity.getQnaStatus())
				.hotelNo(entity.getHotel().getHotelNo())
				.userNo(entity.getUserinfo().getUserNo())
				.build();
		return hotelDto;
	}
}
