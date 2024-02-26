package com.jeju.dao;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.entity.HotelQnA;

import jakarta.transaction.Transactional;

class HotelQnADaoImplTest extends JejuJoahmassiApplicationTests{

	@Autowired
	HotelQnADao hotelQnADao;
	@Autowired
	HotelDao hotelDao;
	@Autowired
	UserinfoDao userinfoDao;
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void insertQnA() {
		HotelQnA qna1 = HotelQnA.builder()
				.qnaDate(LocalDate.of(2023, 12, 11))
				.qnaName("도경수")
				//.qnaPassword("0112")
				.qnaTitle("도경수 잘생김")
				.qnaContent("도경수 잘생긴거 누가 모르죠")
				//.qnaGroupNo(1)
				//.qnaStep(1)
				//.qnaDepth(1)
				.hotel(hotelDao.findByHotelNo(1L))
				.userinfo(userinfoDao.findByUserNo(1L))
				.build();
		// 비회원이 글 쓸 때 userinfo는 우짬?
		hotelQnADao.insertQnA(qna1);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByQnANo() {
		HotelQnA find = hotelQnADao.findByQnANo(1L);
		System.out.println(find);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void updateQnA() {
		HotelQnA update = hotelQnADao.findByQnANo(1L);
		update.setQnaTitle("도도경경수수");
		System.out.println(update);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void deleteByQnANo() {
		hotelQnADao.deleteByQnANo(1L);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findAllQnA() {
		List<HotelQnA> qna = hotelQnADao.findAllQnA();
		System.out.println(qna);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByUserinfoUserNo() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("qnaNo")));
		Page<HotelQnA> myQnA = hotelQnADao.findByUserinfoUserNo(1L, pageable);
		System.out.println(myQnA);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHotelHotelNo() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("qnaNo")));
		Page<HotelQnA> hotelQnA = hotelQnADao.findByHotelHotelNo(1L, pageable);
		System.out.println(hotelQnA);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByQnaNameLike() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("qnaNo")));
		Page<HotelQnA> find = hotelQnADao.findByQnaNameLike("%%", pageable);
		System.out.println(find);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHotel_HotelNoAndQnaNameContaining() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("qnaDate")));
		Page<HotelQnA> find = hotelQnADao.findByHotel_HotelNoAndQnaNameContaining(1L, "도경수", pageable);
		System.out.println(find.getContent());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHotel_HotelNoAndQnaTitleContaining() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("qnaDate")));
		Page<HotelQnA> find = hotelQnADao.findByHotel_HotelNoAndQnaTitleContaining(1L, "잘생김", pageable);
		System.out.println(find.getContent());
	}

	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void checkPassword() {
		//System.out.println(hotelQnADao.checkPassword(1L, "테스트"));
		
	}
}
