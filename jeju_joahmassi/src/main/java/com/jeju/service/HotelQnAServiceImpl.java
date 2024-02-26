package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jeju.dao.HotelQnADao;
import com.jeju.entity.HotelQnA;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class HotelQnAServiceImpl implements HotelQnAService{

	@Autowired
	HotelQnADao hotelQnADao;
	
	@Override
	// QnA 작성
	public HotelQnA insertQnA(HotelQnA qna) {
		return hotelQnADao.insertQnA(qna);
	}

	@Override
	// QnA 찾기
	public HotelQnA findByQnANo(Long qnaNo) {
		return hotelQnADao.findByQnANo(qnaNo);
	}

	@Override
	// QnA 수정
	public HotelQnA updateQnA(HotelQnA qna) {
		return hotelQnADao.updateQnA(qna);
	}

	@Override
	// QnA 삭제
	public void deleteByQnANo(Long qnaNo) {
		hotelQnADao.deleteByQnANo(qnaNo);
	}

	@Override
	// 전체 QnA 리스트 
	public List<HotelQnA> findAllQnA() {
		return hotelQnADao.findAllQnA();
	}

	@Override
	// 내가 작성한 모든 QnA 리스트
	public Page<HotelQnA> findByUserinfoUserNo(Long userNo, Pageable pageable) {
		return hotelQnADao.findByUserinfoUserNo(userNo, pageable);
	}

	@Override
	// 호텔별 QnA 리스트
	public Page<HotelQnA> findByHotelHotelNo(Long hotelNo, Pageable pageable) {
		return hotelQnADao.findByHotelHotelNo(hotelNo, pageable);
	}

	@Override
	// QnA 목록에서 이름으로 검색
	public Page<HotelQnA> findByQnaNameLike(String qnaName, Pageable pageable) {
		return hotelQnADao.findByQnaNameLike(qnaName, pageable);
	}

	@Override
	public Page<HotelQnA> hotelQnAFindAllPage(Pageable pageable) {
		return hotelQnADao.hotelQnAFindAllPage(pageable);
	}

	@Override
	public Page<HotelQnA> findByHotel_HotelNoAndQnaNameContaining(Long hotelNo, String qnaName, Pageable pageable) {
		return hotelQnADao.findByQnaNameLike(qnaName, pageable);
	}

	@Override
	public Page<HotelQnA> findByHotel_HotelNoAndQnaTitleContaining(Long hotelNo, String qnaTitle, Pageable pageable) {
		return hotelQnADao.findByHotel_HotelNoAndQnaTitleContaining(hotelNo, qnaTitle, pageable);
	}

	@Override
	public List<HotelQnA> findByUserinfoUserNo(Long userNo) {
		return hotelQnADao.findByUserinfoUserNo(userNo);
	}

	@Override
	public List<HotelQnA> findByHotelHotelNo(Long hotelNo) {
		return hotelQnADao.findByHotelHotelNo(hotelNo);
	}

	@Override
	public List<HotelQnA> findByQnaNameLike(String qnaName) {
		return hotelQnADao.findByQnaNameLike(qnaName);
	}

	@Override
	public List<HotelQnA> findByHotel_HotelNoAndQnaNameContaining(Long hotelNo, String qnaName) {
		return hotelQnADao.findByHotel_HotelNoAndQnaNameContaining(hotelNo, qnaName);
	}

	@Override
	public List<HotelQnA> findByHotel_HotelNoAndQnaTitleContaining(Long hotelNo, String qnaTitle) {
		return hotelQnADao.findByHotel_HotelNoAndQnaTitleContaining(hotelNo, qnaTitle);
	}
	/*
	@Override
	public boolean checkPassword(Long qnaNo, String password) {
		HotelQnA hotelQnA = hotelQnADao.findByQnANo(qnaNo);
		return hotelQnA != null && hotelQnA.getQnaPassword().equals(password);
	}
	*/

	@Override
	public List<HotelQnA> findByHotelHotelNoOrderByQnaNoDesc(Long hotelNo) {
		return hotelQnADao.findByHotelHotelNoOrderByQnaNoDesc(hotelNo);
	}
}
