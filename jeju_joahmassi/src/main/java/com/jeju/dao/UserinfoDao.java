package com.jeju.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jeju.entity.Userinfo;

public interface UserinfoDao {

	// 회원가입
	public Userinfo createUser(Userinfo userinfo);
	
	// 회원탈퇴
	public void deleteUserByNo(Long userNo);
	
	// 회원수정
	public Userinfo updateUser (Userinfo userinfo);
	
	// 회원리스트
	public List<Userinfo> findAll();
	
	// 회원상세보기
	public Userinfo findByUserNo(Long userNo);
	
	// 아이디로 회원 찾기
	public Userinfo findByUserId(String userId);
	
	// 아이디 중복체크
	public Integer countByUserId(String userId);
	
	// 아이디 찾기
	public List<Userinfo> findByUserNameAndUserResident(String userName, String userResident);
	
	// 비밀번호 찾기
	public Userinfo findByUserIdAndUserResident(String userId, String userResident);
	
	// 페이징
	public Page<Userinfo> findAllPage(Pageable pageable);
}
