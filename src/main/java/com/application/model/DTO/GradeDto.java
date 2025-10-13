package com.application.model.DTO;

import com.application.model.Grade;
import com.application.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class GradeDto {
  private String id;
  private User user;

  public static GradeDto from(Grade grade) {
    return GradeDto.builder().id(grade.getId()).user(grade.getUser());
  }
}
