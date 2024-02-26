package com.jeju.entity;
import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.CascadeType;
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
public class AttractionReview {

	@Id
	@SequenceGenerator(name = "AR_NO_SEQ",sequenceName = "AR_NO_SEQ",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "AR_NO_SEQ")
	private Long arNo;
	
	private String arContent;
	private LocalDate arDate;
	private Double arStar;
	
	@Builder.Default
	@JoinColumn(name = "attraction_no")
	@ManyToOne(fetch = FetchType.LAZY)
	@ToString.Exclude
	private Attraction attraction = new Attraction();
	
	@Builder.Default
	@JoinColumn(name = "user_no")
	@ManyToOne(fetch = FetchType.LAZY)
	@ToString.Exclude
	private Userinfo userinfo = new Userinfo();

}
