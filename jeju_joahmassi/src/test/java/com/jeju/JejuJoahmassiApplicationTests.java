package com.jeju;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jeju.service.RestaurantService;

@SpringBootTest
public class JejuJoahmassiApplicationTests {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Test
	void contextLoads() {
		restaurantService.findAll();
	}

}
