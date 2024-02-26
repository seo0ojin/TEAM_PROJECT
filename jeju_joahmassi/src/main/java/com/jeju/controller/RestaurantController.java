package com.jeju.controller;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeju.dto.AttractionDto;
import com.jeju.dto.AttractionImageDto;
import com.jeju.dto.AttractionReviewDto;
import com.jeju.dto.HotelCategoryItemDto;
import com.jeju.dto.HotelImageDto;
import com.jeju.dto.RestaurantAmenityDto;
import com.jeju.dto.RestaurantCategoryItemDto;
import com.jeju.dto.RestaurantImageDto;
import com.jeju.dto.RestaurantInsertDto;
import com.jeju.dto.RestaurantReviewDto;
import com.jeju.dto.RestaurantReviewInsertDto;
import com.jeju.entity.Attraction;
import com.jeju.entity.AttractionImage;
import com.jeju.entity.AttractionReview;
import com.jeju.entity.HotelBooking;
import com.jeju.entity.HotelCategoryItem;
import com.jeju.entity.HotelImage;
import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantAmenity;
import com.jeju.entity.RestaurantBooking;
import com.jeju.entity.RestaurantCategory;
import com.jeju.entity.RestaurantCategoryItem;
import com.jeju.entity.RestaurantImage;
import com.jeju.entity.RestaurantMenu;
import com.jeju.entity.RestaurantQnA;
import com.jeju.entity.RestaurantReview;
import com.jeju.service.AttractionImageService;
import com.jeju.service.AttractionReviewService;
import com.jeju.service.AttractionService;
import com.jeju.service.RestaurantAmenityService;
import com.jeju.service.RestaurantBookingService;
import com.jeju.service.RestaurantCategoryItemService;
import com.jeju.service.RestaurantCategoryService;
import com.jeju.service.RestaurantImageService;
import com.jeju.service.RestaurantMenuService;
import com.jeju.service.RestaurantQnAService;
import com.jeju.service.RestaurantReviewService;
import com.jeju.service.RestaurantService;
import com.jeju.service.WishService;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;

@Controller
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private RestaurantReviewService restaurantReviewService;
	@Autowired
	private RestaurantCategoryService restaurantCategoryService;
	@Autowired
	private RestaurantCategoryItemService restaurantCategoryItemService;
	@Autowired
	private RestaurantBookingService restaurantBookingService;
	@Autowired
	private RestaurantImageService restaurantImageService;
	@Autowired
	private RestaurantMenuService restaurantMenuService;
	@Autowired
	private RestaurantQnAService restaurantQnAService; 
	@Autowired
	private WishService wishService;
	@Autowired
	private RestaurantAmenityService restaurantAmenityService;
	@Autowired
	private AttractionService attractionService;
	@Autowired
	private AttractionImageService attractionImageService;
	@Autowired
	private AttractionReviewService attractionReviewService;
	
	// 식당 리스트
	@GetMapping(value = "/restaurantlist")
	public String RestaurantList(Model model,HttpSession session) {
		Long userNo = (Long)session.getAttribute("userNo");
		List<Restaurant> restaurantList = restaurantService.findAll();
		List<RestaurantInsertDto> viewList = new ArrayList<RestaurantInsertDto>();
		
		// 한 페이지당 크기 설정
		Integer page = 1;
		int pageSize = 9;
		
		for (int i = 0; i < restaurantList.size(); i++) {
			if(i >= pageSize*(page-1) && i < pageSize*page) {
				RestaurantInsertDto dto = RestaurantInsertDto.toDto(restaurantList.get(i));
				
				List<RestaurantReview> restaurantReviewList =
						restaurantReviewService.findByRestaurantRestaurantNo(dto.getRestaurantNo());
				
				List<RestaurantReviewInsertDto> restaurantReviewDtoList = new ArrayList<RestaurantReviewInsertDto>();
				
				for (RestaurantReview review : restaurantReviewList) {
					RestaurantReviewInsertDto reviewDto = RestaurantReviewInsertDto.toDto(review);
					restaurantReviewDtoList.add(reviewDto);
				}
				
				dto.setRestaurantReviews(restaurantReviewDtoList);
				
				List<RestaurantImage> imageList = restaurantImageService.findByRestaurantRestaurantNo(dto.getRestaurantNo());
				List<RestaurantImageDto> imageDtoList = new ArrayList<RestaurantImageDto>();
				
				for (RestaurantImage restaurantImage : imageList) {
					RestaurantImageDto restaurantImageDto = RestaurantImageDto.toDto(restaurantImage);
					imageDtoList.add(restaurantImageDto);
				}
				dto.setRestaurantImages(imageDtoList);
				
				boolean existWish = wishService.existByUserNoAndRestaurantNo(userNo, dto.getRestaurantNo());
				dto.setWishBool(existWish);
				
				List<RestaurantCategoryItem> restaurantCategoryItemList =
						restaurantCategoryItemService.findByRestaurantRestaurantNo(dto.getRestaurantNo());
				List<RestaurantCategoryItemDto> restaurantCategoryItemDto = new ArrayList<RestaurantCategoryItemDto>();
				
				for (RestaurantCategoryItem item : restaurantCategoryItemList) {
					RestaurantCategoryItemDto itemDto = RestaurantCategoryItemDto.toDto(item);
					restaurantCategoryItemDto.add(itemDto);
				}
				dto.setRestaurantCategoryItems(restaurantCategoryItemDto);
				viewList.add(dto);
			}
		}
		
		List<RestaurantCategory> restaurantCategories = restaurantCategoryService.findAll();
		
		model.addAttribute("restaurantList", restaurantList);
		model.addAttribute("restaurantCategories", restaurantCategories);
		model.addAttribute("viewList", viewList);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("order", 0);
		return "html/restaurant/restaurant-list";
	}
	
	// 해당 카테고리 식당 리스트
	public String CategoryRestaurantList(Model model) {
		//restaurantCategoryItemService.find
		return "";
	}
	
	// 식당 디테일
	@GetMapping(value = "/restaurantDetail",params = "restaurantNo")
	public String RestaurantDetail(Model model,@RequestParam Long restaurantNo,HttpSession session) {
		Restaurant findRestaurant = restaurantService.findByNo(restaurantNo);
		List<RestaurantReview> restaurantReviews = restaurantReviewService.findByRestaurantRestaurantNoOrderByRrDateDesc(restaurantNo);
		List<RestaurantReviewDto> restaurantReviewDtoList = new ArrayList<RestaurantReviewDto>();
		
		for (RestaurantReview restaurantReview : restaurantReviews) {
			RestaurantReviewDto dto = RestaurantReviewDto.toDto(restaurantReview);
			restaurantReviewDtoList.add(dto);
		}
		
		Collections.sort(restaurantReviewDtoList, Comparator.comparing(RestaurantReviewDto::getRrNo).reversed());
		
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
		
		for (int i = 0; i < restaurantReviewDtoList.size(); i++) {
			int randomIndex = random.nextInt(RANDOM_IMAGE.length);
			String randomImageURL = RANDOM_IMAGE[randomIndex];
			restaurantReviewDtoList.get(i).setRandomImageURL(randomImageURL);
		}
		
		Long userNo = (Long)session.getAttribute("userNo");
		List<RestaurantBooking> restaurantBookings = restaurantBookingService.findByUserinfoUserNo(userNo);
		List<RestaurantBooking> restaurantBookings2 = new ArrayList<RestaurantBooking>();
		
		for (RestaurantBooking restaurantBooking : restaurantBookings) {
			if(restaurantBooking.getRestaurant().getRestaurantNo()==restaurantNo) {
				Long a = ChronoUnit.DAYS.between(restaurantBooking.getRbDate(), LocalDate.now());
				if(a>=1 && a <=3) {
					restaurantBookings2.add(restaurantBooking);
				}
			}
		}
		
		List<RestaurantImage> imageList = restaurantImageService.findByRestaurantRestaurantNo(restaurantNo);
		List<RestaurantImageDto> imageDtoList = new ArrayList<RestaurantImageDto>();
		
		for (RestaurantImage restaurantImage : imageList) {
			RestaurantImageDto restaurantImageDto = RestaurantImageDto.toDto(restaurantImage);
			imageDtoList.add(restaurantImageDto);
		}
		
		List<RestaurantReview> findReviews = 
				restaurantReviewService.findByUserinfoUserNoAndRestaurantRestaurantNo(userNo, restaurantNo);
		List<RestaurantReview> findReviews2 = new ArrayList<RestaurantReview>();
		
		for (RestaurantReview restaurantReview : findReviews) {
			if(restaurantReview.getRestaurant().getRestaurantNo()==restaurantNo) {
				Long a = ChronoUnit.DAYS.between(restaurantReview.getRrDate(), LocalDate.now());
				if(a>=1 && a <=3) {
					findReviews2.add(restaurantReview);
				}
			}
		}
		
		boolean existWish = wishService.existByUserNoAndRestaurantNo(userNo, restaurantNo);
		
		List<RestaurantAmenity> restaurantAmenityList =
				restaurantAmenityService.findByRestaurantRestaurantNo(restaurantNo);
		List<RestaurantAmenityDto> restaurantAmenityDtoList = new ArrayList<RestaurantAmenityDto>();
		for (RestaurantAmenity restaurantAmenity : restaurantAmenityList) {
			RestaurantAmenityDto restaurantAmenityDto = RestaurantAmenityDto.toDto(restaurantAmenity);
			restaurantAmenityDtoList.add(restaurantAmenityDto);
		}
		
		// 리뷰 5점,4점,3점,2점,1점 구분
		List<RestaurantReview> restaurantReviewsScore5 = new ArrayList<RestaurantReview>();
		List<RestaurantReview> restaurantReviewsScore4 = new ArrayList<RestaurantReview>();
		List<RestaurantReview> restaurantReviewsScore3 = new ArrayList<RestaurantReview>();
		List<RestaurantReview> restaurantReviewsScore2 = new ArrayList<RestaurantReview>();
		List<RestaurantReview> restaurantReviewsScore1 = new ArrayList<RestaurantReview>();
		
		for (RestaurantReview restaurantReview : restaurantReviews) {
			if(restaurantReview.getRrStar() == 5) {
				restaurantReviewsScore5.add(restaurantReview);
			}
			if(restaurantReview.getRrStar() == 4) {
				restaurantReviewsScore4.add(restaurantReview);
			}
			if(restaurantReview.getRrStar() == 3) {
				restaurantReviewsScore3.add(restaurantReview);
			}
			if(restaurantReview.getRrStar() == 2) {
				restaurantReviewsScore2.add(restaurantReview);
			}
			if(restaurantReview.getRrStar() == 1) {
				restaurantReviewsScore1.add(restaurantReview);
			}
		}
		
		List<Double> gaugeList = new ArrayList<Double>();
		Double score5Gauge = ((double)restaurantReviewsScore5.size() / (double)restaurantReviews.size()) * 100;
		Double score4Gauge = ((double)restaurantReviewsScore4.size() / (double)restaurantReviews.size()) * 100;
		Double score3Gauge = ((double)restaurantReviewsScore3.size() / (double)restaurantReviews.size()) * 100;
		Double score2Gauge = ((double)restaurantReviewsScore2.size() / (double)restaurantReviews.size()) * 100;
		Double score1Gauge = ((double)restaurantReviewsScore1.size() / (double)restaurantReviews.size()) * 100;
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
		
		// 예약갯수 , 리뷰개수.....
		if( (restaurantBookings2.size() > 0) && (restaurantBookings2.size() > findReviews2.size())) {
			// 리뷰 쓰는칸 숨김/보임
			model.addAttribute("reviewInputShow", true);
		}else {
			model.addAttribute("reviewInputShow", false);
		}
		
		/******************** 명소 추천 ********************/
		String restaurantAddress = restaurantService.findByNo(restaurantNo).getRestaurantAddress();
		String[] restaurantAddressParts = restaurantAddress.split(" ");
		String restaurantAddressPart = restaurantAddressParts[2];
		
		List<Attraction> attractionList = attractionService.findAll();
		List<String> attractionAddressPartList = new ArrayList<String>();
		List<AttractionDto> recommendList = new ArrayList<AttractionDto>(); 
		
		boolean attractionExistWish = false;
		
		for (Attraction attraction : attractionList) {
			String attractionAddress = attraction.getAttractionAddress();
			String[] attractionAddressParts = attractionAddress.split(" ");
			
			if (attractionAddressParts.length >= 3) {
				String attractionAddressPart = attractionAddressParts[2];
				attractionAddressPartList.add(attractionAddressPart);
				
				if (attractionAddressPart.equals(restaurantAddressPart)) {
					AttractionDto dto = AttractionDto.toDto(attraction);
					
					List<AttractionImage> attractionImageList = attractionImageService.findByAttractionAttractionNo(attraction.getAttractionNo());
					List<AttractionImageDto> attractionImageDtoList = new ArrayList<AttractionImageDto>();
					
					for (AttractionImage attractionImage : attractionImageList) {
						AttractionImageDto attractionImageDto = AttractionImageDto.toDto(attractionImage);
						attractionImageDtoList.add(attractionImageDto);
					}
					
					List<AttractionReview> attractionReviewList = attractionReviewService.findByAttractionAttractionNo(attraction.getAttractionNo());
					List<AttractionReviewDto> attractionReviewDtoList = new ArrayList<AttractionReviewDto>();
					
					for (AttractionReview attractionReview : attractionReviewList) {
						AttractionReviewDto attractionReviewDto2 = AttractionReviewDto.toDto(attractionReview);
						attractionReviewDtoList.add(attractionReviewDto2);
						
					}
					
					/******************** 명소 위시 ********************/
					attractionExistWish = wishService.existByUserNoAndAttractionNo(userNo, attraction.getAttractionNo());
					
					dto.setAttractionImageDto(attractionImageDtoList);
					dto.setAttractionReviewDto(attractionReviewDtoList);
					recommendList.add(dto);
				}
			}
		}
		
		List<RestaurantMenu> restaurantMenuList = restaurantMenuService.findByRestaurantRestaurantNo(restaurantNo);
		List<RestaurantQnA> restaurantQnAList = restaurantQnAService.findByRestaurantRestaurantNo(restaurantNo);
		
		List<RestaurantBooking> bookingList = restaurantBookingService.findByRestaurantRestaurantNo(restaurantNo);
		
		List<LocalDate> startDate = new ArrayList<LocalDate>();
		List<LocalDate> endDate = new ArrayList<LocalDate>();
		
		for (RestaurantBooking restaurantBooking : bookingList) {
			LocalDate date1 = restaurantBooking.getRbDate().minusDays(1);
			LocalDate date2 = restaurantBooking.getRbDate();
			startDate.add(date1);
			endDate.add(date2);
		}
		
		List<String> timeList = new ArrayList<String>();
		for (RestaurantBooking restaurantBooking : bookingList) {
			if(restaurantBooking.getRbDate().equals(LocalDate.now())) {
				String time = restaurantBooking.getRbTime();
				timeList.add(time);
			}
		}
		
		model.addAttribute("findRestaurant", findRestaurant);
		//model.addAttribute("restaurantReviews", restaurantReviews);
		model.addAttribute("restaurantReviews", restaurantReviewDtoList);
		model.addAttribute("imageDtoList", imageDtoList);
		model.addAttribute("existWish", existWish);
		model.addAttribute("restaurantAmenityDtoList", restaurantAmenityDtoList);
		model.addAttribute("restaurantReviewsScore5", restaurantReviewsScore5);
		model.addAttribute("restaurantReviewsScore4", restaurantReviewsScore4);
		model.addAttribute("restaurantReviewsScore3", restaurantReviewsScore3);
		model.addAttribute("restaurantReviewsScore2", restaurantReviewsScore2);
		model.addAttribute("restaurantReviewsScore1", restaurantReviewsScore1);
		model.addAttribute("gaugeList", gaugeList);
		model.addAttribute("recommendList", recommendList);
		model.addAttribute("attractionExistWish", attractionExistWish);
		model.addAttribute("restaurantMenuList", restaurantMenuList);
		model.addAttribute("restaurantQnAList", restaurantQnAList);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		
		return "html/restaurant/restaurant-single-v2";
	}
	
}
