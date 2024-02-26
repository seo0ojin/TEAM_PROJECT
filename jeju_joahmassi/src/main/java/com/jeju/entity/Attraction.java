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
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
public class Attraction {

	@Id
	@SequenceGenerator(name = "ATTRACTION_NO_SEQ",sequenceName = "ATTRACTION_NO_SEQ",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ATTRACTION_NO_SEQ")
	private Long attractionNo;
	private String attractionName;
	private String attractionAddress;
	private String attractionDesc;
	private Integer attractionStar;
	@Column(length = 4000)
	private String attractionMap;
	
	@Builder.Default
	@OneToMany(mappedBy = "attraction", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<AttractionReview> attractionReviews = new ArrayList<AttractionReview>();
	
	@ToString.Exclude
	@Builder.Default
	@OneToMany(mappedBy = "attraction", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	private List<AttractionCategoryItem> attractionCategoryItems = new ArrayList<AttractionCategoryItem>();
	
	@ToString.Exclude
	@Builder.Default
	@OneToMany(mappedBy = "attraction", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	private List<AttractionImage> attractionImages = new ArrayList<AttractionImage>();
	
}
