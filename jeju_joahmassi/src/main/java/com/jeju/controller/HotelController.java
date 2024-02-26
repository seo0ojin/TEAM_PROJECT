package com.jeju.controller;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeju.dto.AttractionDto;
import com.jeju.dto.AttractionImageDto;
import com.jeju.dto.AttractionReviewDto;
import com.jeju.dto.HotelAmenityDto;
import com.jeju.dto.HotelBookingDto;
import com.jeju.dto.HotelCategoryItemDto;
import com.jeju.dto.HotelDto;
import com.jeju.dto.HotelImageDto;
import com.jeju.dto.HotelQnAPageDto;
import com.jeju.dto.HotelReviewDto;
import com.jeju.dto.RestaurantInsertDto;
import com.jeju.dto.RestaurantListDto;
import com.jeju.dto.RestaurantReviewDto;
import com.jeju.entity.Attraction;
import com.jeju.entity.AttractionImage;
import com.jeju.entity.AttractionReview;
import com.jeju.entity.Hotel;
import com.jeju.entity.HotelAmenity;
import com.jeju.entity.HotelBooking;
import com.jeju.entity.HotelCategory;
import com.jeju.entity.HotelCategoryItem;
import com.jeju.entity.HotelImage;
import com.jeju.entity.HotelQnA;
import com.jeju.entity.HotelReview;
import com.jeju.entity.RestaurantBooking;
import com.jeju.entity.RestaurantReview;
import com.jeju.entity.Userinfo;
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
import com.jeju.service.UserinfoService;
import com.jeju.service.WishService;

import groovyjarjarantlr4.v4.parse.ANTLRParser.parserRule_return;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	@Autowired
	private HotelReviewService hotelReviewService;
	@Autowired
	private HotelBookingService hotelBookingService;
	@Autowired
	private HotelCategoryService hotelCategoryService;
	@Autowired
	private HotelCategoryItemService hotelCategoryItemService;
	@Autowired
	private HotelImageService hotelImageService;
	@Autowired
	private HotelAmenityService hotelAmenityService;
	@Autowired
	private HotelQnAService hotelQnAService;
	@Autowired
	private WishService wishService;
	@Autowired
	private AttractionService attractionService;
	@Autowired
	private AttractionImageService attractionImageService;
	@Autowired
	private AttractionReviewService attractionReviewService;
	@Autowired
	private UserinfoService userinfoService;

	
	@GetMapping(value = "/hotelList")
	public String hotelList(Model model, HttpSession session) {
		
		List<Hotel> hotelList = hotelService.findAllHotels();
		List<HotelDto> viewList = new ArrayList<HotelDto>();
		
		/**************************페이징**************************/
		
		Integer page = 1;
		int pageSize = 9;
		
		for (int i = 0; i < hotelList.size(); i++) {
			if (i >= pageSize * (page - 1) && i < pageSize * page) {
				
				Hotel hotel = hotelList.get(i);
				
				/**************************리뷰 갯수**************************/
				
				List<HotelReview> reviewList = hotelReviewService.findByHotelHotelNo(hotel.getHotelNo());
				List<HotelReviewDto> reviewDtoList = new ArrayList<HotelReviewDto>();
				
				for (HotelReview hotelReview : reviewList) {
					HotelReviewDto hotelReviewDto2 = HotelReviewDto.toDto(hotelReview);
					reviewDtoList.add(hotelReviewDto2);
				}
				
				/**************************호텔 평균 별점**************************/
				
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
				
				/**************************호텔 카테고리**************************/
				
				HotelDto hotelDto = HotelDto.toDto(hotel);
				List<HotelCategoryItem> hotelCategoryItem = hotelCategoryItemService.findByHotelHotelNo(hotelDto.getHotelNo());
				List<HotelCategoryItemDto> hotelCategoryItemDto = new ArrayList<HotelCategoryItemDto>();
				
				for (HotelCategoryItem item : hotelCategoryItem) {
					HotelCategoryItemDto dto = HotelCategoryItemDto.toDto(item);
					hotelCategoryItemDto.add(dto);
				}
				
				/**************************대표 이미지**************************/
				
				List<HotelImage> imageList = hotelImageService.findByHotelHotelNo(hotelDto.getHotelNo());
				List<HotelImageDto> imageDtoList = new ArrayList<HotelImageDto>();
				
				for (HotelImage hotelImage : imageList) {
					HotelImageDto hotelImageDto = HotelImageDto.toDto(hotelImage);
					imageDtoList.add(hotelImageDto);
				}
				
				/**************************위시 추가**************************/
				
				Long userNo = (Long)session.getAttribute("userNo");
				
				boolean existWish = wishService.existByUserNoAnHotelNo(userNo, hotelDto.getHotelNo());
				hotelDto.setWishBool(existWish);
				
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
		
		return "html/hotels/hotel-list";
	}
	
	@GetMapping(value = "/hotelDetail", params = "hotelNo")
	public String hotelDetail(@RequestParam Long hotelNo, Model model, HttpSession session) {
		Long userNo = (Long)session.getAttribute("userNo");
		Hotel find = hotelService.findByHotelNo(hotelNo);

		List<HotelReview> reviewList = hotelReviewService.findByHotelHotelNoOrderByHrNoDesc(hotelNo);
		System.out.println("순서 왜 이 모양이나고 =========================" +reviewList);
		List<HotelReviewDto> hotelReviewDtoList = new ArrayList<HotelReviewDto>();

		for (HotelReview hotelReview : reviewList) {
			HotelReviewDto dto = HotelReviewDto.toDto(hotelReview);
			hotelReviewDtoList.add(dto);
			
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

		for (int i = 0; i < hotelReviewDtoList.size(); i++) {
			int randomIndex = random.nextInt(RANDOM_IMAGE.length);
			String randomImageURL = RANDOM_IMAGE[randomIndex];
			hotelReviewDtoList.get(i).setRandomImageURL(randomImageURL);
		}
		
		double totStars = 0.0;
		double avgStars = 0.0;

		for (HotelReview review : reviewList) {
			totStars += review.getHrStar();
		}

		if (!reviewList.isEmpty()) {
			avgStars = totStars / reviewList.size();
		}

		double averageStars = Math.round(avgStars * 10.0) / 10.0;
		
		/**************************상품 디테일 이미지**************************/
		
		List<HotelImage> imageList = hotelImageService.findByHotelHotelNo(hotelNo);
		List<HotelImageDto> imageDtoList = new ArrayList<HotelImageDto>();
		
		for (HotelImage hotelImage : imageList) {
			HotelImageDto hotelImageDto = HotelImageDto.toDto(hotelImage);
			imageDtoList.add(hotelImageDto);
		}
		
		
		List<HotelAmenity> hotelAmenityList = hotelAmenityService.findByHotelHotelNo(hotelNo);
		List<HotelAmenityDto> hotelAmenityDtoList = new ArrayList<HotelAmenityDto>();
		
		for (HotelAmenity hotelAmenity : hotelAmenityList) {
			HotelAmenityDto hotelAmenityDto = HotelAmenityDto.toDto(hotelAmenity);
			hotelAmenityDtoList.add(hotelAmenityDto);
		}
		
		// 리뷰 5점,4점,3점,2점,1점 구분
		List<HotelReview> hotelReviewsScore5 = new ArrayList<HotelReview>();
		List<HotelReview> hotelReviewsScore4 = new ArrayList<HotelReview>();
		List<HotelReview> hotelReviewsScore3 = new ArrayList<HotelReview>();
		List<HotelReview> hotelReviewsScore2 = new ArrayList<HotelReview>();
		List<HotelReview> hotelReviewsScore1 = new ArrayList<HotelReview>();

		for (HotelReview hotelReview : reviewList) {
			if (hotelReview.getHrStar() == 5) {
				hotelReviewsScore5.add(hotelReview);
			}
			if (hotelReview.getHrStar() == 4) {
				hotelReviewsScore4.add(hotelReview);
			}
			if (hotelReview.getHrStar() == 3) {
				hotelReviewsScore3.add(hotelReview);
			}
			if (hotelReview.getHrStar() == 2) {
				hotelReviewsScore2.add(hotelReview);
			}
			if (hotelReview.getHrStar() == 1) {
				hotelReviewsScore1.add(hotelReview);
			}
		}

		List<Double> gaugeList = new ArrayList<Double>();
		Double score5Gauge = ((double) hotelReviewsScore5.size() / (double) reviewList.size()) * 100;
		Double score4Gauge = ((double) hotelReviewsScore4.size() / (double) reviewList.size()) * 100;
		Double score3Gauge = ((double) hotelReviewsScore3.size() / (double) reviewList.size()) * 100;
		Double score2Gauge = ((double) hotelReviewsScore2.size() / (double) reviewList.size()) * 100;
		Double score1Gauge = ((double) hotelReviewsScore1.size() / (double) reviewList.size()) * 100;
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
		
		
		
		List<HotelReview> reviewList2 = hotelReviewService.findByUserinfoUserNoAndHotelHotelNo(userNo, hotelNo);
		List<HotelReviewDto> reviewDto = new ArrayList<HotelReviewDto>();
		
		for (HotelReview hotelReview : reviewList2) {
			if(hotelReview.getHotel().getHotelNo()==hotelNo) {
				Long a = ChronoUnit.DAYS.between(hotelReview.getHrDate(), LocalDate.now());
				if(a>=0 && a <=3) {
					HotelReviewDto dto = HotelReviewDto.toDto(hotelReview);
					reviewDto.add(dto);
				}
			}
		}
		
		boolean existWish = wishService.existByUserNoAnHotelNo(userNo, find.getHotelNo());
		
		List<HotelBooking> hotelBookings = hotelBookingService.findByUserinfoUserNo(userNo);
		List<HotelBookingDto> hotelBookingDto = new ArrayList<HotelBookingDto>();

		for (HotelBooking hotelBooking : hotelBookings) {
			if (hotelBooking.getHotel().getHotelNo() == hotelNo) {
				Long a = ChronoUnit.DAYS.between(hotelBooking.getHbCheckout(), LocalDate.now());
				if(a>=1 && a <=3) {
					HotelBookingDto bookingDto = HotelBookingDto.toDto(hotelBooking);
					hotelBookingDto.add(bookingDto);
				}
			}
		}
		
		// 예약갯수 , 리뷰개수.....
		if ((hotelBookingDto.size() > 0) && (hotelBookingDto.size() > reviewDto.size())) {
			// 리뷰 쓰는칸 숨김/보임
			model.addAttribute("reviewInputShow", true);
		} else {
			model.addAttribute("reviewInputShow", false);
		}
		
		/******************** 명소 추천 ********************/
		String hotelLocal = hotelService.findByHotelNo(hotelNo).getHotelLocal();
		String[] hotleLocalParts = hotelLocal.split(" ");
		String hotelLocalPart = hotleLocalParts[1];
		
		List<Attraction> attractionList = attractionService.findAll();
		List<String> attractionAddressPartList = new ArrayList<String>();
		List<AttractionDto> recommendList = new ArrayList<AttractionDto>(); 
		
		boolean attractionExistWish = false;
		
		for (Attraction attraction : attractionList) {
			String attractionAddress = attraction.getAttractionAddress();
			String[] attractionAddressParts = attractionAddress.split(" ");
			
			if (attractionAddressParts.length >= 2) {
				String attractionAddressPart = attractionAddressParts[2];
				attractionAddressPartList.add(attractionAddressPart);
				
				if (attractionAddressPart.equals(hotelLocalPart)) {
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
		
		/******************** qna 리스트 ********************/
		List<HotelQnA> hotelQnAList = hotelQnAService.findByHotelHotelNoOrderByQnaNoDesc(hotelNo);
		List<HotelQnAPageDto> hotelQnAListPage = new ArrayList<HotelQnAPageDto>();
		List<HotelQnAPageDto> previousList = new ArrayList<HotelQnAPageDto>();
		List<HotelQnAPageDto> hotelQnANextList = new ArrayList<HotelQnAPageDto>();
		
		Integer page = 1;
		int pageSize = 10;
		double totalPage = (double)hotelQnAList.size() / (double)pageSize;
		totalPage = Math.ceil(totalPage);
		int intTotalPage = (int) totalPage;
		
		if(hotelQnAList.size() > 0) {
			for (int i = 0; i < hotelQnAList.size(); i++) {
				if(i >= pageSize*(page) && i < pageSize*(page+1)) {
					HotelQnAPageDto toDto = HotelQnAPageDto.toDto(hotelQnAList.get(i));
					hotelQnANextList.add(toDto);
				}
			}
			
			for (int i = 0; i < hotelQnAList.size(); i++) {
				if(i >= pageSize*(page-1) && i < pageSize*page) {
					HotelQnAPageDto dto = HotelQnAPageDto.toDto(hotelQnAList.get(i));
					hotelQnAListPage.add(dto);		
				}
			}
		}
		
		List<HotelBooking> bookingList = hotelBookingService.findByHotelHotelNo(hotelNo);
		List<LocalDate> startDate = new ArrayList<LocalDate>();
		List<LocalDate> endDate = new ArrayList<LocalDate>();
		for (HotelBooking hotelBooking : bookingList) {
			LocalDate date1 = hotelBooking.getHbCheckin().minusDays(1);
			LocalDate date2 = hotelBooking.getHbCheckout().minusDays(1);
			startDate.add(date1);
			endDate.add(date2);
		}
		
		model.addAttribute("hotel", find);
		model.addAttribute("reviewList", hotelReviewDtoList);
		//model.addAttribute("hotelReviews", hotelReviewDtoList);
		model.addAttribute("avgStars", avgStars);
		model.addAttribute("averageStars", averageStars);
		model.addAttribute("imageDtoList", imageDtoList);
		model.addAttribute("hotelAmenityDtoList", hotelAmenityDtoList);
		model.addAttribute("existWish", existWish);
		model.addAttribute("hotelReviewsScore5", hotelReviewsScore5);
		model.addAttribute("hotelReviewsScore4", hotelReviewsScore4);
		model.addAttribute("hotelReviewsScore3", hotelReviewsScore3);
		model.addAttribute("hotelReviewsScore2", hotelReviewsScore2);
		model.addAttribute("hotelReviewsScore1", hotelReviewsScore1);
		model.addAttribute("gaugeList", gaugeList);
		model.addAttribute("recommendList", recommendList);
		model.addAttribute("attractionExistWish", attractionExistWish);
		model.addAttribute("hotelQnAList", hotelQnAListPage);
		model.addAttribute("pageSize",pageSize);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", intTotalPage);
		model.addAttribute("hotelQnANextList", hotelQnANextList);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		
		return "html/hotels/hotel-single-v2";
	}
	
	@GetMapping("/qnaPopup")
	public String qnaPopup(@RequestParam String hotelNo, @RequestParam String qnaNo, Model model,HttpSession session) {
		Hotel hotel = hotelService.findByHotelNo(Long.parseLong(hotelNo));
		String hotelName = hotel.getHotelName();
		String hotelImage = hotel.getHotelImages().get(0).getImageName();
		
		Long userNo = (Long)session.getAttribute("userNo");
		Userinfo findUser = userinfoService.findByUserNo(userNo);
		String userId = findUser.getUserId();
		
		HotelQnA hotelQnA = null;
		if (!qnaNo.equals("0")) {
			// 제목 눌러서 보기
			hotelQnA = hotelQnAService.findByQnANo(Long.parseLong(qnaNo));
			
		} else {
			// 작성하기
			hotelQnA = new HotelQnA();
			hotelQnA.setQnaNo(0L);
			hotelQnA.setQnaName(findUser.getUserName());
			hotelQnA.setUserinfo(findUser);
		}
		
		model.addAttribute("userId", userId);
		model.addAttribute("userNo", userNo);
		model.addAttribute("hotelNo", hotelNo);
		model.addAttribute("hotelName", hotelName);
		model.addAttribute("hotelImage", hotelImage);
		model.addAttribute("hotelQnA", hotelQnA);
		
		return "html/hotels/qnaPopup";
	}

}
