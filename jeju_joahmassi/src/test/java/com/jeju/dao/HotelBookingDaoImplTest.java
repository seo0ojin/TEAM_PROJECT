package com.jeju.dao;


import java.time.LocalDate;

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

class HotelBookingDaoImplTest extends JejuJoahmassiApplicationTests{
	@Autowired
	HotelBookingDao hotelBookingDao;
	@Autowired
	HotelDao hotelDao;
	@Autowired
	UserinfoDao userinfoDao;
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void insertHb() {
		
		HotelBooking hb1 = HotelBooking.builder()
				.hbCheckin(LocalDate.of(2023, 12, 11))
				.hbCheckout(LocalDate.of(2023, 12, 13))
				.hbName("전아현")
				.hbPersons(2)
				.hbPhone("010-1111-1111")
				.hbPrice(140000)
				.hotel(hotelDao.findByHotelNo(1L))
				.userinfo(userinfoDao.findByUserNo(1L))
				.build();
		hotelBookingDao.insertHb(hb1);
		
		HotelBooking hb2 = HotelBooking.builder()
				// Date를 LocalDate로 바꿀지 의논해야함
				.hbCheckin(LocalDate.of(2023, 12, 11))
				.hbCheckout(LocalDate.of(2023, 12, 12))
				.hbName("되냐되냐")
				.hbPersons(2)
				.hbPhone("010-2222-2222")
				.hbPrice(300000)
				.hotel(hotelDao.findByHotelNo(2L))
				.userinfo(userinfoDao.findByUserNo(1L))
				.build();
		hotelBookingDao.insertHb(hb2);
		
		
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHbNo() {
		HotelBooking find = hotelBookingDao.findByHbNo(1L);
		System.out.println(find);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void updateHb() {
		HotelBooking update = hotelBookingDao.findByHbNo(1L);
		update.setHbPersons(3);
		System.out.println(update);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void deleteByhbNo() {
		hotelBookingDao.deleteByhbNo(3L);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findAll() {
		List<HotelBooking> list = hotelBookingDao.findAll();
		System.out.println(list);
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByUserinfoUserNo() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hbNo")));
		Page<HotelBooking> myList = hotelBookingDao.findByUserinfoUserNo(7L, pageable);
		System.out.println(myList);	
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHotelHotelNo() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hbNo")));
		Page<HotelBooking> hotelList = hotelBookingDao.findByHotelHotelNo(1L, pageable);
		System.out.println(hotelList);	
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByHbCheckinLessThanEqualAndHbCheckoutGreaterThanEqualAndUserinfoUserNo() {
		Pageable pageable =  PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hbCheckin")));
		Page<HotelBooking> list = hotelBookingDao.findByHbCheckinBetweenAndUserinfoUserNo(LocalDate.of(2023, 12, 1),LocalDate.of(2023, 12, 30),1L, pageable);
		System.out.println(list.getContent());
	}


}
