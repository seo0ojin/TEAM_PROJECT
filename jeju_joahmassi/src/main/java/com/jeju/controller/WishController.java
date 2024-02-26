package com.jeju.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeju.dto.AttractionCategoryDto;
import com.jeju.dto.AttractionDto;
import com.jeju.dto.AttractionImageDto;
import com.jeju.dto.AttractionReviewDto;
import com.jeju.dto.HotelCategoryItemDto;
import com.jeju.dto.HotelDto;
import com.jeju.dto.HotelImageDto;
import com.jeju.dto.HotelReviewDto;
import com.jeju.dto.RestaurantCategoryItemDto;
import com.jeju.dto.RestaurantImageDto;
import com.jeju.dto.RestaurantInsertDto;
import com.jeju.dto.RestaurantReviewInsertDto;
import com.jeju.entity.Attraction;
import com.jeju.entity.AttractionCategory;
import com.jeju.entity.AttractionImage;
import com.jeju.entity.AttractionReview;
import com.jeju.entity.Hotel;
import com.jeju.entity.HotelCategory;
import com.jeju.entity.HotelCategoryItem;
import com.jeju.entity.HotelImage;
import com.jeju.entity.HotelReview;
import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantCategory;
import com.jeju.entity.RestaurantCategoryItem;
import com.jeju.entity.RestaurantImage;
import com.jeju.entity.RestaurantReview;
import com.jeju.entity.Wish;
import com.jeju.repository.WishRepository;
import com.jeju.service.AttractionCategoryItemService;
import com.jeju.service.AttractionCategoryService;
import com.jeju.service.AttractionImageService;
import com.jeju.service.AttractionReviewService;
import com.jeju.service.AttractionService;
import com.jeju.service.HotelCategoryItemService;
import com.jeju.service.HotelCategoryService;
import com.jeju.service.HotelImageService;
import com.jeju.service.HotelReviewService;
import com.jeju.service.HotelService;
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

@Controller
public class WishController {

	@Autowired
	private WishService wishService;
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
	private HotelService hotelService;
	@Autowired
	private HotelReviewService hotelReviewService;
	@Autowired
	private HotelCategoryService hotelCategoryService;
	@Autowired
	private HotelCategoryItemService hotelCategoryItemService;
	@Autowired
	private HotelImageService hotelImageService;
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
	
	// 위시 식당 리스트
	@GetMapping(value = "/wishRestaurant",params = "page")
	public String wishRestaurantList(HttpSession session, Model model , @RequestParam Integer page ) throws Exception {
		Long userNo = (Long) session.getAttribute("userNo");
		/*
		if (userNo == null) {
			throw new Exception("로그인 하세요.");
		}
		*/
		List<Wish> restaurantList = wishService.findByUserinfo_UserNoAndWishCategory(userNo,"맛집");
		List<RestaurantInsertDto> viewList = new ArrayList<RestaurantInsertDto>();
		// 한 페이지당 크기 설정
		int pageSize = 9;
		
		for (int i = 0; i < restaurantList.size(); i++) {
			if(i >= pageSize*(page-1) && i < pageSize*page) {
				Restaurant restaurant = restaurantList.get(i).getRestaurant();
				RestaurantInsertDto dto = RestaurantInsertDto.toDto(restaurant);
				
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
		
		model.addAttribute("restaurantList", restaurantList);
		model.addAttribute("viewList", viewList);
		model.addAttribute("page", page);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("order", 0);
		
		return "html/wish/wish-restaurant-list";
	}
	
	// 위시 호텔 리스트
	@GetMapping(value = "/wishHotel",params = "page")
	public String wishHotelList(HttpSession session, Model model , @RequestParam Integer page ) throws Exception {
		Long userNo = (Long) session.getAttribute("userNo");
		/*
		if (userNo == null) {
			throw new Exception("로그인 하세요.");
		}
		*/
		List<Wish> hotelList = wishService.findByUserinfo_UserNoAndWishCategory(userNo,"호텔");
		List<HotelDto> viewList = new ArrayList<HotelDto>();
		
		int pageSize = 9;
		
		for (int i = 0; i < hotelList.size(); i++) {
			if (i >= pageSize * (page - 1) && i < pageSize * page) {
				Hotel hotel = hotelList.get(i).getHotel();
				
				List<HotelReview> reviewList = hotelReviewService.findByHotelHotelNo(hotel.getHotelNo());
				
				List<HotelReviewDto> reviewDtoList = new ArrayList<HotelReviewDto>();
				
				for (HotelReview hotelReview : reviewList) {
					HotelReviewDto hotelReviewDto2 = HotelReviewDto.toDto(hotelReview);
					reviewDtoList.add(hotelReviewDto2);
				}
				
				double totStars = 0.0;
				
				for (HotelReviewDto review : reviewDtoList) {
					totStars += review.getHrStar();
				}
				
				double averageStars = 0.0;
				
				if (!reviewDtoList.isEmpty()) {
					double avgStars = totStars / reviewDtoList.size();
					averageStars = Math.round(avgStars * 10.0) / 10.0;
					
					hotel.setHotelStar(averageStars);
					hotelService.updateHotel(hotel);
				}
				
				HotelDto hotelDto = HotelDto.toDto(hotel);
				List<HotelCategoryItem> hotelCategoryItem = hotelCategoryItemService.findByHotelHotelNo(hotelDto.getHotelNo());
				List<HotelCategoryItemDto> hotelCategoryItemDto = new ArrayList<HotelCategoryItemDto>();
				
				for (HotelCategoryItem item : hotelCategoryItem) {
					HotelCategoryItemDto dto = HotelCategoryItemDto.toDto(item);
					hotelCategoryItemDto.add(dto);
				}
				
				/*************************이미지***************************/
				List<HotelImage> imageList = hotelImageService.findByHotelHotelNo(hotelDto.getHotelNo());
				System.out.println(">>>>>>>>>>>"+imageList);
				List<HotelImageDto> imageDtoList = new ArrayList<HotelImageDto>();
				
				for (HotelImage hotelImage : imageList) {
					HotelImageDto hotelImageDto = HotelImageDto.toDto(hotelImage);
					imageDtoList.add(hotelImageDto);
				}
				
				hotelDto.setHotelReviewDto(reviewDtoList);
				hotelDto.setHotelStar(averageStars);
				hotelDto.setHotelCategoryItems(hotelCategoryItemDto);
				hotelDto.setHotelImageDto(imageDtoList);
				viewList.add(hotelDto);
				
			}
		}
		
		List<HotelCategory> hotelCategories = hotelCategoryService.findAll();

		model.addAttribute("hotelList", hotelList);
		model.addAttribute("hotelCategories", hotelCategories);
		model.addAttribute("viewList", viewList);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("order", 0);
		
		return "html/wish/wish-hotel-list";
	}
	
	// 위시 명소 리스트
	@GetMapping(value = "/wishAttraction",params = "page")
	public String wishAttractionList(HttpSession session, Model model , @RequestParam Integer page ) throws Exception {
		Long userNo = (Long) session.getAttribute("userNo");
		/*
		if (userNo == null) {
			throw new Exception("로그인 하세요.");
		}
		*/
		List<Wish> attractionList = wishService.findByUserinfo_UserNoAndWishCategory(userNo,"명소");
		List<AttractionDto> viewList = new ArrayList<AttractionDto>();
		
		int pageSize = 9;
		
		for (int i = 0; i < attractionList.size(); i++) {
			if (i >= pageSize * (page - 1) && i < pageSize * page) {
				Attraction attraction = attractionList.get(i).getAttraction();
				
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
		
		return "html/wish/wish-attraction-list";
	}
}
