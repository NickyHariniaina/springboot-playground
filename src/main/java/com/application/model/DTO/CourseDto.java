package com.application.model.DTO;

import com.application.model.Course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class CourseDto {

  private String id;
  private String name;
  private Integer credits;
  private Integer totalHours;

  public static CourseDto from(Course course) {
    return CourseDto.builder()
        .id(course.getId())
        .name(course.getName())
        .credits(course.getCredits())
        .totalHours(course.getTotalHours());
  }
}
