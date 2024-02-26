package com.jeju.entity;

import java.util.ArrayList;
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
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class HotelAmenity {
	
	@Id
	@SequenceGenerator(name = "HA_NO_SEQ",sequenceName = "HA_NO_SEQ",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "HA_NO_SEQ")
	private Long haNo;
	private Integer haCheck;
	
	@Builder.Default
	@JoinColumn(name = "hotel_no")
	@ManyToOne(fetch = FetchType.LAZY)
	@ToString.Exclude
	private Hotel hotel = new Hotel();
}
