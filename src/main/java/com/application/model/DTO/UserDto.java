package com.application.model.DTO;

import com.application.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
@SuppressWarnings(value = "all")
public class UserDto {

  private String id;
  private String firstname;
  private String lastname;
  private String email;
  private String ref;

  public static UserDto from(User user) {
    return UserDto.builder()
        .id(user.getId())
        .firstname(user.getFirstname())
        .lastname(user.getLastname())
        .email(user.getEmail())
        .ref(user.getRef())
        .build();
  }
}
