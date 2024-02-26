package com.jeju.controller;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jeju.dto.HotelDto;
import com.jeju.dto.HotelQnADto;
import com.jeju.dto.HotelQnAListDto;
import com.jeju.dto.HotelQnAPageDto;
import com.jeju.dto.HotelQnAUpdateDto;
import com.jeju.entity.Hotel;
import com.jeju.entity.HotelQnA;
import com.jeju.entity.Userinfo;
import com.jeju.service.HotelQnAService;
import com.jeju.service.HotelService;
import com.jeju.service.PasswordMismatchException;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/hotelQnA")
public class HotelQnARestController {

	@Autowired
	private HotelService hotelService;
	@Autowired
	private HotelQnAService hotelQnAService;
	
	
	@Operation(summary = "호텔 큐앤에이 작성")
	@PostMapping("/insert")
	public ResponseEntity<HotelQnADto> insertQnA(@RequestBody HotelQnADto dto, HttpSession session) {

	    Long userNo = (Long) session.getAttribute("userNo");
	    
	    HotelQnA qnaEntity = HotelQnADto.toEntity(dto);
	    
	    // hotel 속성을 영속화
	    Hotel hotel = hotelService.findByHotelNo(dto.getHotelNo());
	    qnaEntity.setHotel(hotel);
	    qnaEntity.setQnaDate(LocalDate.now());
	    qnaEntity.setQnaSecretCheck(dto.getQnaSecretCheck());
	    qnaEntity.setQnaStatus(dto.getQnaStatus());
	    
	    if(dto.getQnaStatus() == 1) {
	    	// 답변
	    	qnaEntity.setQnaAnswer(dto.getQnaAnswer());
	    }else {
	    	if (userNo != null) {
		        // 세션에서 userNo가 존재하면 해당 userNo로 작성
		        Userinfo userinfo = new Userinfo();
		        userinfo.setUserNo(userNo);
		        qnaEntity.setUserinfo(userinfo);
		    } else {
		        // 세션에서 userNo가 없으면 null로 설정하여 작성
		        qnaEntity.setUserinfo(null);
		    }
	    }
	    
	    // HotelQnA 엔티티를 저장
	    hotelQnAService.insertQnA(qnaEntity);

	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

	    return new ResponseEntity<HotelQnADto>(dto, httpHeaders, HttpStatus.CREATED);
	}
	
	@Operation(summary = "호텔 큐앤에이 답변작성")
	@PostMapping("/answer")
	public ResponseEntity<HotelQnADto> answer(@RequestBody HotelQnADto dto, HttpSession session) {
	    
	    HotelQnA qnaEntity = hotelQnAService.findByQnANo(dto.getQnaNo());
	    
	    if(dto.getQnaStatus() == 1) {
	    	qnaEntity.setQnaAnswer(dto.getQnaAnswer());
	    	qnaEntity.setQnaStatus(dto.getQnaStatus());
	    }
	    
	    // HotelQnA 엔티티를 저장
	    hotelQnAService.updateQnA(qnaEntity);

	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

	    return new ResponseEntity<HotelQnADto>(dto, httpHeaders, HttpStatus.CREATED);
	}
	
	/*
	@Operation(summary = "호텔 큐앤에이 번호로 찾기")
	@GetMapping("/{qnaNo}")
	public HotelQnADto findHotelQnAByNo(@PathVariable(name = "qnaNo") Long qnaNo) {
		
		HotelQnA find = hotelQnAService.findByQnANo(qnaNo);
		
		HotelQnADto qnaDto = HotelQnADto.toDto(find);
		
		return qnaDto;
	}
	*/
	
	/*
	@Operation(summary = "호텔 큐앤에이 번호로 찾기 (비밀번호 일치 여부 확인)")
	@GetMapping("/{qnaNo}")
	public HotelQnADto findHotelQnAByNo(@PathVariable(name = "qnaNo") Long qnaNo, @RequestParam(name = "qnaPassword") String qnaPassword) {
		// 비밀번호 일치 여부를 검사
		boolean isPasswordMatch = hotelQnAService.checkPassword(qnaNo, qnaPassword);

		if (isPasswordMatch) {
			// 비밀번호가 일치하면 findByQnANo 실행
			HotelQnA find = hotelQnAService.findByQnANo(qnaNo);
			HotelQnADto qnaDto = HotelQnADto.toDto(find);
			return qnaDto;
		} else {
			// 비밀번호가 일치하지 않으면 예외 처리 또는 특정 값을 반환하도록 설정
			throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
		}
	}
	*/
	
	
	@Operation(summary = "호텔 큐앤에이 수정")
	@PutMapping("/update/{qnaNo}")
	public ResponseEntity<HotelQnAUpdateDto> update(@PathVariable(name = "qnaNo") Long qnaNo, @RequestBody HotelQnAUpdateDto dto) {

		HotelQnA find = hotelQnAService.findByQnANo(qnaNo);

		if (find != null) {
			if (dto.getQnaTitle() != null) {
				find.setQnaTitle(dto.getQnaTitle());
			}
			if (dto.getQnaContent() != null) {
				find.setQnaContent(dto.getQnaContent());
			}
			hotelQnAService.updateQnA(find);
			return new ResponseEntity<HotelQnAUpdateDto>(HotelQnAUpdateDto.toDto(find), HttpStatus.OK);
		} else {
			return new ResponseEntity<HotelQnAUpdateDto>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@Operation(summary = "호텔 큐앤에이 번호로 삭제 (관리자)")
	@DeleteMapping("/delete")
	public void delete(@RequestBody HotelQnADto dto) {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		hotelQnAService.deleteByQnANo(dto.getQnaNo());
	}
	
	
	@Operation(summary = "호텔 큐앤에이 전체 리스트")
	@GetMapping("/qnaList")
	public ResponseEntity<List<HotelQnAListDto>> findAll() {
		List<HotelQnA> qnaList = hotelQnAService.findAllQnA();
		List<HotelQnAListDto> qnaDtoList = new ArrayList<>();
		
		for (HotelQnA qna : qnaList) {
			HotelQnAListDto qnaDto = HotelQnAListDto.toDto(qna);
			qnaDtoList.add(qnaDto);
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<>(qnaDtoList, httpHeaders, HttpStatus.OK);
	}
	
	
	@Operation(summary = "내가 작성한 모든 큐앤에이 리스트")
	@GetMapping("/myQnAList/{userNo}")
	public ResponseEntity<List<HotelQnADto>> findByUserNo(@PathVariable(name = "userNo") Long userNo) {
		List<HotelQnA> qnaList = hotelQnAService.findByUserinfoUserNo(userNo);
		List<HotelQnADto> qnaDtoList = new ArrayList<HotelQnADto>();
		
		for (HotelQnA qna : qnaList) {
			qnaDtoList.add(HotelQnADto.toDto(qna));
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<List<HotelQnADto>>(qnaDtoList, httpHeaders, HttpStatus.OK);
	}
	
	
	@Operation(summary = "호텔별 모든 큐앤에이 리스트")
	@GetMapping("/hotelQnAList/{hotelNo}")
	public ResponseEntity<List<HotelQnADto>> findByHotelNo(@PathVariable(name = "hotelNo") Long hotelNo) {
		List<HotelQnA> qnaList = hotelQnAService.findByHotelHotelNo(hotelNo);
		List<HotelQnADto> qnaDtoList = new ArrayList<HotelQnADto>();
		
		for (HotelQnA qna : qnaList) {
			qnaDtoList.add(HotelQnADto.toDto(qna));
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<HotelQnADto>>(qnaDtoList, httpHeaders, HttpStatus.OK);
	}
	
	
	@Operation(summary = "호텔 큐앤에이 이름으로 검색")
	@PostMapping("/qnaNameSearch")
	public ResponseEntity<List<HotelQnADto>> nameSearch(@RequestBody HotelQnADto dto) {
		List<HotelQnA> qnaList = hotelQnAService.findByHotel_HotelNoAndQnaNameContaining(dto.getHotelNo(), dto.getQnaName());
		List<HotelQnADto> qnaDtoList = new ArrayList<HotelQnADto>();
		
		for (HotelQnA qna : qnaList) {
			HotelQnADto qnaDto = HotelQnADto.toDto(qna);
			qnaDtoList.add(qnaDto);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<HotelQnADto>>(qnaDtoList, httpHeaders, HttpStatus.OK);
	}
	
	
	@Operation(summary = "호텔 큐앤에이 제목으로 검색")
	@PostMapping("/qnaTitleSearch")
	public ResponseEntity<List<HotelQnADto>> titleSearch(@RequestBody HotelQnADto dto) {
		List<HotelQnA> qnaList = hotelQnAService.findByHotel_HotelNoAndQnaTitleContaining(dto.getHotelNo(), dto.getQnaTitle());
		List<HotelQnADto> qnaDtoList = new ArrayList<HotelQnADto>();
		
		for (HotelQnA qna : qnaList) {
			HotelQnADto qnaDto = HotelQnADto.toDto(qna);
			qnaDtoList.add(qnaDto);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<HotelQnADto>>(qnaDtoList, httpHeaders, HttpStatus.OK);
	}
	
	// 비밀글 체크
	@PostMapping("/secretCheck")
	public ResponseEntity<HotelQnADto> secretCheck(@RequestBody HotelQnADto dto) {
		HotelQnA hotelQnA = hotelQnAService.findByQnANo(dto.getQnaNo());
		Integer hotelQnASecretCheck = hotelQnA.getQnaSecretCheck();
		
		dto.setQnaSecretCheck(hotelQnASecretCheck);
		dto.setQnaStatus(hotelQnA.getQnaStatus());
		dto.setQnaAnswer(hotelQnA.getQnaAnswer());
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<HotelQnADto>(dto, httpHeaders, HttpStatus.OK);
	}
	
	// 문의 리스트 페이징
	@PostMapping("/qnaList")
	public ResponseEntity<List<HotelQnAPageDto>> QnaList(@RequestBody HotelQnAPageDto dto) {
		List<HotelQnA> hotelQnAList = hotelQnAService.findByHotelHotelNoOrderByQnaNoDesc(dto.getHotelNo());
		List<HotelQnAPageDto> ViewList = new ArrayList<HotelQnAPageDto>();
		Integer page = dto.getPage();
		int pageSize = 10;
		double totalPage = (double)hotelQnAList.size() / (double)pageSize;
		totalPage = Math.ceil(totalPage);
		int intTotalPage = (int) totalPage;
			
		List<HotelQnAPageDto> previousList = new ArrayList<HotelQnAPageDto>();
		List<HotelQnAPageDto> nextList = new ArrayList<HotelQnAPageDto>();
		
		for (int i = 0; i < hotelQnAList.size(); i++) {
			if(i >= pageSize*(page-2) && i < pageSize*(page-1)) {
				HotelQnAPageDto toDto = HotelQnAPageDto.toDto(hotelQnAList.get(i));
				previousList.add(toDto);
			}
		}
		
		for (int i = 0; i < hotelQnAList.size(); i++) {
			if(i >= pageSize*(page) && i < pageSize*(page+1)) {
				HotelQnAPageDto toDto = HotelQnAPageDto.toDto(hotelQnAList.get(i));
				nextList.add(toDto);
			}
		}
		
		for (int i = 0; i < hotelQnAList.size(); i++) {
			if(i >= pageSize*(page-1) && i < pageSize*page) {
				HotelQnAPageDto toDto = HotelQnAPageDto.toDto(hotelQnAList.get(i));
				toDto.setPage(page);
				toDto.setPageSize(page);
				toDto.setTotalPage(intTotalPage);
				toDto.setNextSize(nextList.size());
				toDto.setPreSize(previousList.size());
				ViewList.add(toDto);
			}
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<HotelQnAPageDto>>(ViewList, httpHeaders, HttpStatus.OK);
	}
	
}
