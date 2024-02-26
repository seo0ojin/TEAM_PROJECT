package com.jeju.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeju.entity.Userinfo;

public interface UserinfoRepository extends JpaRepository<Userinfo, Long> {
	
	// 아이디 중복체크
	Integer countByUserId(String userId);
	
	// 아이디 찾기
	List<Userinfo> findByUserNameAndUserResident(String userName, String userResident);
	
	// 비밀번호 찾기
	Userinfo findByUserIdAndUserResident(String userId, String userResident);
	
	// 아이디로 회원 찾기
	Userinfo findByUserId(String userId);
}
