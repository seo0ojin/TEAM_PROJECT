package com.jeju.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.jeju.entity.Userinfo;
import com.jeju.repository.UserinfoRepository;

@Repository
public class UserinfoDaoImpl implements UserinfoDao {

	@Autowired
	UserinfoRepository userinfoRepository;

	// 회원가입
	@Override
	public Userinfo createUser(Userinfo userinfo) {

		return userinfoRepository.save(userinfo);
	}

	// 회원탈퇴
	@Override
	public void deleteUserByNo(Long userNo) {
		
		userinfoRepository.deleteById(userNo);
	}

	// 회원수정
	@Override
	public Userinfo updateUser(Userinfo userinfo) {

		return userinfoRepository.save(userinfo);
	}

	// 회원리스트
	@Override
	public List<Userinfo> findAll() {
		
		return userinfoRepository.findAll();
	}

	// 회원상세보기
	@Override
	public Userinfo findByUserNo(Long userNo) {
		
		return userinfoRepository.findById(userNo).get();
	}

	// 아이디로 회원 찾기
	public Userinfo findByUserId(String userId) {
		
		return userinfoRepository.findByUserId(userId);
	}
	
	// 아이디 중복체크
	@Override
	public Integer countByUserId(String userId) {
		
		return userinfoRepository.countByUserId(userId);
	}

	// 아이디 찾기
	@Override
	public List<Userinfo> findByUserNameAndUserResident(String userName, String userResident) {
		
		return userinfoRepository.findByUserNameAndUserResident(userName, userResident);
	}

	// 비밀번호 찾기
	@Override
	public Userinfo findByUserIdAndUserResident(String userId, String userResident) {
		
		return userinfoRepository.findByUserIdAndUserResident(userId, userResident);
	}

	// 페이징
	@Override
	public Page<Userinfo> findAllPage(Pageable pageable) {
		
		Page<Userinfo> userList = userinfoRepository.findAll(pageable);
		
		return userList;
	}
	
}
