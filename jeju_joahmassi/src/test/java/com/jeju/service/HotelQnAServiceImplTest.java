package com.jeju.service;


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

class HotelQnAServiceImplTest extends JejuJoahmassiApplicationTests{

	@Autowired
	HotelQnAService hotelQnAService;
	@Autowired
	HotelService hotelService;
	@Autowired
	UserinfoService userinfoService;
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void insertQnA() {
		HotelQnA qna1 = HotelQnA.builder()
				.qnaNo(null)
				.qnaDate(LocalDate.of(2023, 12, 11))
				.qnaName("저나현")
				//.qnaPassword("1111")
				.qnaTitle("아하기싫어")
				.qnaContent("진차 하기시러")
				//.qnaGroupNo(2)
				//.qnaStep(1)
				//.qnaDepth(1)
				.userinfo(userinfoService.findByUserNo(1L))
				.hotel(hotelService.findByHotelNo(1L))
				.build();
		hotelQnAService.insertQnA(qna1);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByQnANo() {
		HotelQnA find = hotelQnAService.findByQnANo(2L);
		System.out.println(find);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void updateQnA() {
		HotelQnA update = hotelQnAService.findByQnANo(1L);
		update.setQnaTitle("개개개하기시러~");
		System.out.println(update);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void deleteByQnANo() {
		hotelQnAService.deleteByQnANo(1L);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findAllQnA() {
		List<HotelQnA> list = hotelQnAService.findAllQnA();
		System.out.println(list);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByUserinfoUserNo() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("qnaNo")));
		Page<HotelQnA> myQnA = hotelQnAService.findByUserinfoUserNo(1L, pageable);
		System.out.println(myQnA);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHotelHotelNo() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("qnaNo")));
		Page<HotelQnA> hotelQnA = hotelQnAService.findByHotelHotelNo(1L, pageable);
		System.out.println(hotelQnA);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByQnaNameLike() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("qnaNo")));
		Page<HotelQnA> findQnA = hotelQnAService.findByQnaNameLike("%%", pageable);
		System.out.println(findQnA);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHotel_HotelNoAndQnaNameContaining() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("qnaDate")));
		Page<HotelQnA> find = hotelQnAService.findByHotel_HotelNoAndQnaNameContaining(1L, "도경수", pageable);
		System.out.println(find.getContent());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHotel_HotelNoAndQnaTitleContaining() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("qnaDate")));
		Page<HotelQnA> find = hotelQnAService.findByHotel_HotelNoAndQnaTitleContaining(1L, "잘생김", pageable);
		System.out.println(find.getContent());
	}

}
