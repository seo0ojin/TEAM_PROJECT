package com.jeju.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.jeju.entity.HotelQnA;
import com.jeju.repository.HotelQnARepository;

@Repository
public class HotelQnADaoImpl implements HotelQnADao{

	@Autowired
	private HotelQnARepository hotelQnARepository;
	
	@Override
	// QnA 작성
	public HotelQnA insertQnA(HotelQnA qna) {
		return hotelQnARepository.save(qna);
	}

	@Override
	// QnA 찾기
	public HotelQnA findByQnANo(Long qnaNo) {
		return hotelQnARepository.findById(qnaNo).get();
	}

	@Override
	// QnA 수정
	public HotelQnA updateQnA(HotelQnA qna) {
		return hotelQnARepository.save(qna);
	}

	@Override
	// QnA 삭제
	public void deleteByQnANo(Long qnaNo) {
		hotelQnARepository.deleteById(qnaNo);
	}

	@Override
	// 전체 QnA 리스트 
	public List<HotelQnA> findAllQnA() {
		return hotelQnARepository.findAll();
	}

	@Override
	// 내가 작성한 모든 QnA 리스트
	public Page<HotelQnA> findByUserinfoUserNo(Long userNo, Pageable pageable) {
		return hotelQnARepository.findByUserinfoUserNo(userNo, pageable);
	}

	@Override
	// 호텔별 QnA 리스트
	public Page<HotelQnA> findByHotelHotelNo(Long hotelNo, Pageable pageable) {
		return hotelQnARepository.findByHotelHotelNo(hotelNo, pageable);
	}

	@Override
	// QnA 목록에서 이름으로 검색
	public Page<HotelQnA> findByQnaNameLike(String qnaName, Pageable pageable) {
		return hotelQnARepository.findByQnaNameLike(qnaName, pageable);
	}

	@Override
	public Page<HotelQnA> hotelQnAFindAllPage(Pageable pageable) {
		return hotelQnARepository.findAll(pageable);
	}

	@Override
	public Page<HotelQnA> findByHotel_HotelNoAndQnaNameContaining(Long hotelNo, String qnaName, Pageable pageable) {
		return hotelQnARepository.findByHotel_HotelNoAndQnaNameContaining(hotelNo, qnaName, pageable);
	}

	@Override
	public Page<HotelQnA> findByHotel_HotelNoAndQnaTitleContaining(Long hotelNo, String qnaTitle, Pageable pageable) {
		return hotelQnARepository.findByHotel_HotelNoAndQnaTitleContaining(hotelNo, qnaTitle, pageable);
	}

	@Override
	public List<HotelQnA> findByUserinfoUserNo(Long userNo) {
		return hotelQnARepository.findByUserinfoUserNo(userNo);
	}

	@Override
	public List<HotelQnA> findByHotelHotelNo(Long hotelNo) {
		return hotelQnARepository.findByHotelHotelNo(hotelNo);
	}

	@Override
	public List<HotelQnA> findByQnaNameLike(String qnaName) {
		return hotelQnARepository.findByQnaNameLike(qnaName);
	}

	@Override
	public List<HotelQnA> findByHotel_HotelNoAndQnaNameContaining(Long hotelNo, String qnaName) {
		return hotelQnARepository.findByHotel_HotelNoAndQnaNameContaining(hotelNo, qnaName);
	}

	@Override
	public List<HotelQnA> findByHotel_HotelNoAndQnaTitleContaining(Long hotelNo, String qnaTitle) {
		return hotelQnARepository.findByHotel_HotelNoAndQnaTitleContaining(hotelNo, qnaTitle);
	}

	@Override
	public List<HotelQnA> findByHotelHotelNoOrderByQnaNoDesc(Long hotelNo) {
		return hotelQnARepository.findByHotelHotelNoOrderByQnaNoDesc(hotelNo);
	}
	
	/*
	@Override
	public boolean checkPassword(Long qnaNo, String password) {
		HotelQnA hotelQnA = hotelQnARepository.findById(qnaNo).get();
		return hotelQnA != null && hotelQnA.getQnaPassword().equals(password);
	}
	*/
}
