package com.jeju.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeju.dto.AttractionCategoryDto;
import com.jeju.dto.AttractionDto;
import com.jeju.dto.AttractionImageDto;
import com.jeju.dto.HotelCategoryDto;
import com.jeju.dto.HotelCategoryItemDto;
import com.jeju.dto.HotelDto;
import com.jeju.dto.HotelImageDto;
import com.jeju.dto.RestaurantCategoryInsertDto;
import com.jeju.dto.RestaurantCategoryItemDto;
import com.jeju.dto.RestaurantImageDto;
import com.jeju.dto.RestaurantListDto;
import com.jeju.dto.WishDto;
import com.jeju.entity.Attraction;
import com.jeju.entity.AttractionCategory;
import com.jeju.entity.AttractionImage;
import com.jeju.entity.Hotel;
import com.jeju.entity.HotelCategory;
import com.jeju.entity.HotelCategoryItem;
import com.jeju.entity.HotelImage;
import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantCategory;
import com.jeju.entity.RestaurantCategoryItem;
import com.jeju.entity.RestaurantImage;
import com.jeju.entity.Wish;
import com.jeju.service.AttractionCategoryItemService;
import com.jeju.service.AttractionCategoryService;
import com.jeju.service.AttractionImageService;
import com.jeju.service.AttractionService;
import com.jeju.service.HotelCategoryItemService;
import com.jeju.service.HotelCategoryService;
import com.jeju.service.HotelImageService;
import com.jeju.service.HotelService;
import com.jeju.service.RestaurantCategoryItemService;
import com.jeju.service.RestaurantCategoryService;
import com.jeju.service.RestaurantService;
import com.jeju.service.UserinfoService;
import com.jeju.service.WishService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/wish")
public class WishRestController {

	@Autowired
	private WishService wishService;
	@Autowired
	private UserinfoService userinfoService;
	@Autowired
	private HotelService hotelService;
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private RestaurantCategoryService restaurantCategoryService;
	@Autowired
	private RestaurantCategoryItemService restaurantCategoryItemService;
	@Autowired
	private AttractionService attractionService;
	@Autowired
	private HotelCategoryService hotelCategoryService;
	@Autowired
	private HotelCategoryItemService hotelCategoryItemService;
	@Autowired
	private HotelImageService hotelImageService;
	@Autowired
	private AttractionCategoryService attractionCategoryService;
	@Autowired
	private AttractionCategoryItemService attractionCategoryItemService;
	@Autowired
	private AttractionImageService attractionImageService;
	
	// 레스토랑 위시 리스트
	@PostMapping(value = "/restaurantlist")
	public ResponseEntity<List<RestaurantListDto>> wishRestaurantList(HttpSession session,@RequestBody RestaurantListDto dto) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		Long userNo = (Long)session.getAttribute("userNo");
		
		List<Wish> restaurantList = wishService.findByUserinfo_UserNoAndWishCategory(userNo, "맛집");
		List<RestaurantListDto> viewList = new ArrayList<RestaurantListDto>();
		Integer order = dto.getOrder();
		Integer page = dto.getPage();
		Long categoryNo = dto.getCategoryNo();
		
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
					RestaurantListDto toDto = RestaurantListDto.toDto(restaurantList.get(i).getRestaurant());
					previousList.add(toDto);
				}
			}
			
			for (int i = 0; i < restaurantList.size(); i++) {
				if(i >= pageSize*(page) && i < pageSize*(page+1)) {
					RestaurantListDto toDto = RestaurantListDto.toDto(restaurantList.get(i).getRestaurant());
					nextList.add(toDto);
				}
			}
			for (int i = 0; i < restaurantList.size(); i++) {
				if(i >= pageSize*(page-1) && i < pageSize*page) {
					RestaurantListDto toDto = RestaurantListDto.toDto(restaurantList.get(i).getRestaurant());
					int reviewSize = restaurantList.get(i).getRestaurant().getRestaurantReviews().size();
					List<RestaurantImage> restaurantImageList = restaurantList.get(i).getRestaurant().getRestaurantImages();
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
	
	@PostMapping(value = "/hotellist")
	public ResponseEntity<List<HotelDto>> list(HttpSession session,@RequestBody HotelDto dto) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		Long userNo = (Long)session.getAttribute("userNo");
		
		List<Wish> hotelList = wishService.findByUserinfo_UserNoAndWishCategory(userNo, "호텔");
		List<HotelDto> viewList = new ArrayList<HotelDto>();
		
		Integer order = dto.getOrder();
		Integer page = dto.getPage();
		Long categoryNo = dto.getCategoryNo();
		
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
					HotelDto toDto = HotelDto.toDto(hotelList.get(i).getHotel());
					previousList.add(toDto);
				}
			}
			
			for (int i = 0; i < hotelList.size(); i++) {
				if(i >= pageSize*(page) && i < pageSize*(page+1)) {
					HotelDto toDto = HotelDto.toDto(hotelList.get(i).getHotel());
					nextList.add(toDto);
				}
			}
			
			for (int i = 0; i < hotelList.size(); i++) {
				if (i >= pageSize * (page - 1) && i < pageSize * page) {

					HotelDto toDto = HotelDto.toDto(hotelList.get(i).getHotel());

					int reviewSize = hotelList.get(i).getHotel().getHotelReview().size();

					toDto.setPageSize(pageSize);
					toDto.setPage(pageInt);
					System.out.println(">>>>>>>>>>>>>>>>"+pageInt);
					toDto.setCurrentPage(page);
					toDto.setReviewSize(reviewSize);
					toDto.setHotelSize(hotelList.size());
					toDto.setOrder(order);
					toDto.setCategoryNo(categoryNo);
					toDto.setCategoryList(categoryDtoList);
					toDto.setPreviousSize(previousList.size());
					toDto.setNextSize(nextList.size());

					boolean existWish = wishService.existByUserNoAnHotelNo(userNo, toDto.getHotelNo());
					toDto.setWishBool(existWish);
					
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
			System.out.println(">>>>>>>>>>>" + imageList);
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
	
	// 위시 명소 리스트
	@PostMapping(value = "/attractionlist")
	@Operation(summary = "페이징 리스트")
	public ResponseEntity<List<AttractionDto>> attractionlist(HttpSession session,@RequestBody AttractionDto dto) {
		
		Long userNo = (Long)session.getAttribute("userNo");
		
		List<Wish> attractionList = new ArrayList<Wish>();
		List<AttractionDto> viewList = new ArrayList<AttractionDto>(); 
		
		attractionList = wishService.findByUserinfo_UserNoAndWishCategory(userNo, "명소");
		
		Integer order = dto.getOrder();
		Integer page = dto.getPage();
		Long categoryNo = dto.getCategoryNo();
		
		Integer pageSize = 9;
		int pageInt = attractionList.size() / pageSize;
		
		int attractionSize = attractionList.size();
		
		List<AttractionCategory> categoryList = attractionCategoryService.findAll();
		List<AttractionCategoryDto> categoryDtoList = new ArrayList<AttractionCategoryDto>();
		for (AttractionCategory attractionCategory : categoryList) {
			AttractionCategoryDto categoryDto = AttractionCategoryDto.toDto(attractionCategory);
			categoryDtoList.add(categoryDto);
			
		}
		List<AttractionDto> previousList = new ArrayList<AttractionDto>();
		List<AttractionDto> nextList = new ArrayList<AttractionDto>();
		if (attractionList.size() > 0) {
			
			for (int i = 0; i < attractionList.size(); i++) {
				if(i >= pageSize*(page-2) && i < pageSize*(page-1)) {
					AttractionDto toDto = AttractionDto.toDto(attractionList.get(i).getAttraction());
					previousList.add(toDto);
				}
			}
			
			for (int i = 0; i < attractionList.size(); i++) {
				if(i >= pageSize*(page) && i < pageSize*(page+1)) {
					AttractionDto toDto = AttractionDto.toDto(attractionList.get(i).getAttraction());
					nextList.add(toDto);
				}
			}
			
			for (int i = 0; i < attractionList.size(); i++) {
				if (i >= pageSize * (page - 1) && i < pageSize * page) {
					AttractionDto toDto = AttractionDto.toDto(attractionList.get(i).getAttraction());
					int reviewSize = attractionList.get(i).getAttraction().getAttractionReviews().size();
					toDto.setPageSize(pageSize);
					toDto.setPage(pageInt);
					toDto.setCurrentPage(page);
					toDto.setReviewSize(reviewSize);
					toDto.setOrder(order);
					toDto.setAttractionSize(attractionSize);
					toDto.setCategoryNo(categoryNo);
					toDto.setCategoryList(categoryDtoList);
					toDto.setPreviousSize(previousList.size());
					toDto.setNextSize(nextList.size());
					
					List<AttractionImage> imageList = attractionImageService.findByAttractionAttractionNo(toDto.getAttractionNo());
					List<AttractionImageDto> imageDtoList = new ArrayList<AttractionImageDto>();
					
					for (AttractionImage attractionImage : imageList) {
						AttractionImageDto attractionImageDto = AttractionImageDto.toDto(attractionImage);
						imageDtoList.add(attractionImageDto);
					}
					toDto.setAttractionImageDto(imageDtoList);
					
					toDto.setPreviousSize(previousList.size());
					toDto.setNextSize(nextList.size());
					
					boolean existWish = wishService.existByUserNoAndAttractionNo(userNo, toDto.getAttractionNo());
					toDto.setWishBool(existWish);
					
					viewList.add(toDto);
				}
			}
		} else {
			AttractionDto toDto = new AttractionDto();
			toDto.setPageSize(pageSize);
			toDto.setPage(pageInt);
			toDto.setCurrentPage(page);
			toDto.setOrder(order);
			toDto.setAttractionSize(attractionSize);
			toDto.setCategoryNo(categoryNo);
			toDto.setCategoryList(categoryDtoList);
			
			List<AttractionImage> imageList = attractionImageService.findByAttractionAttractionNo(toDto.getAttractionNo());
			List<AttractionImageDto> imageDtoList = new ArrayList<AttractionImageDto>();
			
			for (AttractionImage attractionImage : imageList) {
				AttractionImageDto attractionImageDto = AttractionImageDto.toDto(attractionImage);
				imageDtoList.add(attractionImageDto);
			}
			toDto.setAttractionImageDto(imageDtoList);
			
			viewList.add(toDto);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));	
		
		return new ResponseEntity<List<AttractionDto>>(viewList, httpHeaders, HttpStatus.OK);
	}
	
	@PostMapping("/insertHotel")
	@Operation(summary = "위시 호텔 추가")
	public ResponseEntity<WishDto> insertWishByHotel(@RequestBody WishDto dto, HttpSession session) throws Exception {
		
		Long userNo = (Long) session.getAttribute("userNo");
		/*
		if (userNo == null) {
			throw new Exception("로그인 하세요.");
		}
		*/
		Wish wish = WishDto.toEntity(dto);
		
		boolean tf = wishService.existByUserNoAnHotelNo(userNo, dto.getHotelNo());
		
		if (tf == true) {
			dto.setStatus(1);
		} else if (tf == false) {
			dto.setStatus(2);
			
			wish.setUserinfo(userinfoService.findByUserNo(userNo));
			wish.setHotel(hotelService.findByHotelNo(dto.getHotelNo()));
			
			wishService.insertWishByHotel(wish);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<WishDto>(dto, httpHeaders, HttpStatus.OK);
		
	}
	
	@PostMapping("/insertRestaurant")
	@Operation(summary = "위시 맛집 추가")
	public ResponseEntity<WishDto> insertWishByRestaurant(@RequestBody WishDto dto, HttpSession session) throws Exception {
		
		Long userNo = (Long) session.getAttribute("userNo");
		
		if (session.getAttribute("userNo") == null) {
			throw new Exception("로그인 하세요.");
		}
		
		Wish wish = WishDto.toEntity(dto);
		
		boolean tf = wishService.existByUserNoAndRestaurantNo(userNo, dto.getRestaurantNo());	
		
		if (tf == true) {
			dto.setStatus(3);
		} else if (tf == false) {
			dto.setStatus(4);
			
			wish.setUserinfo(userinfoService.findByUserNo(userNo));
			wish.setRestaurant(restaurantService.findByNo(dto.getRestaurantNo()));
			
			wishService.insertWishByRestaurant(wish);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<WishDto>(dto, httpHeaders, HttpStatus.OK);
		
	}
	
	@PostMapping("/insertAttraction")
	@Operation(summary = "위시 명소 추가")
	public ResponseEntity<WishDto> insertWishByAttraction(@RequestBody WishDto dto, HttpSession session) throws Exception {
		
		if (session.getAttribute("userNo") == null) {
			throw new Exception("로그인 하세요.");
		}
		
		Wish wish = WishDto.toEntity(dto);
		Long userNo = (Long) session.getAttribute("userNo");
		
		boolean tf = wishService.existByUserNoAndAttractionNo(userNo, dto.getAttractionNo());
		
		if (tf == true) {
			dto.setStatus(5);
		} else if (tf == false) {
			dto.setStatus(6);
			
			wish.setUserinfo(userinfoService.findByUserNo(userNo));
			wish.setAttraction(attractionService.findByAttractionNo(dto.getAttractionNo()));
			
			wishService.insertWishByAttraction(wish);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<WishDto>(dto, httpHeaders, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{wishNo}")
	@Operation(summary = "위시 삭제")
	public void deleteWish(@PathVariable(name = "wishNo") Long wishNo, HttpSession session) {
		wishService.deleteWish(wishNo);
	}
	
	@DeleteMapping("/deleteWish")
	public void deleteWishRestaurant(HttpSession session, @RequestBody WishDto dto) {
		System.out.println(">>>>>>>>>>>>>>>.삭제!!!");
		Long userNo = (Long)session.getAttribute("userNo");
		if(dto.getRestaurantNo() > 0) {
			wishService.deleteByUserinfoUserNoAndRestaurantRestaurantNo(userNo, dto.getRestaurantNo());
		}
		if(dto.getHotelNo() > 0) {
			wishService.deleteByUserinfoUserNoAndHotelHotelNo(userNo, dto.getHotelNo());
		}
		if(dto.getAttractionNo() > 0) {
			wishService.deleteByUserinfoUserNoAndAttractionAttractionNo(userNo, dto.getAttractionNo());
		}
	}
	
}
