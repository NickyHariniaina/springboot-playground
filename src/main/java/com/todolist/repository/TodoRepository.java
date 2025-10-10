package com.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.todolist.model.TodoModel;
/**
 * TodoRepository
 */
public interface TodoRepository extends JpaRepository<TodoModel, Integer> {
  TodoModel findByTitle(String title);
  TodoModel findByDescription(String description);
  TodoModel findByCompleted(boolean completed);
  TodoModel findByUserId(int userId);
}
