package com.jeju.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
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
public class Hotel {

	@Id
	@SequenceGenerator(name = "HOTEL_NO_SEQ",sequenceName = "HOTEL_NO_SEQ",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "HOTEL_NO_SEQ")
	private Long hotelNo;
	
	private String hotelName;
	private String hotelLocal;
	private Integer hotelPrice;
	private Double hotelStar;
	private String hotelDesc;
	@Column(length = 4000)
	private String hotelMap;
	
	@Builder.Default
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@ToString.Exclude
	private List<HotelAmenity> hotelAmenity = new ArrayList<HotelAmenity>();
	
	
	@Builder.Default
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@ToString.Exclude
	private List<HotelBooking> hotelBooking = new ArrayList<HotelBooking>();
	
	@Builder.Default
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@ToString.Exclude
	private List<HotelReview> hotelReview = new ArrayList<HotelReview>();
	   
	@Builder.Default
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@ToString.Exclude
	private List<HotelQnA> hotelQnA = new ArrayList<HotelQnA>();
	
	@ToString.Exclude
	@Builder.Default
	@OneToMany(mappedBy = "hotel", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	private List<HotelCategoryItem> hotelCategoryItems = new ArrayList<HotelCategoryItem>();
	
	@ToString.Exclude
	@Builder.Default
	@OneToMany(mappedBy = "hotel", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	private List<HotelImage> hotelImages = new ArrayList<HotelImage>();
	
}