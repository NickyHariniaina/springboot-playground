package com.application.model.DTO;

import com.application.model.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class GroupDto {
  private String id;
  private String name;
  private String ref;

  public static GroupDto from(Group group) {
    return GroupDto.builder().id(group.getId()).name(group.getName()).ref(group.getRef());
  }
}
