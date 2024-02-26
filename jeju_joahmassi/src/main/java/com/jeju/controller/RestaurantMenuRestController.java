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

import com.jeju.dto.RestaurantMenuDeleteDto;
import com.jeju.dto.RestaurantMenuInsertDto;
import com.jeju.dto.RestaurantMenuUpdateDto;
import com.jeju.dto.RestaurantReviewInsertDto;
import com.jeju.service.RestaurantMenuService;

@RestController
@RequestMapping("/restaurantMenu")
public class RestaurantMenuRestController {
	@Autowired
	private RestaurantMenuService restaurantMenuService;
	
	@PostMapping("/insert")
	public ResponseEntity<RestaurantMenuInsertDto> insert(@RequestBody RestaurantMenuInsertDto dto) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		restaurantMenuService.insert(RestaurantMenuInsertDto.toEntity(dto));
		return new ResponseEntity<RestaurantMenuInsertDto>(dto, httpHeaders, HttpStatus.CREATED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<RestaurantMenuUpdateDto> update(@RequestBody RestaurantMenuUpdateDto dto) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		if(restaurantMenuService.findByNo(dto.getRmNo())!=null) {
			restaurantMenuService.update(RestaurantMenuUpdateDto.toEntity(dto));	
		}
		return new ResponseEntity<RestaurantMenuUpdateDto>(dto, httpHeaders, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<RestaurantMenuDeleteDto> delete(@RequestBody RestaurantMenuDeleteDto dto) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		restaurantMenuService.deleteByNo(RestaurantMenuDeleteDto.toEntity(dto).getRmNo());
		return new ResponseEntity<RestaurantMenuDeleteDto>(dto, httpHeaders, HttpStatus.CREATED);
	}
}
