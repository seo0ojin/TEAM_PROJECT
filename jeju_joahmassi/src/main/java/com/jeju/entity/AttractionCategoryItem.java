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
public class AttractionCategoryItem {

	@Id
	@SequenceGenerator(name = "ACI_NO_SEQ",sequenceName = "ACI_NO_SEQ",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ACI_NO_SEQ")
	private Long aciNo;
	
	@ToString.Exclude
	@Builder.Default
	@JoinColumn(name = "ac_no")
	@ManyToOne(fetch = FetchType.LAZY)
	private AttractionCategory attractionCategory = new AttractionCategory();
	
	@ToString.Exclude
	@Builder.Default
	@JoinColumn(name = "attraction_no")
	@ManyToOne(fetch = FetchType.LAZY)
	private Attraction attraction = new Attraction();
}
