package com.application.endpoint.rest.controller;

import com.application.model.User;
import com.application.service.UserService;

import jakarta.validation.Valid;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** UserCotroller */
@RestController
@RequestMapping("api/users")
public class UserCotroller {

  @Autowired private UserService userService;

  @GetMapping
  public List<User> getUsers() {
    return userService.getAllUser();
  }

  @PostMapping
  public void createUser(@RequestBody @Valid User user) {
    userService.createUser(user);
  }
}
