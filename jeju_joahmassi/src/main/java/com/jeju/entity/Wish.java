package com.jeju.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
public class Wish {
	
	@Id
	@SequenceGenerator(name = "WISH_NO_SEQ",sequenceName = "WISH_NO_SEQ",allocationSize = 1,initialValue = 1)
	@GeneratedValue(generator = "WISH_NO_SEQ",strategy = GenerationType.SEQUENCE)
	private Long wishNo;
	private String wishCategory;
	
	@Builder.Default
	@JoinColumn(name = "user_no")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Userinfo userinfo = new Userinfo();
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "hotel_no", unique = false)
	@Builder.Default
	private Hotel hotel = new Hotel();

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "restaurant_no", unique = false)
	@Builder.Default
	private Restaurant restaurant = new Restaurant();

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "attraction_no", unique = false)
	@Builder.Default
	private Attraction attraction = new Attraction();
}
