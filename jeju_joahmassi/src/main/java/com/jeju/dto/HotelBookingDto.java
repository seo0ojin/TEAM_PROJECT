package com.jeju.dto;

import java.time.LocalDate;

import com.jeju.entity.Hotel;
import com.jeju.entity.HotelBooking;
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
public class HotelBookingDto {

	private Long hbNo;
	
	private LocalDate hbCheckin;
	private LocalDate hbCheckout;
	private String hbName;
	private Integer hbPersons;
	private String hbPhone;
	private Integer hbPrice;
	
	private Long hotelNo;
	private Long userNo;
	
	private int status;
	
	private String bookingDate;
	private String people;
	
	public static HotelBookingDto toDto(HotelBooking entity) {
		HotelBookingDto bookingDto = HotelBookingDto.builder()
				.hbNo(entity.getHbNo())
				.hbCheckin(entity.getHbCheckin())
				.hbCheckout(entity.getHbCheckout())
				.hbName(entity.getHbName())
				.hbPersons(entity.getHbPersons())
				.hbPhone(entity.getHbPhone())
				.hbPrice(entity.getHbPrice())
				.hotelNo(entity.getHotel().getHotelNo())
				.userNo(entity.getUserinfo().getUserNo())
				.build();
		return bookingDto;
	}
	
	public static HotelBooking toEntity(HotelBookingDto dto) {
		HotelBooking hotelBooking = HotelBooking.builder()
				.hbNo(dto.getHbNo())
				.hbCheckin(dto.getHbCheckin())
				.hbCheckout(dto.getHbCheckout())
				.hbName(dto.getHbName())
				.hbPersons(dto.getHbPersons())
				.hbPhone(dto.getHbPhone())
				.hbPrice(dto.getHbPrice())
				.hotel(Hotel.builder().hotelNo(dto.getHotelNo()).build())
				.userinfo(Userinfo.builder().userNo(dto.getUserNo()).build())
				.build();
		return hotelBooking;
	}
}
