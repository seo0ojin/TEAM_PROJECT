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
public class HotelQnA {

	@Id
	@SequenceGenerator(name = "QNA_NO_SEQ",sequenceName = "QNA_NO_SEQ",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "QNA_NO_SEQ")
	private Long qnaNo;
	
	private LocalDate qnaDate;
	private String qnaName;
	private Integer qnaSecretCheck;
	private String qnaTitle;
	private String qnaContent;
	private Integer qnaStatus;
	private String qnaAnswer;
	
	@Builder.Default
	@JoinColumn(name = "hotel_no")
	@ManyToOne(fetch = FetchType.LAZY)
	private Hotel hotel = new Hotel();
	
	@Builder.Default
	@JoinColumn(name = "user_no")
	@ManyToOne(fetch = FetchType.LAZY)
	private Userinfo userinfo = new Userinfo();
}
