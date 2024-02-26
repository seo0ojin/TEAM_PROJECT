package com.jeju.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeju.dto.AttractionCategoryDto;
import com.jeju.dto.AttractionDto;
import com.jeju.dto.AttractionImageDto;
import com.jeju.dto.AttractionReviewDto;
import com.jeju.entity.Attraction;
import com.jeju.entity.AttractionCategory;
import com.jeju.entity.AttractionImage;
import com.jeju.entity.AttractionReview;
import com.jeju.entity.Userinfo;
import com.jeju.service.AttractionCategoryItemService;
import com.jeju.service.AttractionCategoryService;
import com.jeju.service.AttractionImageService;
import com.jeju.service.AttractionReviewService;
import com.jeju.service.AttractionService;
import com.jeju.service.UserinfoService;
import com.jeju.service.WishService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AttractionController {

	@Autowired
	private AttractionService attractionService;
	@Autowired
	private AttractionReviewService attractionReviewService;
	@Autowired
	private AttractionCategoryService attractionCategoryService;
	@Autowired
	private AttractionCategoryItemService attractionCategoryItemService;
	@Autowired
	private AttractionImageService attractionImageService;
	@Autowired
	private WishService wishService;
	@Autowired
	private UserinfoService userinfoService;
	
	@GetMapping("/attractionList")
	public String attractionList(Model model, HttpSession session) {
		Long userNo = (Long)session.getAttribute("userNo");
		List<Attraction> attractionList = attractionService.findAll();
		List<AttractionDto> viewList = new ArrayList<AttractionDto>();
		
		Integer page = 1;
		int pageSize = 9;
		
		for (int i = 0; i < attractionList.size(); i++) {
			if (i >= pageSize * (page - 1) && i < pageSize * page) {
				Attraction attraction = attractionList.get(i);
				
				List<AttractionReview> reviewList = attractionReviewService.findByAttractionAttractionNo(attraction.getAttractionNo());
				List<AttractionReviewDto> reviewDtoList = new ArrayList<AttractionReviewDto>();
				
				for (AttractionReview attractionReview : reviewList) {
					AttractionReviewDto attractionReviewDto2 = AttractionReviewDto.toDto(attractionReview);
					reviewDtoList.add(attractionReviewDto2);
					
				}
				
				double totStars = 0.0;
				
				for (AttractionReviewDto review : reviewDtoList) {
					totStars += review.getArStar();
				}
				
				int averageStars = 0;
				
				if (!reviewDtoList.isEmpty()) {
					double avgStars = totStars / reviewDtoList.size();
					averageStars = (int) Math.round(avgStars);
					
					attraction.setAttractionStar(averageStars);
					attractionService.updateAttraction(attraction);
				}
				
				List<AttractionImage> imageList = attractionImageService.findByAttractionAttractionNo(attraction.getAttractionNo());
				List<AttractionImageDto> imageDtoList = new ArrayList<AttractionImageDto>();
				
				for (AttractionImage attractionImage : imageList) {
					AttractionImageDto attractionImageDto = AttractionImageDto.toDto(attractionImage);
					imageDtoList.add(attractionImageDto);
				}
				
				boolean existWish = wishService.existByUserNoAndAttractionNo(userNo, attraction.getAttractionNo());
				
				AttractionDto attractionDto = AttractionDto.toDto(attraction);
				attractionDto.setAttractionReviewDto(reviewDtoList);
				attractionDto.setAttractionStar(averageStars);
				attractionDto.setAttractionImageDto(imageDtoList);
				attractionDto.setWishBool(existWish);
				viewList.add(attractionDto);
			}
		}
		
		List<AttractionCategory> attractionCategories = attractionCategoryService.findAll();
		List<AttractionCategoryDto> attractionCategoryDtoList = new ArrayList<AttractionCategoryDto>();
		
		for (AttractionCategory attractionCategory : attractionCategories) {
			AttractionCategoryDto attractionCategoryDto = AttractionCategoryDto.toDto(attractionCategory);
			int count = attractionCategoryItemService.findByAttractionCategoryAcNo(attractionCategory.getAcNo()).size();
			attractionCategoryDto.setCount(count);
			attractionCategoryDtoList.add(attractionCategoryDto);
		}
		
		model.addAttribute("attractionList", attractionList);
		model.addAttribute("viewList", viewList);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("attractionCategoriesDto", attractionCategoryDtoList);
		
		return "html/attraction/attraction-list";
	}
	
	@GetMapping(value = "/attractionDetail", params = "attractionNo")
	public String attractionDetail(Model model, @RequestParam Long attractionNo, String sortOrder, HttpSession session) throws Exception {
		Long userNo = (Long)session.getAttribute("userNo");
		
		if (userNo != null) {
		    Userinfo userinfo = userinfoService.findByUserNo(userNo);
		    Userinfo loginUser = userinfoService.login(userinfo.getUserId(), userinfo.getUserPassword());
		    
		    model.addAttribute("loginUser", loginUser);
		}
		
		Attraction attraction = attractionService.findByAttractionNo(attractionNo);
		List<AttractionReview> reviewList = attractionReviewService.findByAttractionAttractionNo(attraction.getAttractionNo());
		List<AttractionReviewDto> attractionReviewDtoList = new ArrayList<AttractionReviewDto>();
		
		for (AttractionReview attractionReview : reviewList) {
			AttractionReviewDto dto = AttractionReviewDto.toDto(attractionReview);
			attractionReviewDtoList.add(dto);
			Collections.sort(attractionReviewDtoList, Comparator.comparing(AttractionReviewDto::getArNo).reversed());
		}
		
		String[] RANDOM_IMAGE = { "assets/img/reviewProfile/profile1.jpg", 
				  "assets/img/reviewProfile/test2.jpg",
				  "assets/img/reviewProfile/test3.jpg",
				  "assets/img/reviewProfile/test4.jpg",
				  "assets/img/reviewProfile/test5.jpg",
				  "assets/img/reviewProfile/test6.jpg",
				  "assets/img/reviewProfile/test7.jpg",
				  "assets/img/reviewProfile/test8.jpg",
				  "assets/img/reviewProfile/test9.jpg" };
		
		Random random = new Random();
		
		for (int i = 0; i < attractionReviewDtoList.size(); i++) {
			int randomIndex = random.nextInt(RANDOM_IMAGE.length);
			String randomImageURL = RANDOM_IMAGE[randomIndex];
			attractionReviewDtoList.get(i).setRandomImageURL(randomImageURL);
		}
				
		double totStars = 0.0;
		double avgStars = 0.0;
		
		for (AttractionReview review : reviewList) {
			totStars += review.getArStar();
		}
		
		if (!reviewList.isEmpty()) {
			avgStars = Math.round(totStars / reviewList.size() * 10.0) / 10.0;
		}
		
		int averageStars = (int) Math.round(avgStars);
		
		List<AttractionImage> imageList = attractionImageService.findByAttractionAttractionNo(attractionNo);
		List<AttractionImageDto> imageDtoList = new ArrayList<AttractionImageDto>();
		
		for (AttractionImage attractionImage : imageList) {
			AttractionImageDto attractionImageDto = AttractionImageDto.toDto(attractionImage);
			imageDtoList.add(attractionImageDto);
		}
		
		boolean existWish = wishService.existByUserNoAndAttractionNo(userNo, attraction.getAttractionNo());

		List<AttractionReview> attractionReviewScore5 = new ArrayList<AttractionReview>();
		List<AttractionReview> attractionReviewScore4 = new ArrayList<AttractionReview>();
		List<AttractionReview> attractionReviewScore3 = new ArrayList<AttractionReview>();
		List<AttractionReview> attractionReviewScore2 = new ArrayList<AttractionReview>();
		List<AttractionReview> attractionReviewScore1 = new ArrayList<AttractionReview>();
		
		for (AttractionReview attractionReview : reviewList) {
			if (attractionReview.getArStar() == 5) {
				attractionReviewScore5.add(attractionReview);
			}
			if (attractionReview.getArStar() == 4) {
				attractionReviewScore4.add(attractionReview);
			}
			if (attractionReview.getArStar() == 3) {
				attractionReviewScore3.add(attractionReview);
			}
			if (attractionReview.getArStar() == 2) {
				attractionReviewScore2.add(attractionReview);
			}
			if (attractionReview.getArStar() == 1) {
				attractionReviewScore1.add(attractionReview);
			}
		}
		
		List<Double> gaugeList = new ArrayList<Double>();
		Double score5Gauge = ((double)attractionReviewScore5.size() / (double)reviewList.size()) * 100;
		Double score4Gauge = ((double)attractionReviewScore4.size() / (double)reviewList.size()) * 100;
		Double score3Gauge = ((double)attractionReviewScore3.size() / (double)reviewList.size()) * 100;
		Double score2Gauge = ((double)attractionReviewScore2.size() / (double)reviewList.size()) * 100;
		Double score1Gauge = ((double)attractionReviewScore1.size() / (double)reviewList.size()) * 100;
		score5Gauge = Math.round(score5Gauge * 10.0) / 10.0;
		score4Gauge = Math.round(score4Gauge * 10.0) / 10.0;
		score3Gauge = Math.round(score3Gauge * 10.0) / 10.0;
		score2Gauge = Math.round(score2Gauge * 10.0) / 10.0;
		score1Gauge = Math.round(score1Gauge * 10.0) / 10.0;
		gaugeList.add(score5Gauge);
		gaugeList.add(score4Gauge);
		gaugeList.add(score3Gauge);
		gaugeList.add(score2Gauge);
		gaugeList.add(score1Gauge);
		
		model.addAttribute("attraction", attraction);
		model.addAttribute("reviewList", attractionReviewDtoList);
		model.addAttribute("avgStars", avgStars);
		model.addAttribute("averageStars", averageStars);
		model.addAttribute("imageDtoList", imageDtoList);
		model.addAttribute("existWish", existWish);
		model.addAttribute("attractionReviewScore5", attractionReviewScore5);
		model.addAttribute("attractionReviewScore4", attractionReviewScore4);
		model.addAttribute("attractionReviewScore3", attractionReviewScore3);
		model.addAttribute("attractionReviewScore2", attractionReviewScore2);
		model.addAttribute("attractionReviewScore1", attractionReviewScore1);
		model.addAttribute("gaugeList", gaugeList);
		
		return "html/attraction/attraction-single-v2";
	}
}
