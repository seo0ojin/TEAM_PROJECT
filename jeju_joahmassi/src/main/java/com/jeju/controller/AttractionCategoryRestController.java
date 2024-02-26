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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeju.dto.AttractionCategoryDto;
import com.jeju.entity.AttractionCategory;
import com.jeju.service.AttractionCategoryService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/attractionCategory")
public class AttractionCategoryRestController {

	@Autowired
	private AttractionCategoryService attractionCategoryService;
	
	@GetMapping("/insert")
	@Operation(summary =  "카테고리 추가 (관리자)")
	public ResponseEntity<AttractionCategoryDto> insertAttractionCategory(AttractionCategoryDto dto, HttpSession session) {
		
		attractionCategoryService.insert(AttractionCategoryDto.toEntity(dto));
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<AttractionCategoryDto>(dto, httpHeaders, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{acNo}")
	@Operation(summary = "카테고리 삭제 (관리자)")
	public ResponseEntity deleteAttractionCategory(@PathVariable(name = "acNo") Long acNo, HttpSession session) {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		
		attractionCategoryService.delete(acNo);
		
		return new ResponseEntity(httpHeaders, HttpStatus.OK);
	}
	
	@PutMapping
	@Operation(summary = "카테고리 수정 (관리자)")
	public ResponseEntity<AttractionCategoryDto> updateAttractionCategory(@RequestBody AttractionCategoryDto dto) {
		
		AttractionCategory attractionCategory = attractionCategoryService.findByNo(dto.getAcNo());
		
		if (attractionCategory != null) {
			attractionCategoryService.update(AttractionCategoryDto.toEntity(dto));
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<AttractionCategoryDto>(dto, httpHeaders, HttpStatus.OK);
	} 
}
