package com.jeju.entity;


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
public class RestaurantAmenity {
	
	@Id
	@SequenceGenerator(name = "RA_NO_SEQ",sequenceName = "RA_NO_SEQ",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "RA_NO_SEQ")
	private Long raNo;
	private Integer raCheck;
	
	@Builder.Default
	@JoinColumn(name = "restaurant_no")
	@ManyToOne(fetch = FetchType.LAZY)
	@ToString.Exclude
	private Restaurant restaurant = new Restaurant();
}
