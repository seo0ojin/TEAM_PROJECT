package com.jeju.controller;

import java.nio.charset.Charset;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeju.dto.AttractionReviewDto;
import com.jeju.entity.Attraction;
import com.jeju.entity.AttractionReview;
import com.jeju.entity.Userinfo;
import com.jeju.service.AttractionReviewService;
import com.jeju.service.AttractionService;
import com.jeju.service.UserinfoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/attractionReview")
public class AttractionReviewRestController {

	@Autowired
	private AttractionReviewService attractionReviewService;
	@Autowired
	private AttractionService attractionService;
	@Autowired
	private UserinfoService userinfoService;
	
	@Operation(summary = "명소 리뷰 작성")
	@PostMapping("/insert")
	public ResponseEntity<AttractionReviewDto> insertAttractionReview(@RequestBody AttractionReviewDto dto) {
		System.out.println(">>>>>>>>>>>>>>>>" + dto);
		
		Userinfo userinfo = userinfoService.findByUserNo(dto.getUserNo());
		
		Attraction attraction = attractionService.findByAttractionNo(dto.getAttractionNo());
		
		AttractionReview attractionReview = AttractionReviewDto.toEntity(dto);
		
		attractionReview.setUserinfo(userinfo);
		attractionReview.setAttraction(attraction);
		attractionReview.setArDate(LocalDate.now());
		attractionReviewService.insert(attractionReview);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<AttractionReviewDto>(dto, httpHeaders, HttpStatus.OK);
	}
	
	@Operation(summary = "명소 리뷰 삭제")
	@DeleteMapping("/delete")
	public ResponseEntity<AttractionReviewDto> deleteAttractionReview(@RequestBody AttractionReviewDto dto) {
		
		attractionReviewService.deleteByArNo(dto.getArNo());
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<AttractionReviewDto>(httpHeaders, HttpStatus.OK);
	}
	
	@Operation(summary = "명소 리뷰 수정")
	@PutMapping("/update")
	public ResponseEntity<AttractionReviewDto> updateAttractionReview(@RequestBody AttractionReviewDto dto) {
		System.out.println(">>>>>>>>>>>>>>>>"+dto);
		AttractionReview attractionReview = attractionReviewService.findByArNo(dto.getArNo());
		
		
		if (attractionReview != null) {
			attractionReview.setArContent(dto.getArContent());
			attractionReviewService.update(attractionReview);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<AttractionReviewDto>(dto, httpHeaders, HttpStatus.OK);
	}
	
	@Operation(summary = "명소 리뷰 수정 폼")
	@PutMapping("/updateForm")
	public ResponseEntity<AttractionReviewDto> updateFormAttractionReview(@RequestBody AttractionReviewDto dto) {		
		AttractionReview findAttractionReview = attractionReviewService.findByArNo(dto.getArNo());
		AttractionReviewDto findAttractionReviewDto = AttractionReviewDto.toDto(findAttractionReview);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<AttractionReviewDto>(findAttractionReviewDto, httpHeaders, HttpStatus.OK);
	}
}
