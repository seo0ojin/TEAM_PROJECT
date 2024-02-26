package com.jeju.controller;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeju.dto.RestaurantBookingDeleteDto;
import com.jeju.dto.RestaurantBookingDto;
import com.jeju.dto.RestaurantBookingInsertDto;
import com.jeju.dto.RestaurantBookingUpdateDto;
import com.jeju.dto.RestaurantMenuInsertDto;
import com.jeju.dto.RestaurantTimeDto;
import com.jeju.dto.RestaurantTimeDto2;
import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantBooking;
import com.jeju.entity.Userinfo;
import com.jeju.service.RestaurantBookingService;
import com.jeju.service.RestaurantService;
import com.jeju.service.UserinfoService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/restaurantBooking")
public class RestaurantBookingRestController {
	
	@Autowired
	private RestaurantBookingService restaurantBookingService;
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private UserinfoService userinfoService;
	
	@PostMapping("/insert")
	public ResponseEntity<RestaurantBookingInsertDto> insert(@RequestBody RestaurantBookingInsertDto dto) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		restaurantBookingService.insert(RestaurantBookingInsertDto.toEntity(dto));
		return new ResponseEntity<RestaurantBookingInsertDto>(dto, httpHeaders, HttpStatus.CREATED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<RestaurantBookingUpdateDto> update(@RequestBody RestaurantBookingUpdateDto dto) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		if(restaurantBookingService.findByNo(dto.getRbNo())!=null) {
			restaurantBookingService.update(RestaurantBookingUpdateDto.toEntity(dto));
		}
		return new ResponseEntity<RestaurantBookingUpdateDto>(dto, httpHeaders, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<RestaurantBookingDeleteDto> delete(@RequestBody RestaurantBookingDeleteDto dto, HttpSession session) {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		RestaurantBooking findBooking = restaurantBookingService.findByNo(dto.getRbNo());
		Long findUserNo = findBooking.getUserinfo().getUserNo();
		Long loginUserNo = (Long) session.getAttribute("userNo");
		
		if (findUserNo.equals(loginUserNo)) {
			restaurantBookingService.deleteByNo(RestaurantBookingDeleteDto.toEntity(dto).getRbNo());
		}
		
		return new ResponseEntity<RestaurantBookingDeleteDto>(dto, httpHeaders, HttpStatus.OK);
	}
	
	@PostMapping("/duplication")
	public ResponseEntity<RestaurantBookingDto> duplication(@RequestBody RestaurantBookingDto dto , HttpSession session) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		Long parseRestaurantNo = Long.parseLong(dto.getRestaurantNo());
		Restaurant findRestaurant = restaurantService.findByNo(parseRestaurantNo);
		String restaurantName = findRestaurant.getRestaurantName();
		String restaurantAddress = findRestaurant.getRestaurantAddress();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        LocalDate date = LocalDate.parse(dto.getRestaurantBooking1Date(), formatter);
		
        Long userNo = (Long)session.getAttribute("userNo");
        Userinfo userinfo = userinfoService.findByUserNo(userNo);
        
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(dto.getRestaurantBooking1Personnel());
        Integer people = 0;
        // 매칭된 숫자가 있으면 출력
        if (matcher.find()) {
            String numberStr = matcher.group();
            Integer personnel = Integer.valueOf(numberStr);
            people = personnel;
        } else {
            System.out.println("숫자가 없거나 매칭되지 않았습니다.");
        }
        
        List<RestaurantBooking> findRestaurantBookingList = restaurantBookingService.findByUserinfoUserNoAndRestaurantRestaurantNo(userNo, parseRestaurantNo);
        List<RestaurantBooking> sameTime = new ArrayList<RestaurantBooking>();
        
        // 같은시간 중복예약 체크
        boolean bookingBool = false;
        for (RestaurantBooking restaurantBooking : findRestaurantBookingList) {
        	if( restaurantBooking.getRbDate().getDayOfYear() == date.getDayOfYear() && restaurantBooking.getRbDate().getMonth() == date.getMonth()
        			&& restaurantBooking.getRbDate().getDayOfMonth() == date.getDayOfMonth()) {
        		
        		String time = restaurantBooking.getRbTime();
            	if(time.equals(dto.getRestaurantBooking1Time())) {
            		sameTime.add(restaurantBooking);
            	}
        	}
		}
        
        if(sameTime.size() == 0) {
        	bookingBool = true;
        }
        
		// 예약 하기
        RestaurantBooking restaurantBooking = null;
        RestaurantBooking booking = null;
        if(bookingBool==true) {
        	restaurantBooking = new RestaurantBooking();
    		restaurantBooking.setRbDate(date);
    		restaurantBooking.setRbName(dto.getRestaurantBooking1Name());
    		restaurantBooking.setRbPersons(people);
    		restaurantBooking.setRbPhone(dto.getRestaurantBooking1Phone());
    		restaurantBooking.setRbTime(dto.getRestaurantBooking1Time());
    		restaurantBooking.setRestaurant(findRestaurant);
    		restaurantBooking.setUserinfo(userinfo);
    		
    		//booking = restaurantBookingService.insert(restaurantBooking);
    		dto.setStatus(1000);
        }else {
        	dto.setStatus(1001);
        }
		
        
		return new ResponseEntity<RestaurantBookingDto>(dto, httpHeaders, HttpStatus.OK);
	}
	
	// 식당 남은시간 체크해서 드랍아이템 hide
	@PostMapping("/timeCheck")
	public ResponseEntity<List<String>> TimeCheck(@RequestBody @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") RestaurantTimeDto dto) {
		List<RestaurantBooking> restaurantBookingList = restaurantBookingService.findByRestaurantRestaurantNo(dto.getRestaurantNo());
		List<String> timeList = new ArrayList<String>();
		for (RestaurantBooking restaurantBooking : restaurantBookingList) {
			if(restaurantBooking.getRbDate().equals(dto.getRbDate().plusDays(1))) {
				String time = restaurantBooking.getRbTime();
				timeList.add(time);
			}
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<String>>(timeList, httpHeaders, HttpStatus.OK);
	}
	
	// 식당 남은시간 체크해서 날짜 비활성화
	@PostMapping("/timeCheck2")
	public ResponseEntity<List<String>> TimeCheck2(@RequestBody RestaurantTimeDto2 dto) {
		List<RestaurantBooking> restaurantBookingList = restaurantBookingService.findByRestaurantRestaurantNo(dto.getRestaurantNo());
		List<String> timeList = new ArrayList<String>();
		for (RestaurantBooking restaurantBooking : restaurantBookingList) {
			if(restaurantBooking.getRbDate().equals(dto.getRbDate())) {
				String time = restaurantBooking.getRbTime();
				timeList.add(time);
			}
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<List<String>>(timeList, httpHeaders, HttpStatus.OK);
	}
}
