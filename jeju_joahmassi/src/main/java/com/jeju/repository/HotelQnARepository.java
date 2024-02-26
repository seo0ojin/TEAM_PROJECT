package com.jeju.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jeju.entity.Hotel;
import com.jeju.entity.HotelQnA;

public interface HotelQnARepository extends JpaRepository<HotelQnA, Long>{

	// 내가 작성한 모든 QnA 리스트
	Page<HotelQnA> findByUserinfoUserNo(Long userNo, Pageable pageable);
	List<HotelQnA> findByUserinfoUserNo(Long userNo);
	
	// 호텔별 QnA 리스트
	Page<HotelQnA> findByHotelHotelNo(Long hotelNo, Pageable pageable);
	List<HotelQnA> findByHotelHotelNo(Long hotelNo);
	// 호텔별 QnA 정렬 리스트
	List<HotelQnA> findByHotelHotelNoOrderByQnaNoDesc(Long hotelNo);
	
	// QnA 목록에서 이름으로 검색
	Page<HotelQnA> findByQnaNameLike(String qnaName, Pageable pageable);
	List<HotelQnA> findByQnaNameLike(String qnaName);
	
	// hotelNo에 해당하는 qnaName을 사용하여 검색하는 메소드
	Page<HotelQnA> findByHotel_HotelNoAndQnaNameContaining(Long hotelNo, String qnaName, Pageable pageable);
	List<HotelQnA> findByHotel_HotelNoAndQnaNameContaining(Long hotelNo, String qnaName);
	
	// hotelNo에 해당하는 qnaTitle을 사용하여 검색하는 메소드
	Page<HotelQnA> findByHotel_HotelNoAndQnaTitleContaining(Long hotelNo, String qnaTitle, Pageable pageable);
	List<HotelQnA> findByHotel_HotelNoAndQnaTitleContaining(Long hotelNo, String qnaTitle);
}

