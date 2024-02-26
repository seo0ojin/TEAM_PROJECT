package com.jeju.dto;

import java.time.LocalDate;

import com.jeju.entity.HotelBooking;

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
public class HotelBookingUpdateDto {

	private LocalDate hbCheckin;
	private LocalDate hbCheckout;
	private Integer hbPersons;
	private String hbPhone;
	private Integer hbPrice;
	
	public static HotelBookingUpdateDto toDto(HotelBooking entity) {
		HotelBookingUpdateDto update = HotelBookingUpdateDto.builder()
				.hbCheckin(entity.getHbCheckin())
				.hbCheckout(entity.getHbCheckout())
				.hbPersons(entity.getHbPersons())
				.hbPhone(entity.getHbPhone())
				.hbPrice(entity.getHbPrice())
				.build();
		return update;
	}
	
	public static HotelBooking toEntity(HotelBookingUpdateDto dto) {
		HotelBooking booking = HotelBooking.builder()
				.hbCheckin(dto.getHbCheckin())
				.hbCheckout(dto.getHbCheckout())
				.hbPersons(dto.getHbPersons())
				.hbPhone(dto.getHbPhone())
				.hbPrice(dto.getHbPrice())
				.build();
		return booking;
	}
}
