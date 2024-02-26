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

import com.jeju.dto.AttractionCategoryDto;
import com.jeju.dto.AttractionDto;
import com.jeju.dto.AttractionImageDto;
import com.jeju.dto.AttractionReviewDto;
import com.jeju.entity.Attraction;
import com.jeju.entity.AttractionCategory;
import com.jeju.entity.AttractionCategoryItem;
import com.jeju.entity.AttractionImage;
import com.jeju.entity.AttractionReview;
import com.jeju.service.AttractionCategoryItemService;
import com.jeju.service.AttractionCategoryService;
import com.jeju.service.AttractionImageService;
import com.jeju.service.AttractionReviewService;
import com.jeju.service.AttractionService;
import com.jeju.service.WishService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/attraction")
public class AttractionRestController {

	@Autowired
	private AttractionService attractionService;
	@Autowired
	private AttractionCategoryService attractionCategoryService;
	@Autowired
	private AttractionCategoryItemService attractionCategoryItemService;
	@Autowired
	private AttractionImageService attractionImageService;
	@Autowired
	private WishService wishService;
	@Autowired
	private AttractionReviewService attractionReviewService;

	@GetMapping("/insert")
	@Operation(summary = "명소 추가 (관리자)")
	public ResponseEntity<AttractionDto> insertAttraction(AttractionDto dto, HttpSession session) {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		Attraction insertAttraction = attractionService.insertAttraction(AttractionDto.toEntity(dto));
		AttractionCategoryItem item = AttractionCategoryItem.builder().attraction(insertAttraction)
				.attractionCategory(attractionCategoryService.findByNo(dto.getAcNo())).build();
		attractionCategoryItemService.insert(item);

		List<String> imageNames = dto.getImageName();

		for (String imageName : imageNames) {
			attractionImageService
					.insert(AttractionImage.builder().imageName(imageName).attraction(insertAttraction).build());
		}

		return new ResponseEntity<AttractionDto>(dto, httpHeaders, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{attractionNo}")
	@Operation(summary = "명소 삭제 (관리자)")
	public ResponseEntity deleteAttraction(@PathVariable(name = "attractionNo") Long attractionNo,
			HttpSession session) {

		HttpHeaders httpHeaders = new HttpHeaders();

		attractionService.deleteAttraction(attractionNo);

		return new ResponseEntity(httpHeaders, HttpStatus.OK);
	}

	@PutMapping
	@Operation(summary = "명소 수정 (관리자)")
	public ResponseEntity<AttractionDto> updateAttraction(@RequestBody AttractionDto dto) {
		Attraction findAttraction = attractionService.findByAttractionNo(dto.getAttractionNo());

		if (findAttraction != null) {
			attractionService.updateAttraction(AttractionDto.toEntity(dto));
		}

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<AttractionDto>(dto, httpHeaders, HttpStatus.OK);
	}
	
	/*
	@PostMapping("/searchName")
	@Operation(summary = "명소 이름 검색")
	public ResponseEntity<List<AttractionDto>> attractionNameSearch(@RequestBody AttractionDto dto) {
		List<AttractionDto> attractionListDto = new ArrayList<AttractionDto>();
		List<Attraction> findList = attractionService.findByAttractionNameLike(dto.getAttractionName());
		
		for (Attraction attraction : findList) {
			AttractionDto attractionDto = AttractionDto.toDto(attraction);
			attractionListDto.add(attractionDto);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<AttractionDto>>(attractionListDto, httpHeaders, HttpStatus.OK);
		
	}
	
	@PostMapping("/searchAddress")
	@Operation(summary = "명소 주소 검색")
	public ResponseEntity<List<AttractionDto>> attractionAddressSearch(@RequestBody AttractionDto dto) {
		List<AttractionDto> attractionListDto = new ArrayList<AttractionDto>();
		List<Attraction> findList = attractionService.findByAttractionAddressLike(dto.getAttractionAddress());
		
		for (Attraction attraction : findList) {
			AttractionDto attractionDto = AttractionDto.toDto(attraction);
			attractionListDto.add(attractionDto);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<AttractionDto>>(attractionListDto, httpHeaders, HttpStatus.OK);
	}
	*/
	
	@PostMapping("/search")
	@Operation(summary = "명소 검색")
	public ResponseEntity<List<AttractionDto>> attractionSearch(@RequestBody AttractionDto dto) {
		LinkedHashSet<AttractionDto> searchList = new LinkedHashSet<AttractionDto>();
		List<Attraction> nameList = attractionService.findByAttractionNameLike(dto.getAttractionName());
		List<Attraction> addressList = attractionService.findByAttractionAddressLike(dto.getAttractionAddress());
		
		for (Attraction name : nameList) {
			AttractionDto attractionDto = AttractionDto.toDto(name);
			searchList.add(attractionDto);
		}
		
		for (Attraction address : addressList) {
			AttractionDto attractionDto = AttractionDto.toDto(address);
			searchList.add(attractionDto);
		}
		
		List<AttractionDto> list = new ArrayList<AttractionDto>(searchList);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<AttractionDto>>(list, httpHeaders, HttpStatus.OK);
	}
	
	@PostMapping(value = "/list")
	@Operation(summary = "페이징 리스트")
	public ResponseEntity<List<AttractionDto>> list(@RequestBody AttractionDto dto, HttpSession session) {
		Long userNo = (Long)session.getAttribute("userNo");
		
		List<Attraction> attractionList = new ArrayList<>();
		List<AttractionDto> viewList = new ArrayList<AttractionDto>();  
		
		Integer order = dto.getOrder();
		Integer page = dto.getPage();
		Long categoryNo = dto.getCategoryNo();
		
		if (categoryNo == 0 && order == 0) {
			attractionList = attractionService.findAll();
		}
		
		// 검색어 존재 X
		if (dto.getSearchKeyword() == "") {
			// 정렬 체크 O, 카테고리 체크 X
			if (categoryNo < 1) {
				// 별점 높은 순
				if (order == 1) {
					attractionList = attractionService.findAllByOrderByAttractionStarDesc();
				}
				// 리뷰 많은 순
				if (order == 2) {
					attractionList = attractionService.findAttractionOrderByReviewCountDesc();
				}
			} else {
				// 정렬 체크 O, 카테고리 체크 O
				if (order == 1) {
					// 별점 높은 순 + 카테고리
					attractionList = attractionService.findByCategoryNoOrderByStars(categoryNo);
				}
				if (order == 2) {
					// 리뷰 많은 순 + 카테고리
					attractionList = attractionService.findByCategoryNoOrderByReviewsDesc(categoryNo);
				}
			}

			// 정렬 체크 X, 카테고리 체크 O
			if (categoryNo > 0 && order == 0) {
				attractionList = attractionService.findByAttractionCategoryItemsAttractionCategoryAcNo(categoryNo);
			}
		} else {
			// 검색어 존재 O
			LinkedHashSet<Attraction> findAttractionListLinked = new LinkedHashSet<Attraction>();
			List<Attraction> attractionName = new ArrayList<Attraction>();
			List<Attraction> attractionAddress = new ArrayList<Attraction>();
			
			// 정렬, 카테고리 체크 안 한 상태
			if (categoryNo == 0 && order == 0) {
				attractionName = attractionService.findByAttractionNameLike(dto.getSearchKeyword());
				attractionAddress = attractionService.findByAttractionAddressLike(dto.getSearchKeyword());
			}
			
			// 정렬 체크 O, 카테고리 체크 X
			if (categoryNo < 1) {
				// 별점 높은 순
				if (order == 1) {
					attractionName = attractionService.findAttractionLikeAttractionNameByOrderByAttractionStarDesc(dto.getSearchKeyword());
				}
				// 리뷰 많은 순
				if (order == 2) {
					attractionName = attractionService.findAttractionLikeAttractionNameOrderByReviewCountDesc(dto.getSearchKeyword());
				}
			} else {
				// 정렬 체크 O, 카테고리 체크 O
				if (order == 1) {
					// 별점 높은 순
					attractionName = attractionService.findAttractionLikeAttractionNameByCategoryNoOrderByStars(categoryNo, dto.getSearchKeyword());
				}
				if (order == 2) {
					// 리뷰 많은 순
					attractionName = attractionService.findAttractionLikeAttractionNameByCategoryNoOrderByReviewsDesc(categoryNo, dto.getSearchKeyword());
				}
			}
			
			// 정렬 체크 O, 카테고리 체크 X
			if (categoryNo > 0 && order == 0) {
				attractionName = attractionService.findByAttractionCategoryItemsAttractionCategoryAcNoAndAttractionNameLike(categoryNo, dto.getSearchKeyword());
			}
			
			for (Attraction attraction : attractionName) {
				findAttractionListLinked.add(attraction);
			}
			
			for (Attraction attraction : attractionAddress) {
				findAttractionListLinked.add(attraction);
			}
			
			attractionList = new ArrayList<Attraction>(findAttractionListLinked);
		}
		
		int pageSize = 9;
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
					AttractionDto toDto = AttractionDto.toDto(attractionList.get(i));
					previousList.add(toDto);
				}
			}
			
			for (int i = 0; i < attractionList.size(); i++) {
				if(i >= pageSize*(page) && i < pageSize*(page+1)) {
					AttractionDto toDto = AttractionDto.toDto(attractionList.get(i));
					nextList.add(toDto);
				}
			}
			
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
					
					AttractionDto toDto = AttractionDto.toDto(attractionList.get(i));
					int reviewSize = attractionList.get(i).getAttractionReviews().size();
					toDto.setPageSize(pageSize);
					toDto.setPage(pageInt);
					toDto.setCurrentPage(page);
					toDto.setReviewSize(reviewSize);
					toDto.setOrder(order);
					toDto.setAttractionSize(attractionSize);
					toDto.setCategoryNo(categoryNo);
					toDto.setCategoryList(categoryDtoList);
					toDto.setAttractionStar(averageStars);
					
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
	
}

