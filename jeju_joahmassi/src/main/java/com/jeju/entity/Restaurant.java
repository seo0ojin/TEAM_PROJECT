package com.jeju.entity;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingContainer;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
public class Restaurant {

	@Id
	@SequenceGenerator(name = "RESTAURANT_SEQ", sequenceName = "RESTAURANT_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "RESTAURANT_SEQ", strategy = GenerationType.SEQUENCE)
	private Long restaurantNo;
	private String restaurantName;
	private String restaurantAddress;
	private Double restaurantStar;
	private String restaurantTel;
	private String restaurantDesc;
	@Column(length = 4000)
	private String restaurantMap;
	
	
	@ToString.Exclude
	@Builder.Default
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<RestaurantBooking> restaurantBookings = new ArrayList<RestaurantBooking>();
	
	@ToString.Exclude
	@Builder.Default
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JsonProperty(required = false)
	private List<RestaurantMenu> restaurantMenus = new ArrayList<RestaurantMenu>();
	
	@ToString.Exclude
	@Builder.Default
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<RestaurantReview> restaurantReviews = new ArrayList<RestaurantReview>();
	
	@ToString.Exclude
	@Builder.Default
	@OneToMany(mappedBy = "restaurant", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	private List<RestaurantCategoryItem> restaurantCategoryItems = new ArrayList<RestaurantCategoryItem>();
	
	@ToString.Exclude
	@Builder.Default
	@OneToMany(mappedBy = "restaurant", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	private List<RestaurantImage> restaurantImages = new ArrayList<RestaurantImage>();
	
}
