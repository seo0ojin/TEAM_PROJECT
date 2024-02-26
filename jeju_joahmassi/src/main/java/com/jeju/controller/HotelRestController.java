package com.jeju.controller;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jeju.dto.HotelCategoryDto;
import com.jeju.dto.HotelCategoryItemDto;
import com.jeju.dto.HotelDto;
import com.jeju.dto.HotelImageDto;
import com.jeju.dto.HotelReviewDto;
import com.jeju.dto.HotelSearchDto;
import com.jeju.dto.HotelUpdateDto;
import com.jeju.dto.RestaurantListDto;
import com.jeju.entity.Hotel;
import com.jeju.entity.HotelCategory;
import com.jeju.entity.HotelCategoryItem;
import com.jeju.entity.HotelImage;
import com.jeju.entity.HotelReview;
import com.jeju.entity.Restaurant;
import com.jeju.service.HotelCategoryItemService;
import com.jeju.service.HotelCategoryService;
import com.jeju.service.HotelImageService;
import com.jeju.service.HotelReviewService;
import com.jeju.service.HotelService;
import com.jeju.service.WishService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/hotel")
public class HotelRestController {

	@Autowired
	private HotelService hotelService;
	@Autowired
	private HotelCategoryService hotelCategoryService;
	@Autowired
	private HotelCategoryItemService hotelCategoryItemService;
	@Autowired
	private HotelImageService hotelImageService;
	@Autowired
	private HotelReviewService hotelReviewService;
	@Autowired
	private WishService wishService;
	
	@Operation(summary = "호텔 추가")
	@GetMapping("/insert")
	public ResponseEntity<HotelDto> insertHotel(HotelDto dto) throws Exception{
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		Hotel insert = hotelService.insertHotel(HotelDto.toEntity(dto));
		HotelCategoryItem item = HotelCategoryItem.builder()
				.hotel(insert)
				.hotelCategory(hotelCategoryService.findByNo(dto.getHcNo()))
				.build();
		hotelCategoryItemService.insert(item);
		
		List<String> imageNames = dto.getImageName();
		for (String string : imageNames) {
			hotelImageService.insert(HotelImage.builder().imageName(string).hotel(insert).build());
		}
		
		return new ResponseEntity<HotelDto>(dto, httpHeaders, HttpStatus.CREATED);
	}
	
	@Operation(summary = "호텔 번호로 삭제 (관리자)")
	@DeleteMapping("/delete/{hotelNo}")
	public ResponseEntity deleteHotel(@PathVariable(name = "hotelNo") Long hotelNo, HttpSession session) throws Exception{
		
		HttpHeaders httpHeaders = new HttpHeaders();
		
		hotelService.deleteByHotelNo(hotelNo);
		
		return new ResponseEntity(httpHeaders, HttpStatus.OK);
	}
	
	
	@Operation(summary = "호텔 번호로 찾기")
	@GetMapping("/{hotelNo}")
	public HotelDto findHotelByNo(@PathVariable(name = "hotelNo") Long hotelNo, HttpSession session) {
		
		Hotel findHotel = hotelService.findByHotelNo(hotelNo);
		
		HotelDto hotelDto = HotelDto.toDto(findHotel);
		
		return hotelDto;
	}
	
	
	@Operation(summary = "호텔 정보 수정")
	@PutMapping("/update")
	public ResponseEntity<HotelUpdateDto> updateHotel(@RequestBody HotelUpdateDto dto){
		
		Hotel find = hotelService.findByHotelNo(dto.getHotelNo());
		if(find != null) {
			hotelService.updateHotel(HotelUpdateDto.toEntity(dto));
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<HotelUpdateDto>(dto, httpHeaders,HttpStatus.OK);
	}
	
	
	@Operation(summary = "호텔 검색 (이름)")
	@PostMapping("/hotelSearchName")
	public ResponseEntity<List<HotelSearchDto>> nameSearch(@RequestBody HotelSearchDto dto) {
		//List<HotelDto> hotelListDto = new ArrayList<HotelDto>();
		List<Hotel> hotels = hotelService.findByHotelNameLike(dto.getHotelName());
		List<HotelSearchDto> hotelList = new ArrayList<HotelSearchDto>();
		
		for (Hotel hotel : hotels) {
			HotelSearchDto hotelDto = HotelSearchDto.toDto(hotel);
			hotelList.add(hotelDto);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<HotelSearchDto>>(hotelList, httpHeaders, HttpStatus.OK);
	}
	
	
	@Operation(summary = "호텔 검색 (지역)")
	@PostMapping("/hotelSearchLocal")
	public ResponseEntity<List<HotelDto>> localSearch(@RequestBody HotelDto dto) {
		
		List<Hotel> hotels = hotelService.findByHotelLocalLike(dto.getHotelLocal());
		List<HotelDto> hotelList = new ArrayList<HotelDto>();
		
		for (Hotel hotel : hotels) {
			HotelDto hotelDto = HotelDto.toDto(hotel);
			hotelList.add(hotelDto);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<HotelDto>>(hotelList, httpHeaders, HttpStatus.OK);
	}
	
	@Operation(summary = "리스트")
	@GetMapping("/hotelList")
	public ResponseEntity<List<HotelDto>> hotelList() {
		List<Hotel> hotels = hotelService.findAllHotels();
		List<HotelDto> hotelDto = new ArrayList<HotelDto>();
		
		for (Hotel hotel : hotels) {
			hotelDto.add(HotelDto.toDto(hotel));
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<HotelDto>>(hotelDto, httpHeaders, HttpStatus.OK);
	}
	

	
	// 페이징
	
	@PostMapping(value = "/list")
	public ResponseEntity<List<HotelDto>> list(@RequestBody HotelDto dto, HttpSession session) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		List<Hotel> hotelList = new ArrayList<>();
		List<HotelDto> viewList = new ArrayList<HotelDto>();
		
		Integer order = dto.getOrder();
		Integer page = dto.getPage();
		Long categoryNo = dto.getCategoryNo();
		
		if (categoryNo == 0 && order == 0) {
			// 인기순 (예약 多)
			hotelList = hotelService.findAllHotels();
		}

		if(dto.getSearchKeyword() == "") {
			// 정렬 체크 O, 카테고리 체크 X
			if (categoryNo < 1) {
	
				if (order == 1) {
					// 인기순 (예약 多)
					hotelList = hotelService.findHotelOrderByBookingCountDesc();
				}
				if (order == 2) {
					// 리뷰많은순
					hotelList = hotelService.findHotelOrderByReviewCountDesc();
				}
				if (order == 3) {
					// 가격높은순
					hotelList = hotelService.findAllByOrderByHotelPriceDesc();
				}
				if (order == 4) {
					// 가격낮은순
					hotelList = hotelService.findAllByOrderByHotelPriceAsc();
				}
				if (order == 5) {
					// 별점높은순
					hotelList = hotelService.findAllByOrderByHotelStarDesc();
				}
			} else {
				// 정렬 체크 O, 카테고리 체크 O
				if (order == 1) {
					// 예약많은순 + 카테고리
					hotelList = hotelService.findByCategoryNoOrderByBookingsDesc(categoryNo);
				}
				if (order == 2) {
					// 리뷰많은순 + 카테고리
					hotelList = hotelService.findByCategoryNoOrderByBookingsDesc(categoryNo);
				}
				if (order == 3) {
					// 가격높은순 + 카테고리
					hotelList = hotelService.findByCategoryNoOrderByPriceDesc(categoryNo);
				}
				if (order == 4) {
					// 가격낮은순 + 카테고리
					hotelList = hotelService.findByCategoryNoOrderByPriceAsc(categoryNo);
				}
				if (order == 5) {
					// 별점순 + 카테고리
					hotelList = hotelService.findByCategoryNoOrderByStars(categoryNo);
				}
			}
			// 정렬 체크 X, 카테고리 체크 O
			if (categoryNo > 0 && order == 0) {
				hotelList = hotelService.findByHotelCategoryItemsHotelCategoryHcNo(categoryNo);
			}
		} else {
			// 검색어 O
			LinkedHashSet<Hotel> findHotelListLinked = new LinkedHashSet<Hotel>();
			List<Hotel> hotelName = new ArrayList<Hotel>();
			List<Hotel> hotelLocal = new ArrayList<Hotel>();
			
			// 카테고리 체크 X, 정렬 체크 X
			if(categoryNo == 0 && order == 0) {
				hotelName = hotelService.findByHotelNameLike(dto.getSearchKeyword());
				hotelLocal = hotelService.findByHotelLocalLike(dto.getSearchKeyword());
			}
			
			// 카테고리 체크 X, 정렬 체크 O
			if(categoryNo < 1) {
				// 예약 많은순
				if(order == 1) {
					hotelName = hotelService.findHotelLikeHotelNameByBookingCountDesc(dto.getSearchKeyword());
				}
				// 리뷰 많은순
				if(order == 2) {
					hotelName = hotelService.findHotelLikeHotelNameOrderByReviewCountDesc(dto.getSearchKeyword());
				}
				// 가격높은순
				if(order == 3) {
					hotelName = hotelService.findHotelLikeHotelNameByOrderByHotelPriceDesc(dto.getSearchKeyword());
					//hotelLocal = hotelService.findHotelLikeHotelLocalByOrderByHotelPriceDesc(dto.getSearchKeyword());

				}
				// 가격낮은순
				if(order == 4) {
					hotelName = hotelService.findHotelLikeHotelNameByOrderByHotelPriceAsc(dto.getSearchKeyword());
				}
				// 별점순
				if(order == 5) {
					hotelName = hotelService.findHotelLikeHotelNameByOrderByHotelStarDesc(dto.getSearchKeyword());
				}
			}else {
				// 카테고리 체크 O, 정렬 체크 O
				// 예약 많은순
				if (order == 1) {
					hotelName = hotelService.findHotelLikeHotelNameByCategoryNoOrderByBookingsDesc(categoryNo, dto.getSearchKeyword());
					//hotelLocal = hotelService.findHotelLikeHotelLocalByCategoryNoOrderByBookingsDesc(categoryNo, dto.getSearchKeyword());
				}
				// 리뷰 많은순
				if (order == 2) {
					hotelName = hotelService.findHotelLikeHotelNameByCategoryNoOrderByReviewsDesc(categoryNo, dto.getSearchKeyword());
					//hotelLocal = hotelService.findHotelLikeHotelLocalByCategoryNoOrderByReviewsDesc(categoryNo, dto.getSearchKeyword());
				}
				// 가격높은순
				if (order == 3) {
					hotelName = hotelService.findHotelLikeHotelNameByCategoryNoOrderByPriceDesc(categoryNo, dto.getSearchKeyword());
					//hotelLocal = hotelService.findHotelLikeHotelLocalByCategoryNoOrderByPriceDesc(categoryNo, dto.getSearchKeyword());
				}
				// 가격낮은순
				if (order == 4) {
					hotelName = hotelService.findHotelLikeHotelNameByCategoryNoOrderByPriceAsc(categoryNo, dto.getSearchKeyword());
					//hotelLocal = hotelService.findHotelLikeHotelLocalByCategoryNoOrderByPriceAsc(categoryNo, dto.getSearchKeyword());
				}
				// 별점순
				if (order == 5) {
					hotelName = hotelService.findHotelLikeHotelNameByCategoryNoOrderByStars(categoryNo, dto.getSearchKeyword());
					//hotelLocal = hotelService.findHotelLikeHotelLocalByCategoryNoOrderByStars(categoryNo, dto.getSearchKeyword());
				}
			}
			
			// 카테고리 O, 정렬 체크 X
			if (categoryNo > 0 && order == 0) {
				hotelName = hotelService.findByHotelCategoryItemsHotelCategoryHcNoAndHotelNameLike(categoryNo, dto.getSearchKeyword());
				//hotelLocal = hotelService.findByHotelCategoryItemsHotelCategoryHcNoAndHotelLocalLike(categoryNo, dto.getSearchKeyword());
			}
			
			for (Hotel hotel : hotelName) {
				findHotelListLinked.add(hotel);
			}
			for (Hotel hotel : hotelLocal) {
				findHotelListLinked.add(hotel);
			}
			
			hotelList = new ArrayList<Hotel>(findHotelListLinked);
		}
		

		if(order == 3) {
			
		}
		
		
		// 한 페이지당 크기 설정
		int pageSize = 9;
		int pageInt = hotelList.size()/pageSize;
		
		List<HotelCategory> categoryList = hotelCategoryService.findAll();
		List<HotelCategoryDto> categoryDtoList = new ArrayList<HotelCategoryDto>();
		for (HotelCategory hotelCategory : categoryList) {
			HotelCategoryDto categoryDto = HotelCategoryDto.toDto(hotelCategory);
			categoryDtoList.add(categoryDto);
		}
		List<HotelDto> previousList = new ArrayList<HotelDto>();
		List<HotelDto> nextList = new ArrayList<HotelDto>();
		if (hotelList.size() > 0) {
			
			for (int i = 0; i < hotelList.size(); i++) {
				if(i >= pageSize*(page-2) && i < pageSize*(page-1)) {
					HotelDto toDto = HotelDto.toDto(hotelList.get(i));
					previousList.add(toDto);
				}
			}
			
			for (int i = 0; i < hotelList.size(); i++) {
				if(i >= pageSize*(page) && i < pageSize*(page+1)) {
					HotelDto toDto = HotelDto.toDto(hotelList.get(i));
					nextList.add(toDto);
				}
			}
			
			for (int i = 0; i < hotelList.size(); i++) {
				if (i >= pageSize * (page - 1) && i < pageSize * page) {

					HotelDto toDto = HotelDto.toDto(hotelList.get(i));

					int reviewSize = hotelList.get(i).getHotelReview().size();

					toDto.setPageSize(pageSize);
					toDto.setPage(pageInt);
					toDto.setCurrentPage(page);
					toDto.setReviewSize(reviewSize);
					toDto.setHotelSize(hotelList.size());
					toDto.setOrder(order);
					toDto.setCategoryNo(categoryNo);
					toDto.setCategoryList(categoryDtoList);
					toDto.setPreviousSize(previousList.size());
					toDto.setNextSize(nextList.size());

					Long userNo = (Long)session.getAttribute("userNo");
					
					boolean existWish = wishService.existByUserNoAnHotelNo(userNo, toDto.getHotelNo());
					toDto.setWishBool(existWish);
					
					/**************************호텔 평균 별점**************************/
					
					List<HotelReview> reviewList = hotelReviewService.findByHotelHotelNo(toDto.getHotelNo());
					List<HotelReviewDto> reviewDtoList = new ArrayList<HotelReviewDto>();
					
					for (HotelReview hotelReview : reviewList) {
						HotelReviewDto hotelReviewDto2 = HotelReviewDto.toDto(hotelReview);
						reviewDtoList.add(hotelReviewDto2);
					}

					for (HotelReview hotelReview : reviewList) {
						if (hotelReview.getHotel().getHotelNo() == dto.getHotelNo()) {
							Long a = ChronoUnit.DAYS.between(hotelReview.getHrDate(), LocalDate.now());
							if (a >= 1 && a <= 3) {
								HotelReviewDto reviewDto = HotelReviewDto.toDto(hotelReview);
								reviewDtoList.add(reviewDto);
							}
						}
					}

					double totStars = 0.0;
					
					// 모든 리뷰의 별점으로 평균 별점 계산
					for (HotelReviewDto review : reviewDtoList) {
						totStars += review.getHrStar();
					}
					
					double averageStars = 0.0;
					
					if (!reviewDtoList.isEmpty()) {
						
						Hotel hotel = hotelList.get(i);
						
						double avgStars = totStars / reviewDtoList.size();
						// 소수점 첫번째 자리까지만 계산해 주는 코드
						averageStars = Math.round(avgStars * 10.0) / 10.0;
						// 호텔 별점(hotelStar)에 set
						hotel.setHotelStar(averageStars);
						hotelService.updateHotel(hotel);
						
						System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+hotel);
					}
					
					
					List<HotelCategoryItem> hotelCategoryItems = hotelCategoryItemService.findByHotelHotelNo(toDto.getHotelNo());
					List<HotelCategoryItemDto> hotelCategoryItemDtos = new ArrayList<HotelCategoryItemDto>();
					for (HotelCategoryItem hotelCategoryItem : hotelCategoryItems) {
						HotelCategoryItemDto itemDto = HotelCategoryItemDto.toDto(hotelCategoryItem);
						HotelCategory hotelCategory = hotelCategoryService.findByNo(itemDto.getHcNo());
						itemDto.setHcName(hotelCategory.getHcName());
						hotelCategoryItemDtos.add(itemDto);
					}
					toDto.setHotelCategoryItems(hotelCategoryItemDtos);

					/************************* 이미지 ***************************/
					List<HotelImage> imageList = hotelImageService.findByHotelHotelNo(toDto.getHotelNo());
					List<HotelImageDto> imageDtoList = new ArrayList<HotelImageDto>();

					for (HotelImage hotelImage : imageList) {
						HotelImageDto hotelImageDto = HotelImageDto.toDto(hotelImage);
						imageDtoList.add(hotelImageDto);
					}
					toDto.setHotelImageDto(imageDtoList);

					viewList.add(toDto);
				}
			}
		} else {
			HotelDto toDto = new HotelDto();

			toDto.setPageSize(pageSize);
			toDto.setPage(pageInt);
			toDto.setCurrentPage(page);
			toDto.setHotelSize(hotelList.size());
			toDto.setOrder(order);
			toDto.setCategoryNo(categoryNo);
			toDto.setCategoryList(categoryDtoList);

			List<HotelCategoryItem> hotelCategoryItems = hotelCategoryItemService.findByHotelHotelNo(toDto.getHotelNo());
			List<HotelCategoryItemDto> hotelCategoryItemDtos = new ArrayList<HotelCategoryItemDto>();
			for (HotelCategoryItem hotelCategoryItem : hotelCategoryItems) {
				HotelCategoryItemDto itemDto = HotelCategoryItemDto.toDto(hotelCategoryItem);
				HotelCategory hotelCategory = hotelCategoryService.findByNo(itemDto.getHcNo());
				itemDto.setHcName(hotelCategory.getHcName());
				hotelCategoryItemDtos.add(itemDto);
			}
			toDto.setHotelCategoryItems(hotelCategoryItemDtos);

			/************************* 이미지 ***************************/
			List<HotelImage> imageList = hotelImageService.findByHotelHotelNo(toDto.getHotelNo());
			List<HotelImageDto> imageDtoList = new ArrayList<HotelImageDto>();

			for (HotelImage hotelImage : imageList) {
				HotelImageDto hotelImageDto = HotelImageDto.toDto(hotelImage);
				imageDtoList.add(hotelImageDto);
			}
			toDto.setHotelImageDto(imageDtoList);
			
			viewList.add(toDto);
		}
		
		
		
		return new ResponseEntity<List<HotelDto>>(viewList, httpHeaders, HttpStatus.OK);
	}
	
	
	@Operation(summary = "호텔 검색 (지역, 이름)")
	@PostMapping("/hotelSearch")
	public ResponseEntity<LinkedHashSet<HotelDto>> hotelSearch(@RequestBody HotelDto dto) {
		
		List<Hotel> localSearch = hotelService.findByHotelLocalLike(dto.getHotelLocal());
		List<Hotel> nameSearch = hotelService.findByHotelNameLike(dto.getHotelName());
		//List<HotelDto> hotelList = new ArrayList<HotelDto>();
		LinkedHashSet<HotelDto> hotelHashSet = new LinkedHashSet<HotelDto>(); 
		
		for (Hotel hotel : localSearch) {
			HotelDto hotelDto = HotelDto.toDto(hotel);
			hotelHashSet.add(hotelDto);
		}
		
		for (Hotel hotel : nameSearch) {
			HotelDto hotelDto = HotelDto.toDto(hotel);
			hotelHashSet.add(hotelDto);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<LinkedHashSet<HotelDto>>(hotelHashSet, httpHeaders, HttpStatus.OK);
	}
	
}
