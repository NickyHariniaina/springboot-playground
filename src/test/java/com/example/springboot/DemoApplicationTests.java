package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.model.User;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
    User user = User.builder();
	}

}
