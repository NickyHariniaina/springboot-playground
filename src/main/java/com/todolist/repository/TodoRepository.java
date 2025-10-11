package com.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.todolist.model.TodoModel;
/**
 * TodoRepository
 */
public interface TodoRepository extends JpaRepository<TodoModel, Integer> {
}
