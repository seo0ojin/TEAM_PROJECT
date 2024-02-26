package com.jeju.controller;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import com.jeju.dto.HotelCategoryDto;
import com.jeju.dto.HotelCategoryUpdateDto;
import com.jeju.entity.HotelCategory;
import com.jeju.service.HotelCategoryService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/hotelCategory")
public class HotelCategoryRestController {

	@Autowired
	private HotelCategoryService hotelCategoryService;

	
	@Operation(summary = "호텔 카테고리 추가")
	@PostMapping("/insert")
	public ResponseEntity<HotelCategoryDto> insert(@RequestBody HotelCategoryDto dto) {

		hotelCategoryService.insertCategory(HotelCategoryDto.toEntity(dto));

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<HotelCategoryDto>(dto, httpHeaders, HttpStatus.CREATED);
	}
	
	
	@Operation(summary = "호텔 카테고리 수정")
	@PutMapping("/update/{hcNo}")
	public ResponseEntity<HotelCategoryUpdateDto> update(@PathVariable(name = "hcNo") Long hcNo, @RequestBody HotelCategoryDto dto) {
		 
		HotelCategory find = hotelCategoryService.findByNo(hcNo);
		
		if (find != null) {
			if (dto.getHcName() != null) {
				find.setHcName(dto.getHcName());
			}
			hotelCategoryService.updateCategory(find);
			return new ResponseEntity<HotelCategoryUpdateDto>(HotelCategoryUpdateDto.toDto(find), HttpStatus.OK);
		} else {
			return new ResponseEntity<HotelCategoryUpdateDto>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@Operation(summary = "호텔 카테고리 삭제")
	@DeleteMapping("delete/{hcNo}")
	public ResponseEntity delete(@PathVariable(name = "hcNo") Long hcNo) {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		hotelCategoryService.deleteCategory(hcNo);
		
		return new ResponseEntity(httpHeaders, HttpStatus.OK);
	}
}
