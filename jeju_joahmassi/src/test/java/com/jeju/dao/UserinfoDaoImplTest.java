package com.jeju.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.entity.Userinfo;

import jakarta.transaction.Transactional;

class UserinfoDaoImplTest extends JejuJoahmassiApplicationTests {
	
	@Autowired
	UserinfoDao userinfoDao;

	// 회원가입
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void testCreateUser() {
		Userinfo userinfo1 = Userinfo.builder()
							.userId("seojin")
							.userName("박서진")
							.userPhone("010-1234-1234")
							.build();
		System.out.println(userinfo1);
		userinfoDao.createUser(userinfo1);
		
		Userinfo userinfo2 = Userinfo.builder()
				.userId("seojin2")
				.userName("박서진2")
				.userPhone("010-1234-1234")
				.build();
		System.out.println(userinfo2);
		userinfoDao.createUser(userinfo2);
		
		Userinfo userinfo3 = Userinfo.builder()
				.userId("seojin3")
				.userName("박서진3")
				.userPhone("010-1234-1234")
				.build();
		System.out.println(userinfo3);
		userinfoDao.createUser(userinfo3);
	}

	// 회원탈퇴
	@Test
	@Disabled
	void testDeleteUserByNo() {
		userinfoDao.deleteUserByNo(1L);
	}

	// 회원수정
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testUpdateUser() {
		Userinfo userinfo = userinfoDao.findByUserNo(3L);
		userinfo.setUserName("박서진4");
		userinfoDao.updateUser(userinfo);
	}

	// 회원리스트
	@Test
	@Disabled
	@Transactional
	void testFindAll() {
		System.out.println(userinfoDao.findAll());
	}

	// 회원상세보기
	@Test
	@Transactional
	@Disabled
	void testFindByUserNo() {
		System.out.println(userinfoDao.findByUserNo(8L));
	}
	
	// 아이디로 회원 찾기
	@Test
	@Disabled
	@Transactional
	void testFindByUserId() {
		System.out.println(userinfoDao.findByUserId("seojin"));
	}

	// 아이디 중복체크
	@Test
	@Disabled
	@Transactional
	void testCountByUserId() {
		System.out.println(userinfoDao.countByUserId("seojin3"));
	}

	// 아이디 찾기
	@Test
	@Disabled
	@Transactional
	void testFindUserIdByUserNmaeAndPhone() {
		//System.out.println(userinfoDao.findUserIdByUserNmaeAndPhone("박서진3", "010-1234-1234"));
	}

	// 비밀번호 찾기
	@Test
	@Disabled
	@Transactional
	void testFindUserPasswordByUserIdAndPhone() {
		//System.out.println(userinfoDao.findUserPasswordByUserIdAndPhone("seojin2", "010-1234-1234"));
	}

	// 페이징
	@Test
	@Disabled
	void testFindAllPage() {
		fail("Not yet implemented");
	}

}
