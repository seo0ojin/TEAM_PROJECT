package com.jeju.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jeju.entity.Userinfo;

public interface UserinfoService {

	// 회원가입
	public Userinfo createUser(Userinfo userinfo) throws Exception;
	
	// 회원탈퇴
	public void deleteUserByNo(Long userNo);
	
	// 회원수정
	public Userinfo updateUser (Userinfo userinfo);
	
	// 회원리스트
	public List<Userinfo> findAll();
	
	// 회원상세보기
	public Userinfo findByUserNo(Long userNo);
	
	// 아이디 중복체크
	public boolean countByUserId(String userId);
	
	// 아이디 찾기
	public List<Userinfo> findByUserNameAndUserResident(String userName, String userResident) throws Exception;
	
	// 비밀번호 찾기
	public Userinfo findByUserIdAndUserResident(String userId, String userResident) throws Exception;
	
	// 페이징
	public Page<Userinfo> findAllPage(Pageable pageable);
	
	// 로그인
	Userinfo login(String userId, String userPassword) throws Exception;
	
}
