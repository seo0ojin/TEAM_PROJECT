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
public class HotelQnADto {

	private Long qnaNo;
	
	private LocalDate qnaDate;
	private String qnaName;
	private String qnaPassword;
	private String qnaTitle;
	private String qnaContent;
	private Integer qnaGroupNo;
	private Integer qnaStep;
	private Integer qnaDepth;
	private Integer qnaSecretCheck;
	private Integer qnaStatus;
	private String qnaAnswer;
	
	private Long hotelNo;
	private Long userNo;
	
	public static HotelQnADto toDto(HotelQnA entity) {
		HotelQnADto hotelDto = HotelQnADto.builder()
				.qnaNo(entity.getQnaNo())
				.qnaDate(entity.getQnaDate())
				.qnaName(entity.getQnaName())
				.qnaTitle(entity.getQnaTitle())
				.qnaContent(entity.getQnaContent())
				.hotelNo(entity.getHotel().getHotelNo())
				.userNo(entity.getUserinfo().getUserNo())
				.build();
		return hotelDto;
	}
	
	public static HotelQnA toEntity(HotelQnADto dto) {
		HotelQnA hotelQnA = HotelQnA.builder()
				.qnaNo(dto.getQnaNo())
				.qnaDate(dto.getQnaDate())
				.qnaName(dto.getQnaName())
				.qnaTitle(dto.getQnaTitle())
				.qnaContent(dto.getQnaContent())
				.hotel(Hotel.builder().hotelNo(dto.getHotelNo()).build())
				.userinfo(Userinfo.builder().userNo(dto.getUserNo()).build())
				.build();
		return hotelQnA;
	}
}
