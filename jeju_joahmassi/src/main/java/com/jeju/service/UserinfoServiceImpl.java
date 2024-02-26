package com.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeju.dao.UserinfoDao;
import com.jeju.entity.Userinfo;
import com.jeju.exception.ExistedUserException;
import com.jeju.exception.IdCheckException;
import com.jeju.exception.IdNotFoundException;
import com.jeju.exception.UserNotFoundException;

@Service
@Transactional
public class UserinfoServiceImpl implements UserinfoService {
	
	@Autowired
	private UserinfoDao userinfoDao;

	// 회원가입
	@Override
	public Userinfo createUser(Userinfo userinfo) throws Exception {
		
		if (userinfoDao.countByUserId(userinfo.getUserId()) > 0) {
			ExistedUserException exception = new ExistedUserException(userinfo.getUserId() + "는 이미 존재하는 아이디입니다.");
			exception.setData(userinfo);
			throw exception;
		}
		
		return userinfoDao.createUser(userinfo);
	}

	// 회원탈퇴
	@Override
	public void deleteUserByNo(Long userNo) {
		
		userinfoDao.deleteUserByNo(userNo);
	}

	// 회원수정
	@Override
	public Userinfo updateUser(Userinfo userinfo) {
		
		return userinfoDao.updateUser(userinfo);
	}

	// 회원리스트
	@Override
	public List<Userinfo> findAll() {
		
		return userinfoDao.findAll();
	}

	// 회원상세보기
	@Override
	public Userinfo findByUserNo(Long userNo) {
		
		return userinfoDao.findByUserNo(userNo);
	}

	// 아이디 중복체크
	@Override
	public boolean countByUserId(String userId) {
		int count = userinfoDao.countByUserId(userId);
		
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	// 아이디 찾기
	@Override
	public List<Userinfo> findByUserNameAndUserResident(String userName, String userResident) throws Exception {
		List<Userinfo> findUser = userinfoDao.findByUserNameAndUserResident(userName, userResident);
		Userinfo fUser = Userinfo.builder().userName(userName).userResident(userResident).build();
		
		if (findUser.isEmpty()) {
			IdNotFoundException exception = new IdNotFoundException("아이디가 존재하지 않습니다.");
			exception.setData(fUser);
			throw exception;
		}
		
		return findUser;
	}

	// 비밀번호 찾기
	@Override
	public Userinfo findByUserIdAndUserResident(String userId, String userResident) throws Exception {
		Userinfo findUser = userinfoDao.findByUserIdAndUserResident(userId, userResident);
		Userinfo fUser = Userinfo.builder().userId(userId).userResident(userResident).build();
		
		if (findUser == null) {
			IdCheckException exception = new IdCheckException("아이디를 다시 확인해주세요.");
			exception.setData(fUser);
			throw exception;
		}
		
		return findUser;
	}

	// 페이징
	@Override
	public Page<Userinfo> findAllPage(Pageable pageable) {
		
		return userinfoDao.findAllPage(pageable);
	}

	// 로그인
	@Override
	public Userinfo login(String userId, String userPassword) throws Exception {
		Userinfo userInfo = userinfoDao.findByUserId(userId);
		Userinfo fUser = Userinfo.builder().userId(userId).userPassword(userPassword).build();
		
		if (userInfo == null) {
			IdNotFoundException exception = new IdNotFoundException("아이디가 존재하지 않습니다.");
			exception.setData(fUser);
			throw exception;
		}
		
		String password = userInfo.getUserPassword();
		
		if (!(password.equals(userPassword))) {
			UserNotFoundException exception = new UserNotFoundException("입력한 아이디나 비밀번호가 올바르지 않습니다.");
			exception.setData(fUser);
			throw exception;
		}
		
		return userInfo;
	}

}
