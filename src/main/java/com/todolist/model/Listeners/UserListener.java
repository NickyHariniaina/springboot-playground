package com.todolist.model.Listeners;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.todolist.model.UserModel;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

/**
 * UserListener
 */
@Component
public class UserListener {

  @PrePersist
  public void setCreatedDate(UserModel user) {
    user.setCreatedAt(LocalDateTime.now());
  }

  @PreUpdate
  public void setUpdatedDate(UserModel user) {
    user.setUpdatedAt(LocalDateTime.now());
  }
}
