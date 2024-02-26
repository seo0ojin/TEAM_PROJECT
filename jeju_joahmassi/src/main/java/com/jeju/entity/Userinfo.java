package com.jeju.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class Userinfo {
	
	@Id
	@SequenceGenerator(name = "USER_NO_SEQ",sequenceName = "USER_NO_SEQ",allocationSize = 1,initialValue = 1)
	@GeneratedValue(generator = "USER_NO_SEQ",strategy = GenerationType.SEQUENCE)
	private Long userNo;
	private String userId;
	private String userPassword;
	private String userName;
	private String userResident;
	private String userPhone;
	private String userEmail;
	@CreationTimestamp
	private LocalDateTime userRegisterDate;
	private Integer userPoint;
	private Integer userCouponYear;
	
	
	
	@OneToMany(mappedBy = "userinfo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Builder.Default
	@ToString.Exclude
	private List<Coupon> coupon = new ArrayList<Coupon>();
	
	@OneToMany(mappedBy = "userinfo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Builder.Default
	@ToString.Exclude
	private List<Wish> wish = new ArrayList<Wish>();
	
	@OneToMany(mappedBy = "userinfo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Builder.Default
	@ToString.Exclude
	private List<HotelBooking> hotelBookings = new ArrayList<HotelBooking>();
	
	@OneToMany(mappedBy = "userinfo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Builder.Default
	@ToString.Exclude
	private List<HotelReview> hotelReviews = new ArrayList<HotelReview>();
	
	@OneToMany(mappedBy = "userinfo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Builder.Default
	@ToString.Exclude
	private List<RestaurantBooking> restaurantBookings = new ArrayList<RestaurantBooking>();
	
	@OneToMany(mappedBy = "userinfo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Builder.Default
	@ToString.Exclude
	private List<RestaurantReview> restaurantReviews = new ArrayList<RestaurantReview>();
	
	@OneToMany(mappedBy = "userinfo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Builder.Default
	@ToString.Exclude
	private List<AttractionReview> attractionReviews = new ArrayList<AttractionReview>();
	
	@OneToMany(mappedBy = "userinfo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Builder.Default
	@ToString.Exclude
	private List<HotelQnA> hotelQnA = new ArrayList<HotelQnA>();
	
	
}
