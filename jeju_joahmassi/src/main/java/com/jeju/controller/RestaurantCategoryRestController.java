package com.jeju.controller;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeju.dto.RestaurantBookingInsertDto;
import com.jeju.dto.RestaurantCategoryDeleteDto;
import com.jeju.dto.RestaurantCategoryInsertDto;
import com.jeju.dto.RestaurantCategoryUpdateDto;
import com.jeju.service.RestaurantCategoryService;

@RestController
@RequestMapping("/restaurantCategory")
public class RestaurantCategoryRestController {
	
	@Autowired
	private RestaurantCategoryService restaurantCategoryService;
	
	@PostMapping("/insert")
	public ResponseEntity<RestaurantCategoryInsertDto> insert(@RequestBody RestaurantCategoryInsertDto dto) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		restaurantCategoryService.insert(RestaurantCategoryInsertDto.toEntity(dto));
		return new ResponseEntity<RestaurantCategoryInsertDto>(dto, httpHeaders, HttpStatus.CREATED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<RestaurantCategoryUpdateDto> update(@RequestBody RestaurantCategoryUpdateDto dto) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		if(restaurantCategoryService.findByNo(dto.getRcNo())!=null) {
			restaurantCategoryService.update(RestaurantCategoryUpdateDto.toEntity(dto));	
		}
		return new ResponseEntity<RestaurantCategoryUpdateDto>(dto, httpHeaders, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<RestaurantCategoryDeleteDto> delete(@RequestBody RestaurantCategoryDeleteDto dto) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		restaurantCategoryService.delete(RestaurantCategoryDeleteDto.toEntity(dto).getRcNo());
		
		return new ResponseEntity<RestaurantCategoryDeleteDto>(dto, httpHeaders, HttpStatus.OK);
	}
	
}
