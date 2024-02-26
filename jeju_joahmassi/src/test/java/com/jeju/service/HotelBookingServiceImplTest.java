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
import com.jeju.entity.HotelBooking;

import jakarta.transaction.Transactional;

class HotelBookingServiceImplTest extends JejuJoahmassiApplicationTests{

	@Autowired
	HotelBookingService hotelBookingService;
	@Autowired
	HotelService hotelService;
	@Autowired
	UserinfoService userinfoService;
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void insertHb() {
		
		HotelBooking hb1 = HotelBooking.builder()
				.hbCheckin(LocalDate.of(2023, 12, 1))
				.hbCheckout(LocalDate.of(2023, 12, 1))
				.hbName("전아현")
				.hbPersons(2)
				.hbPhone("010-1111-1111")
				.hbPrice(140000)
				.hotel(hotelService.findByHotelNo(1L))
				.userinfo(userinfoService.findByUserNo(1L))
				.build();
		hotelBookingService.insertHb(hb1);
		
		HotelBooking hb2 = HotelBooking.builder()
				.hbCheckin(LocalDate.of(2023, 12, 1))
				.hbCheckout(LocalDate.of(2023, 12, 1))
				.hbName("박서진")
				.hbPersons(4)
				.hbPhone("010-1111-1111")
				.hbPrice(280000)
				.hotel(hotelService.findByHotelNo(1L))
				.userinfo(userinfoService.findByUserNo(1L))
				.build();
		hotelBookingService.insertHb(hb2);
		
		HotelBooking hb3 = HotelBooking.builder()
				.hbCheckin(LocalDate.of(2023, 12, 1))
				.hbCheckout(LocalDate.of(2023, 12, 1))
				.hbName("허승범")
				.hbPersons(1)
				.hbPhone("010-1111-1111")
				.hbPrice(70000)
				.hotel(hotelService.findByHotelNo(1L))
				.userinfo(userinfoService.findByUserNo(1L))
				.build();
		hotelBookingService.insertHb(hb3);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHbNo() {
		HotelBooking find = hotelBookingService.findByHbNo(1L);
		System.out.println(find);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void updateHb() {
		HotelBooking update = hotelBookingService.findByHbNo(1L);
		update.setHbPersons(3);
		System.out.println(update);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void deleteByhbNo() {
		hotelBookingService.deleteByhbNo(1L);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findAll() {
		List<HotelBooking> list = hotelBookingService.findAll();
		System.out.println(list);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByUserinfoUserNo() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hbNo")));
		Page<HotelBooking> myList = hotelBookingService.findByUserinfoUserNo(1L, pageable);
		System.out.println(myList);	
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHotelHotelNo() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hbNo")));
		Page<HotelBooking> hotelList = hotelBookingService.findByHotelHotelNo(1L, pageable);
		System.out.println(hotelList);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHbCheckinBetweenAndUserinfoUserNo() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hbCheckin")));
		Page<HotelBooking> list = hotelBookingService.findByHbCheckinBetweenAndUserinfoUserNo(LocalDate.of(2023, 12, 1),LocalDate.of(2023, 12, 30),1L, pageable);
		System.out.println(list.getContent());
	}
	
}
