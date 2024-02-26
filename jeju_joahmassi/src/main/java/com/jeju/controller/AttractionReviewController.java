package com.jeju.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeju.entity.AttractionReview;
import com.jeju.service.AttractionReviewService;

@Controller
@RequestMapping("/attractionReview")
public class AttractionReviewController {
	
	@Autowired
	private AttractionReviewService attractionReviewService;
	
	@GetMapping("/list")
	public String attractionReviewList(Model model) {
		List<AttractionReview> attractionReviewList = attractionReviewService.findAll();
		
		model.addAttribute(attractionReviewList);
		
		return null;
	}
}
