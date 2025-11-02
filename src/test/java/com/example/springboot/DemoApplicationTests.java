package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.model.Group;
import com.application.model.User;

@SpringBootTest
class DemoApplicationTests {

  @Test
  void contextLoads() {
    User user = User.builder().firstname("Nicky").lastname("Manthai").email("nicky@gmail.com").build();
    System.out.println(user.getFirstname());
    System.out.println(user.getLastname());
    System.out.println(user.getEmail());
    Group group = Group.builder()
        .name("Spring Boot")
        .build();
    System.out.println(group.getName());
  }
}
