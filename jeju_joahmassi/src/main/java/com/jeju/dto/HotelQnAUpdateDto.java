package com.jeju.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jeju.entity.Hotel;
import com.jeju.entity.HotelQnA;
import com.jeju.service.HotelService;

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
public class HotelQnAUpdateDto {

	private String qnaTitle;
	private String qnaContent;
	
	public static HotelQnAUpdateDto toDto(HotelQnA entity) {
		HotelQnAUpdateDto update = HotelQnAUpdateDto.builder()
				.qnaTitle(entity.getQnaTitle())
				.qnaContent(entity.getQnaContent())
				.build();
		return update;
	}
	/*
	public static HotelQnA toEntity(HotelQnAUpdateDto dto) {
		HotelQnA qna = HotelQnA.builder()
				.qnaNo(dto.getQnaNo())
				.qnaTitle(dto.getQnaTitle())
				.qnaContent(dto.getQnaContent())
				.build();
		return qna;
	}
	*/
	public static HotelQnA toEntity(HotelQnAUpdateDto dto) {
	    HotelQnA qna = HotelQnA.builder()
	            .qnaTitle(dto.getQnaTitle())
	            .qnaContent(dto.getQnaContent())
	            .build();
	    return qna;
	}
}
