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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jeju.dto.UserFindIdDto;
import com.jeju.dto.UserFindPasswordDto;
import com.jeju.dto.UserLoginActionDto;
import com.jeju.dto.UserUpdateDto;
import com.jeju.dto.UserWriteActionDto;
import com.jeju.entity.Coupon;
import com.jeju.entity.Userinfo;
import com.jeju.exception.ExistedUserException;
import com.jeju.exception.IdCheckException;
import com.jeju.exception.IdNotFoundException;
import com.jeju.exception.UserNotFoundException;
import com.jeju.service.CouponService;
import com.jeju.service.UserinfoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserinfoRestController {

	@Autowired
	private UserinfoService userInfoService;
	@Autowired
	private CouponService couponService;
	
	@PostMapping("/login")
	@Operation(summary = "로그인")
	public ResponseEntity<UserLoginActionDto> userLogin(@RequestBody UserLoginActionDto dto, HttpSession session) throws Exception {
		
		Userinfo login = userInfoService.login(dto.getUserId(), dto.getUserPassword());
		session.setAttribute("userNo", login.getUserNo());
		session.setAttribute("userName", login.getUserName());
		session.setAttribute("userEmail", login.getUserEmail());
		session.setAttribute("userPhone", login.getUserPhone());
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		dto.setStatus(1000);
		
		return new ResponseEntity<UserLoginActionDto>(dto, httpHeaders, HttpStatus.OK);
	}
	
	@GetMapping("/idCheck")
	@Operation(summary = "아이디 체크")
	public boolean userIdCheck(@RequestParam(name = "signupId") String signupId) {
		
		return !userInfoService.countByUserId(signupId);
	}
	
	/*
	@PostMapping("/write")
	@Operation(summary = "회원가입")
	public ResponseEntity<UserWriteActionDto> userCreate(@RequestBody UserWriteActionDto dto) throws Exception {
		
		dto.setUserPoint(0);
		
		Userinfo createUser = userInfoService.createUser(UserWriteActionDto.toEntity(dto));
		
		Coupon coupon = Coupon.builder()
				.couponName("가입축하쿠폰")
				.couponDiscount(10)
				.userinfo(createUser)
				.build();
		coupon.setCouponDate(30L);
		
		coupon = couponService.createCoupon(coupon);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<UserWriteActionDto>(dto, httpHeaders, HttpStatus.OK);
		
	}
	*/
	
	@PostMapping("/findId")
	public ResponseEntity<UserFindIdDto> findId(@RequestBody UserFindIdDto dto) throws Exception {
		
		List<Userinfo> findUser = userInfoService.findByUserNameAndUserResident(dto.getUserName(), dto.getUserResident());
		List<String> userId = new ArrayList<String>();
		
		for (Userinfo user : findUser) {
			userId.add(user.getUserId());
		}
		
		dto.setUserId(userId);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<UserFindIdDto>(dto, httpHeaders, HttpStatus.OK);
		
	}
	
	@PostMapping("/findPassword")
	public ResponseEntity<UserFindPasswordDto> findPassword(@RequestBody UserFindPasswordDto dto) throws Exception {
		
		Userinfo findUser = userInfoService.findByUserIdAndUserResident(dto.getUserId(), dto.getUserResident());

		dto.setUserPassword(findUser.getUserPassword());
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<UserFindPasswordDto>(dto, httpHeaders, HttpStatus.OK);
		
	}
	
	/*
	@DeleteMapping("/{userNo}")
	@Operation(summary = "회원탈퇴")
	public ResponseEntity<UserLoginActionDto> userDelete(@PathVariable(name = "userNo") Long userNo, HttpSession session) {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		
		if (session.getAttribute("userNo") != null) {
			userInfoService.deleteUserByNo(userNo);
			session.invalidate();
		}
		
		return new ResponseEntity<UserLoginActionDto>(httpHeaders, HttpStatus.OK);
	}
	*/
	
	/*
	@GetMapping("/logout")
	@Operation(summary = "회원로그아웃")
	public ResponseEntity<UserLoginActionDto> userLogout(UserLoginActionDto dto, HttpSession session) {
		
		if (session.getAttribute("userNo") != null) {
			session.invalidate();
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<UserLoginActionDto>(httpHeaders, HttpStatus.OK);
	}
	*/
	
	/*
	@GetMapping("/{userNo}")
	@Operation(summary = "회원정보보기")
	public ResponseEntity<UserWriteActionDto> userView(@PathVariable(name = "userNo") Long userNo, HttpSession session) throws Exception {
		
		UserWriteActionDto dto = UserWriteActionDto.builder().build();
		
		if (session.getAttribute("userNo") != null) {
			Userinfo loginUser = userInfoService.findByUserNo(userNo);
			dto.setUserNo(loginUser.getUserNo());
			dto.setUserId(loginUser.getUserId());
			dto.setUserPassword(loginUser.getUserPassword());
			dto.setUserName(loginUser.getUserName());
			dto.setUserResident(loginUser.getUserResident());
			dto.setUserPhone(loginUser.getUserPhone());
			dto.setUserRegisterDate(loginUser.getUserRegisterDate());
			dto.setUserPoint(loginUser.getUserPoint());
		} else {
			throw new Exception("로그인을 해주세요.");
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<UserWriteActionDto>(dto, httpHeaders, HttpStatus.OK);
	}
	*/
	
	
	@PutMapping("/update")
	@Operation(summary = "회원정보수정")
	public ResponseEntity<UserUpdateDto> updateUser(@RequestBody UserUpdateDto dto, HttpSession session) {
		Long userNo = (Long)session.getAttribute("userNo");
		
		if (userNo != null) {
			Userinfo userinfo = userInfoService.findByUserNo(userNo);
			if (dto.getUserPassword() != "" && dto.getUserPassword() != null) {
				userinfo.setUserPassword(dto.getUserPassword());
			}
			userinfo.setUserEmail(dto.getUserEmail());
			userinfo.setUserPhone(dto.getUserPhone());
			userInfoService.updateUser(userinfo);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<UserUpdateDto>(dto, httpHeaders, HttpStatus.OK);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ExistedUserException> userExistedExceptionHandler(ExistedUserException e) throws Exception {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<ExistedUserException>(e, httpHeaders, HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<UserInfoResponse> userNotFoundExceptionHandelr(UserNotFoundException e) throws Exception {
		
		UserInfoResponse response = new UserInfoResponse();
		response.setMessage("입력한 아이디나 비밀번호가 올바르지 않습니다.");
		response.setData(e.getData());
		response.setStatus(1001);
		
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));
		
		return new ResponseEntity<UserInfoResponse>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<UserInfoResponse> idNotFoundExceptionHandler(IdNotFoundException e) throws Exception {
		
		UserInfoResponse response = new UserInfoResponse();
		response.setMessage("아이디가 존재하지 않습니다.");
		response.setData(e.getData());
		response.setStatus(1002);
		
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));
		
		return new ResponseEntity<UserInfoResponse>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<UserInfoResponse> idCheckExceptionHandler(IdCheckException e) throws Exception {
		
		UserInfoResponse response = new UserInfoResponse();
		response.setMessage("아이디를 다시 확인해주세요.");
		response.setData(e.getData());
		response.setStatus(1003);
		
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));
		
		return new ResponseEntity<UserInfoResponse>(response, httpHeaders, HttpStatus.OK);
	}
}
