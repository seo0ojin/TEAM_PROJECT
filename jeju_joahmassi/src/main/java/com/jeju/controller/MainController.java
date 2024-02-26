package com.jeju.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jeju.dto.AttractionCategoryDto;
import com.jeju.dto.AttractionDto;
import com.jeju.dto.AttractionImageDto;
import com.jeju.dto.AttractionReviewDto;
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
import com.jeju.entity.HotelImage;
import com.jeju.entity.HotelReview;
import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantCategory;
import com.jeju.entity.RestaurantCategoryItem;
import com.jeju.entity.RestaurantImage;
import com.jeju.entity.RestaurantReview;
import com.jeju.service.AttractionCategoryItemService;
import com.jeju.service.AttractionCategoryService;
import com.jeju.service.AttractionImageService;
import com.jeju.service.AttractionReviewService;
import com.jeju.service.AttractionService;
import com.jeju.service.HotelAmenityService;
import com.jeju.service.HotelBookingService;
import com.jeju.service.HotelCategoryItemService;
import com.jeju.service.HotelCategoryService;
import com.jeju.service.HotelImageService;
import com.jeju.service.HotelQnAService;
import com.jeju.service.HotelReviewService;
import com.jeju.service.HotelService;
import com.jeju.service.RestaurantAmenityService;
import com.jeju.service.RestaurantBookingService;
import com.jeju.service.RestaurantCategoryItemService;
import com.jeju.service.RestaurantCategoryService;
import com.jeju.service.RestaurantImageService;
import com.jeju.service.RestaurantMenuService;
import com.jeju.service.RestaurantQnAService;
import com.jeju.service.RestaurantReviewService;
import com.jeju.service.RestaurantService;
import com.jeju.service.UserinfoService;
import com.jeju.service.WishService;

@Controller
public class MainController {

	@Autowired
	private HotelService hotelService;
	@Autowired
	private HotelReviewService hotelReviewService;
	@Autowired
	private HotelImageService hotelImageService;
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private RestaurantReviewService restaurantReviewService;
	@Autowired
	private RestaurantImageService restaurantImageService;
	@Autowired
	private AttractionService attractionService;
	@Autowired
	private AttractionReviewService attractionReviewService;
	@Autowired
	private AttractionImageService attractionImageService;
	
	
	@GetMapping("/")
	public String index(Model model) {
		
		/********************************************************* 호텔 추천 리스트 ***************************************************************/

		List<Hotel> hotelList = hotelService.findHotelOrderByBookingCountDesc();
		List<HotelDto> viewList = new ArrayList<HotelDto>();
		
		for (int i = 0; i < hotelList.size(); i++) {

			Hotel hotel = hotelList.get(i);

			/************************** 리뷰 갯수 **************************/

			List<HotelReview> reviewList = hotelReviewService.findByHotelHotelNo(hotel.getHotelNo());
			List<HotelReviewDto> reviewDtoList = new ArrayList<HotelReviewDto>();

			for (HotelReview hotelReview : reviewList) {
				HotelReviewDto hotelReviewDto2 = HotelReviewDto.toDto(hotelReview);
				reviewDtoList.add(hotelReviewDto2);
			}

			/************************** 호텔 평균 별점 **************************/

			double totStars = 0.0;

			// 모든 리뷰의 별점으로 평균 별점 계산
			for (HotelReviewDto review : reviewDtoList) {
				totStars += review.getHrStar();
			}

			double averageStars = 0.0;

			if (!reviewDtoList.isEmpty()) {
				double avgStars = totStars / reviewDtoList.size();
				// 소수점 첫번째 자리까지만 계산해 주는 코드
				averageStars = Math.round(avgStars * 10.0) / 10.0;
				// 호텔 별점(hotelStar)에 set
				hotel.setHotelStar(averageStars);
				hotelService.updateHotel(hotel);
			}
			
			/**************************대표 이미지**************************/
			
			HotelDto hotelDto = HotelDto.toDto(hotel);
			
			List<HotelImage> imageList = hotelImageService.findByHotelHotelNo(hotelDto.getHotelNo());
			List<HotelImageDto> imageDtoList = new ArrayList<HotelImageDto>();
			
			for (HotelImage hotelImage : imageList) {
				HotelImageDto hotelImageDto = HotelImageDto.toDto(hotelImage);
				imageDtoList.add(hotelImageDto);
			}
			
			hotelDto.setHotelReviewDto(reviewDtoList);
			hotelDto.setHotelStar(averageStars);
			hotelDto.setHotelImageDto(imageDtoList);
			viewList.add(hotelDto);
		}
		
		model.addAttribute("hotelList", hotelList);
		model.addAttribute("viewList", viewList);
		
		
		/********************************************************* 식당 추천 리스트 ***************************************************************/
		
		List<Restaurant> restaurantList = restaurantService.findAllByBookingCountDesc();
		List<RestaurantInsertDto> restaurantViewList = new ArrayList<RestaurantInsertDto>();
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>"+restaurantList);
		
		for (int i = 0; i < restaurantList.size(); i++) {

			RestaurantInsertDto dto = RestaurantInsertDto.toDto(restaurantList.get(i));

			List<RestaurantReview> restaurantReviewList = restaurantReviewService
					.findByRestaurantRestaurantNo(dto.getRestaurantNo());

			List<RestaurantReviewInsertDto> restaurantReviewDtoList = new ArrayList<RestaurantReviewInsertDto>();

			for (RestaurantReview review : restaurantReviewList) {
				RestaurantReviewInsertDto reviewDto = RestaurantReviewInsertDto.toDto(review);
				restaurantReviewDtoList.add(reviewDto);
			}

			dto.setRestaurantReviews(restaurantReviewDtoList);

			List<RestaurantImage> imageList = restaurantImageService
					.findByRestaurantRestaurantNo(dto.getRestaurantNo());
			List<RestaurantImageDto> imageDtoList = new ArrayList<RestaurantImageDto>();

			for (RestaurantImage restaurantImage : imageList) {
				RestaurantImageDto restaurantImageDto = RestaurantImageDto.toDto(restaurantImage);
				imageDtoList.add(restaurantImageDto);
			}
			dto.setRestaurantImages(imageDtoList);

			restaurantViewList.add(dto);
		}
		
		model.addAttribute("restaurantList", restaurantList);
		model.addAttribute("restaurantViewList", restaurantViewList);
		
		
		/********************************************************* 명소 추천 리스트 ***************************************************************/
		
		List<Attraction> attractionList = attractionService.findAllByOrderByAttractionStarDesc();
		List<AttractionDto> attractionViewList = new ArrayList<AttractionDto>();
		
		
		
		for (int i = 0; i < attractionList.size(); i++) {

			Attraction attraction = attractionList.get(i);

			List<AttractionReview> reviewList = attractionReviewService
					.findByAttractionAttractionNo(attraction.getAttractionNo());
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

			List<AttractionImage> imageList = attractionImageService
					.findByAttractionAttractionNo(attraction.getAttractionNo());
			List<AttractionImageDto> imageDtoList = new ArrayList<AttractionImageDto>();

			for (AttractionImage attractionImage : imageList) {
				AttractionImageDto attractionImageDto = AttractionImageDto.toDto(attractionImage);
				imageDtoList.add(attractionImageDto);
			}

			AttractionDto attractionDto = AttractionDto.toDto(attraction);
			attractionDto.setAttractionReviewDto(reviewDtoList);
			attractionDto.setAttractionStar(averageStars);
			attractionDto.setAttractionImageDto(imageDtoList);
			attractionViewList.add(attractionDto);
		}
		
		model.addAttribute("attractionList", attractionList);
		model.addAttribute("attractionViewList", attractionViewList);

		return "html/home/home-v3"; 
	}
	
	@GetMapping("/account")
	public String Myaccount() {
		return "html/home/my-account"; 
	}
	@GetMapping("/test")
	public String test() {
		return "html/test"; 
	}
	
	
}
