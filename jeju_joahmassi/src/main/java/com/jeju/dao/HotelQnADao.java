package com.jeju.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jeju.entity.HotelQnA;

public interface HotelQnADao {

	// QnA 작성
	HotelQnA insertQnA(HotelQnA qna);
	
	// QnA 찾기
	HotelQnA findByQnANo(Long qnaNo);
	
	// QnA 수정
	HotelQnA updateQnA(HotelQnA qna);
	
	// QnA 삭제
	void deleteByQnANo(Long qnaNo);
	
	// 비밀번호 일치 여부
	//boolean checkPassword(Long qnaNo, String password);

	// 전체 QnA 리스트
	List<HotelQnA> findAllQnA();
	
	// 내가 작성한 모든 QnA 리스트
	Page<HotelQnA> findByUserinfoUserNo(Long userNo, Pageable pageable);
	List<HotelQnA> findByUserinfoUserNo(Long userNo);
	
	// 호텔별 QnA 리스트
	Page<HotelQnA> findByHotelHotelNo(Long hotelNo, Pageable pageable);
	List<HotelQnA> findByHotelHotelNo(Long hotelNo);
	
	// QnA 목록에서 이름으로 검색
	Page<HotelQnA> findByQnaNameLike(String qnaName, Pageable pageable);
	List<HotelQnA> findByQnaNameLike(String qnaName);
	
	// hotelNo에 해당하는 qnaName을 사용하여 검색하는 메소드
	Page<HotelQnA> findByHotel_HotelNoAndQnaNameContaining(Long hotelNo, String qnaName, Pageable pageable);
	List<HotelQnA> findByHotel_HotelNoAndQnaNameContaining(Long hotelNo, String qnaName);
	
	// hotelNo에 해당하는 qnaTitle을 사용하여 검색하는 메소드
	Page<HotelQnA> findByHotel_HotelNoAndQnaTitleContaining(Long hotelNo, String qnaTitle, Pageable pageable);
	List<HotelQnA> findByHotel_HotelNoAndQnaTitleContaining(Long hotelNo, String qnaTitle);
	
	// 페이징
	Page<HotelQnA> hotelQnAFindAllPage(Pageable pageable);
	
	// 호텔별 QnA 정렬 리스트
	List<HotelQnA> findByHotelHotelNoOrderByQnaNoDesc(Long hotelNo);
	
}
