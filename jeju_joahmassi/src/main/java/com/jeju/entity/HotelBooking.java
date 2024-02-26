package com.jeju.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class HotelBooking {

	@Id
	@SequenceGenerator(name = "HB_NO_SEQ",sequenceName = "HB_NO_SEQ",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "HB_NO_SEQ")
	private Long hbNo;
	
	private LocalDate hbCheckin;
	private LocalDate hbCheckout;
	private String hbName;
	private Integer hbPersons;
	private String hbPhone;
	private Integer hbPrice;
	
	@Builder.Default
	@JoinColumn(name = "hotel_no")
	@ManyToOne(fetch = FetchType.LAZY)
	@ToString.Exclude
	private Hotel hotel = new Hotel();
	
	@Builder.Default
	@JoinColumn(name = "user_no")
	@ManyToOne(fetch = FetchType.LAZY)
	@ToString.Exclude
	private Userinfo userinfo = new Userinfo();
}
