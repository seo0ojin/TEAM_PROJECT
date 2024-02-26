package com.jeju.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

import com.jeju.dto.HotelDto;
import com.jeju.dto.RestaurantCategoryInsertDto;
import com.jeju.dto.RestaurantCategoryItemDto;
import com.jeju.dto.RestaurantImageDto;
import com.jeju.dto.RestaurantInsertDto;
import com.jeju.dto.RestaurantListDto;
import com.jeju.dto.RestaurantTimeDto;
import com.jeju.dto.RestaurantUpdateDto;
import com.jeju.entity.Hotel;
import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantCategory;
import com.jeju.entity.RestaurantCategoryItem;
import com.jeju.entity.RestaurantImage;
import com.jeju.entity.RestaurantMenu;
import com.jeju.repository.RestaurantRepository;
import com.jeju.service.RestaurantCategoryItemService;
import com.jeju.service.RestaurantCategoryService;
import com.jeju.service.RestaurantImageService;
import com.jeju.service.RestaurantMenuService;
import com.jeju.service.RestaurantService;
import com.jeju.service.WishService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/restaurant")
public class RestaurantRestController {
	@Autowired
	private RestaurantRepository restaurantRepository;
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private RestaurantCategoryService restaurantCategoryService;
	@Autowired
	private RestaurantCategoryItemService restaurantCategoryItemService;
	@Autowired
	private RestaurantImageService restaurantImageService;
	@Autowired
	private RestaurantMenuService restaurantMenuService;
	@Autowired
	private WishService wishService;
	
	@PostMapping("/insert")
	public ResponseEntity<RestaurantInsertDto> insert(@RequestBody RestaurantInsertDto dto) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		Restaurant insertRestaurant = restaurantService.insert(RestaurantInsertDto.toEntity(dto));
		RestaurantCategoryItem item = RestaurantCategoryItem.builder()
								.restaurant(insertRestaurant)
								.restaurantCategory(restaurantCategoryService.findByNo(dto.getRcNo()))
								.build();
		restaurantCategoryItemService.insert(item);
		List<String> imageNames = dto.getImageName();
		for (String string : imageNames) {
			restaurantImageService.insert(RestaurantImage.builder().imageName(string).restaurant(insertRestaurant).build());
		}
		
		return new ResponseEntity<RestaurantInsertDto>(dto, httpHeaders, HttpStatus.CREATED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<RestaurantUpdateDto> update(@RequestBody RestaurantUpdateDto dto) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		Restaurant findRestaurant = restaurantService.findByNo(dto.getRestaurantNo());
		if(findRestaurant!=null) {
			restaurantService.update(RestaurantUpdateDto.toEntity(dto));
		}
		
		return new ResponseEntity<RestaurantUpdateDto>(dto, httpHeaders, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{restaurantNo}")
	public void delete(@PathVariable(name = "restaurantNo") Long restaurantNo) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		restaurantService.deleteByNo(restaurantNo);
	}
	
	@PostMapping(value = "/list")
	public ResponseEntity<List<RestaurantListDto>> list(@RequestBody RestaurantListDto dto,HttpSession session) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		Long userNo = (Long)session.getAttribute("userNo");
		
		List<Restaurant> restaurantList = new ArrayList<Restaurant>();
		List<RestaurantListDto> viewList = new ArrayList<RestaurantListDto>();
		Integer order = dto.getOrder();
		Integer page = dto.getPage();
		Long categoryNo = dto.getCategoryNo();
		
		if(categoryNo ==0 && order == 0) {
			restaurantList = restaurantService.findAll();
		}
		
		// 검색어가 존재 X
		if(dto.getSearchKeyword() == "") {
			// Top 체크 O , 카테고리 체크 x
			if(categoryNo < 1) {
				// Top 정렬
				// 예약 많은순
				if(order == 1) {
					System.out.println(">>>예약많은순");
					restaurantList = restaurantService.findAllByBookingCountDesc();
				}
				// 별점 높은순
				if(order == 2) {
					restaurantList = restaurantService.findAllByOrderByRestaurantStarDesc();
				}
				// 리뷰 많은순
				if(order == 3) {
					restaurantList = restaurantService.findRestaurantOrderByReviewCountDesc();
				}
			}else {
				// 카테고리 + Top
				// 예약 많은순
				if(order==1) {
					restaurantList = restaurantService.findByCategoryNoOrderByBookingsDesc(categoryNo);
				}
				if(order==2) {
					restaurantList = restaurantService.findByCategoryNoOrderByStars(categoryNo);
				}
				if(order==3) {
					restaurantList = restaurantService.findByCategoryNoOrderByReviewsDesc(categoryNo);
				}
				// 리뷰 많은순
			}
			
			// Top 체크 x , 카테고리 체크
			if(categoryNo > 0 && order == 0) {
				restaurantList = restaurantService.findByRestaurantCategoryItemsRestaurantCategoryRcNo(categoryNo);
			}
		}else {
			// 검색어가 존재 O
			LinkedHashSet<Restaurant> findRestaurantListLinked = new LinkedHashSet<Restaurant>();
			List<Restaurant> restaurantsName = new ArrayList<Restaurant>();
			List<Restaurant> restaurantsAddress = new ArrayList<Restaurant>();
			// 카테고리, Top 정렬 체크 안한 상태 
			if(categoryNo ==0 && order == 0) {
				restaurantsName = restaurantService.findByRestaurantNameLike(dto.getSearchKeyword());
				restaurantsAddress = restaurantService.findByRestaurantAddressLike(dto.getSearchKeyword());
			}
			
			// 카테고리 체크 x , Top 정렬 체크
			if(categoryNo < 1) {
				// 예약 많은순
				if(order == 1) {
					restaurantsName = restaurantService.findRestaurantLikeRestaurantNameByBookingCountDesc(dto.getSearchKeyword());
				}
				// 별점 높은순
				if(order == 2) {
					restaurantsName = restaurantService.findRestaurantLikeRestaurantNameByOrderByRestaurantStarDesc(dto.getSearchKeyword());
				}
				// 리뷰많은순
				if(order == 3) {
					restaurantsName = restaurantService.findRestaurantLikeRestaurantNameOrderByReviewCountDesc(dto.getSearchKeyword());
				}
			}else {
				// 카테고리 체크 O , Top 정렬 체크 O
				// 예약 많은순
				if(order == 1) {
					restaurantsName = restaurantService.findRestaurantLikeRestaurantNameByCategoryNoOrderByBookingsDesc(categoryNo, dto.getSearchKeyword());
				}
				// 별점 높은순
				if(order == 2) {
					restaurantsName = restaurantService.findRestaurantLikeRestaurantNameByCategoryNoOrderByStars(categoryNo, dto.getSearchKeyword());
				}
				// 리뷰많은순
				if(order == 3) {
					restaurantsName = restaurantService.findRestaurantLikeRestaurantNameByCategoryNoOrderByReviewsDesc(categoryNo, dto.getSearchKeyword());
				}
			}
			
			// Top 체크 x , 카테고리 체크
			if(categoryNo > 0 && order == 0) {
				restaurantsName = restaurantService.findByRestaurantCategoryItemsRestaurantCategoryRcNoAndRestaurantNameLike(categoryNo,dto.getSearchKeyword());
			}
			
			for (Restaurant restaurant : restaurantsName) {
				findRestaurantListLinked.add(restaurant);
			}
			for (Restaurant restaurant : restaurantsAddress) {
				findRestaurantListLinked.add(restaurant);
			}
			restaurantList = new ArrayList<Restaurant>(findRestaurantListLinked);
		}
		
		
		// 한 페이지당 크기 설정
		int pageSize = 9;
		int pageInt = restaurantList.size()/pageSize;
		
		List<RestaurantCategory> categoryList = restaurantCategoryService.findAll();
		List<RestaurantCategoryInsertDto> categoryDtoList = new ArrayList<RestaurantCategoryInsertDto>();
		for (RestaurantCategory restaurantCategory : categoryList) {
			RestaurantCategoryInsertDto categoryDto = RestaurantCategoryInsertDto.toDto(restaurantCategory);
			categoryDtoList.add(categoryDto);
		}
		
		List<RestaurantListDto> previousList = new ArrayList<RestaurantListDto>();
		List<RestaurantListDto> nextList = new ArrayList<RestaurantListDto>();
		if(restaurantList.size() > 0) {
			
			for (int i = 0; i < restaurantList.size(); i++) {
				if(i >= pageSize*(page-2) && i < pageSize*(page-1)) {
					RestaurantListDto toDto = RestaurantListDto.toDto(restaurantList.get(i));
					previousList.add(toDto);
				}
			}
			
			for (int i = 0; i < restaurantList.size(); i++) {
				if(i >= pageSize*(page) && i < pageSize*(page+1)) {
					RestaurantListDto toDto = RestaurantListDto.toDto(restaurantList.get(i));
					nextList.add(toDto);
				}
			}
			
			for (int i = 0; i < restaurantList.size(); i++) {
				if(i >= pageSize*(page-1) && i < pageSize*page) {
					RestaurantListDto toDto = RestaurantListDto.toDto(restaurantList.get(i));
					int reviewSize = restaurantList.get(i).getRestaurantReviews().size();
					List<RestaurantImage> restaurantImageList = restaurantList.get(i).getRestaurantImages();
					toDto.setPageSize(pageSize);
					toDto.setPage(pageInt);
					toDto.setCurrentPage(page);
					toDto.setReviewSize(reviewSize);
					toDto.setOrder(order);
					toDto.setCategoryNo(categoryNo);
					toDto.setRestaurantSize(restaurantList.size());
					toDto.setCategoryList(categoryDtoList);
					toDto.setPreviousSize(previousList.size());
					toDto.setNextSize(nextList.size());
					
					List<RestaurantCategoryItem> restaurantCategoryItemList =
							restaurantCategoryItemService.findByRestaurantRestaurantNo(toDto.getRestaurantNo());
					
					List<RestaurantCategoryItemDto> restaurantCategoryItemDto = new ArrayList<RestaurantCategoryItemDto>();
					for (RestaurantCategoryItem item : restaurantCategoryItemList) {
						RestaurantCategoryItemDto itemDto = RestaurantCategoryItemDto.toDto(item);
						restaurantCategoryItemDto.add(itemDto);
					}
					
					toDto.setRestaurantCategoryItems(restaurantCategoryItemDto);
					
					List<RestaurantImageDto> restaurantImageDtoList = new ArrayList<RestaurantImageDto>();
					for (RestaurantImage image : restaurantImageList) {
						RestaurantImageDto imageDto = RestaurantImageDto.toDto(image);
						restaurantImageDtoList.add(imageDto);
					}
					boolean existWish = wishService.existByUserNoAndRestaurantNo(userNo, toDto.getRestaurantNo());
					toDto.setWishBool(existWish);
					toDto.setRestaurantImageList(restaurantImageDtoList);
					viewList.add(toDto);
				}
			}
		}else {
			RestaurantListDto toDto = new RestaurantListDto();
			toDto.setPageSize(pageSize);
			toDto.setPage(pageInt);
			toDto.setCurrentPage(page);
			toDto.setOrder(order);
			toDto.setCategoryNo(categoryNo);
			toDto.setCategoryList(categoryDtoList);
			toDto.setRestaurantSize(restaurantList.size());
			viewList.add(toDto);
		}
		
		return new ResponseEntity<List<RestaurantListDto>>(viewList, httpHeaders, HttpStatus.OK);
	}
	
	@PostMapping("/searchName")
	public ResponseEntity<List<RestaurantInsertDto>> searchName(@RequestBody RestaurantInsertDto dto) {
		List<Restaurant> findRestaurants = restaurantService.findByRestaurantNameLike(dto.getRestaurantName());
		List<RestaurantInsertDto> restaurantDtos = new ArrayList<RestaurantInsertDto>();
		for (Restaurant restaurant : findRestaurants) {
			RestaurantInsertDto tempRestaurant = RestaurantInsertDto.toDto(restaurant);
			restaurantDtos.add(tempRestaurant);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<RestaurantInsertDto>>(restaurantDtos, httpHeaders, HttpStatus.OK);
	}
	
	@PostMapping("/searchAddress")
	public ResponseEntity<List<RestaurantInsertDto>> searchAddress(@RequestBody RestaurantInsertDto dto) {
		
		List<Restaurant> findRestaurants = restaurantService.findByRestaurantAddressLike(dto.getRestaurantAddress());
		List<RestaurantInsertDto> restaurantDtos = new ArrayList<RestaurantInsertDto>();
		for (Restaurant restaurant : findRestaurants) {
			RestaurantInsertDto tempRestaurant = RestaurantInsertDto.toDto(restaurant);
			restaurantDtos.add(tempRestaurant);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<RestaurantInsertDto>>(restaurantDtos, httpHeaders, HttpStatus.OK);
	}
}
