package com.todolist.model.Listeners;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.todolist.model.TodoModel;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

/**
 * TodoListener
 */
@Component
public class TodoListener {

  @PrePersist
  public void setCreatedDate(TodoModel todo) {
    todo.setCreatedAt(LocalDateTime.now());
  }

  @PreUpdate
  public void setUpdatedDate(TodoModel todo) {
    todo.setUpdatedAt(LocalDateTime.now());
  }
}
