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
public class RestaurantQnA {

	@Id
	@SequenceGenerator(name = "RQ_NO_SEQ",sequenceName = "RQ_NO_SEQ",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "RQ_NO_SEQ")
	private Long rqNo;
	
	private String rqQuestion;
	private String rqAnswer;
	
	@Builder.Default
	@JoinColumn(name = "restaurant_no")
	@ManyToOne(fetch = FetchType.LAZY)
	private Restaurant restaurant = new Restaurant();
}
