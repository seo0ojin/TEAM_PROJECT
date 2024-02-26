package com.jeju.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeju.dto.RestaurantBooking1Dto;
import com.jeju.dto.RestaurantBookingDto;
import com.jeju.entity.Restaurant;
import com.jeju.entity.RestaurantBooking;
import com.jeju.entity.RestaurantImage;
import com.jeju.entity.Userinfo;
import com.jeju.service.RestaurantBookingService;
import com.jeju.service.RestaurantImageService;
import com.jeju.service.RestaurantService;
import com.jeju.service.UserinfoService;

import jakarta.servlet.http.HttpSession;


@Controller
public class RestaurantBookingController {
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private RestaurantImageService restaurantImageService;
	@Autowired
	private RestaurantBookingService restaurantBookingService;
	@Autowired
	private UserinfoService userinfoService;
	
	@GetMapping("/restaurantBooking1")
	public String restaurantBooking(@RequestParam(name="bookingDate")String bookingDate,
									@RequestParam(name="people")String people,
									@RequestParam(name="restaurantNo")String restaurantNo,
									@RequestParam(name="bookingTime")String bookingTime,Model model,HttpSession session) {
		
		Long parseRestaurantNo = Long.parseLong(restaurantNo);
		Restaurant findRestaurant = restaurantService.findByNo(parseRestaurantNo);
		String restaurantName = findRestaurant.getRestaurantName();
		String restaurantAddress = findRestaurant.getRestaurantAddress();
		List<RestaurantImage> imageList = restaurantImageService.findByRestaurantRestaurantNo(parseRestaurantNo);
		
		model.addAttribute("bookingDate", bookingDate );
		model.addAttribute("bookingTime", bookingTime );
		model.addAttribute("people", people);
		model.addAttribute("restaurantName", restaurantName );
		model.addAttribute("restaurantAddress", restaurantAddress );
		model.addAttribute("restaurantNo", restaurantNo);
		model.addAttribute("imageList", imageList);
		
		return "html/restaurant/restaurant-booking1";
	}
	@GetMapping("/restaurantBooking2")
	public String restaurantBooking2(@RequestParam(name="restaurantNo")String restaurantNo,
									 @RequestParam(name="restaurantBooking1Name")String restaurantBooking1Name,
									 @RequestParam(name="restaurantBooking1Phone")String restaurantBooking1Phone,
									 @RequestParam(name="restaurantBooking1Date")String restaurantBooking1Date,
									 @RequestParam(name="restaurantBooking1Time")String restaurantBooking1Time,
									 @RequestParam(name="restaurantBooking1Personnel")String restaurantBooking1Personnel,Model model,HttpSession session) {
		
		Long parseRestaurantNo = Long.parseLong(restaurantNo);
		Restaurant findRestaurant = restaurantService.findByNo(parseRestaurantNo);
		String restaurantName = findRestaurant.getRestaurantName();
		String restaurantAddress = findRestaurant.getRestaurantAddress();
		String restaurantPhone = findRestaurant.getRestaurantTel();	
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        LocalDate date = LocalDate.parse(restaurantBooking1Date, formatter);
		
        Long userNo = (Long)session.getAttribute("userNo");
        Userinfo userinfo = userinfoService.findByUserNo(userNo);
        
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(restaurantBooking1Personnel);
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
            	if(time.equals(restaurantBooking1Time)) {
            		sameTime.add(restaurantBooking);
            	}
        	}
		}
        
        if(sameTime.size() == 0) {
        	bookingBool = true;
        }
        
		// 예약 하기
        RestaurantBooking restaurantBooking = null;
        if(bookingBool==true) {
        	restaurantBooking = new RestaurantBooking();
    		restaurantBooking.setRbDate(date);
    		restaurantBooking.setRbName(restaurantBooking1Name);
    		restaurantBooking.setRbPersons(people);
    		restaurantBooking.setRbPhone(restaurantBooking1Phone);
    		restaurantBooking.setRbTime(restaurantBooking1Time);
    		restaurantBooking.setRestaurant(findRestaurant);
    		restaurantBooking.setUserinfo(userinfo);
    		
    		RestaurantBooking booking = restaurantBookingService.insert(restaurantBooking);
    		model.addAttribute("bookingNo", booking.getRbNo() );
        }
		
		model.addAttribute("bookingUserName", restaurantBooking1Name );
		model.addAttribute("bookingDate", restaurantBooking1Date );
		model.addAttribute("bookingTime", restaurantBooking1Time );
		model.addAttribute("bookingUserPhone", restaurantBooking1Phone );
		model.addAttribute("people", restaurantBooking1Personnel);
		model.addAttribute("restaurantName", restaurantName );
		model.addAttribute("restaurantAddress", restaurantAddress );
		model.addAttribute("restaurantPhone", restaurantPhone );
		
		return "html/restaurant/restaurant-booking2";
	}
}
