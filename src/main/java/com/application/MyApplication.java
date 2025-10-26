package com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.application.model.User;

@SpringBootApplication
@SuppressWarnings("all")
public class MyApplication {
  public static void main(String[] args) {
    System.out.println("we are running our new app.");
    SpringApplication.run(MyApplication.class, args);
    User user = User.builder();
  }
}
