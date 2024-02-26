package com.jeju.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.jeju.JejuJoahmassiApplicationTests;
import com.jeju.entity.Userinfo;

import jakarta.transaction.Transactional;

class UserinfoServiceImplTest extends JejuJoahmassiApplicationTests{
	
	@Autowired
	UserinfoService userinfoService;

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testCreateUser() throws Exception {
		Userinfo userinfo1 = Userinfo.builder()
							.userId("ffff")
							.userPassword("ffff")
							.userPhone("010-1234-1234")
							.userResident("111203-1111111")
							.build();
		userinfoService.createUser(userinfo1);
		
		Userinfo userinfo2 = Userinfo.builder()
				.userId("bbbb")
				.userPassword("bbbb")
				.userPhone("010-1234-1234")
				.build();
		userinfoService.createUser(userinfo2);
		
		Userinfo userinfo3 = Userinfo.builder()
				.userId("cccc")
				.userPassword("cccc")
				.userPhone("010-1234-1234")
				.build();
		userinfoService.createUser(userinfo3);
		
	}

	@Test
	@Disabled
	void testDeleteUserByNo() {
		userinfoService.deleteUserByNo(18L);
	}

	@Test
	@Disabled
	void testUpdateUser() {
		Userinfo userinfo = userinfoService.findByUserNo(17L);
		userinfo.setUserName("dddd");
		userinfoService.updateUser(userinfo);
	}

	@Test
	@Disabled
	@Transactional
	void testFindAll() {
		System.out.println(userinfoService.findAll());
	}

	@Test
	@Disabled
	@Transactional
	void testFindByUserNo() {
		System.out.println(userinfoService.findByUserNo(17L));
	}

	@Test
	@Disabled
	@Transactional
	void testCountByUserId() {
		System.out.println(userinfoService.countByUserId("ffff"));
	}

	@Test
	@Disabled
	@Transactional
	void testFindUserIdByUserNmaeAndPhone() throws Exception {
		//System.out.println(userinfoService.findUserIdByUserNmaeAndPhone("박서진", "010-1234-1234"));
	}

	@Test
	@Disabled
	@Transactional
	void testFindUserPasswordByUserIdAndPhone() throws Exception {
		//System.out.println(userinfoService.findUserPasswordByUserIdAndPhone("seojin", "010-1234-1234"));
	}

	@Test
	@Disabled
	@Transactional
	void testFindAllPage() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	@Transactional
	void testLogin() throws Exception {
		System.out.println(userinfoService.login("aaaa", "bbbb"));
	}

}
