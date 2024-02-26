package com.jeju.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class HotelCategoryItem {

	@Id
	@SequenceGenerator(name = "HCI_NO_SEQ",sequenceName = "HCI_NO_SEQ",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "HCI_NO_SEQ")
	private Long hciNo;
	
	@ToString.Exclude
	@Builder.Default
	@JoinColumn(name = "hc_no")
	@ManyToOne(fetch = FetchType.LAZY)
	private HotelCategory hotelCategory = new HotelCategory();
	
	@ToString.Exclude
	@Builder.Default
	@JoinColumn(name = "hotel_no")
	@ManyToOne(fetch = FetchType.LAZY)
	private Hotel hotel = new Hotel();
}
