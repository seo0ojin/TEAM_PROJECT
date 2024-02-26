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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class RestaurantImage {
	@Id
	@SequenceGenerator(name = "RESTAURANT_IMAGE_SEQ", sequenceName = "RESTAURANT_IMAGE_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "RESTAURANT_IMAGE_SEQ", strategy = GenerationType.SEQUENCE)
	private Long imageNo;
	private String imageName;
	
	@JoinColumn(name = "restaurant_no")
	@ManyToOne(fetch = FetchType.LAZY)
	private Restaurant restaurant;
}
