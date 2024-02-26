package com.jeju.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class RestaurantBooking {

	@Id
	@SequenceGenerator(name = "RB_NO_SEQ", sequenceName = "RB_NO_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "RB_NO_SEQ", strategy = GenerationType.SEQUENCE)
	private Long rbNo;
	private String rbName;
	private String rbPhone;
	private LocalDate rbDate;
	private String rbTime;
	private Integer rbPersons;
	
	@Builder.Default
	@JoinColumn(name = "restaurant_no")
	@ManyToOne(fetch = FetchType.LAZY)
	private Restaurant restaurant = new Restaurant();
	
	@Builder.Default
	@JoinColumn(name = "user_no")
	@ManyToOne(fetch = FetchType.LAZY)
	private Userinfo userinfo = new Userinfo();
	
}
