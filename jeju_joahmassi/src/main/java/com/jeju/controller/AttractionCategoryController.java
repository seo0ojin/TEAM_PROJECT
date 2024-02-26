package com.jeju.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeju.entity.AttractionCategory;
import com.jeju.service.AttractionCategoryService;

@Controller
@RequestMapping("/attractionCategory")
public class AttractionCategoryController {

	@Autowired
	private AttractionCategoryService attractionCategoryService;
	
	@GetMapping("/list")
	public String attractionCategoryList(Model model) {	
		List<AttractionCategory> categoryList = attractionCategoryService.findAll();
		
		model.addAttribute(categoryList);
		
		return null;
	}
}
