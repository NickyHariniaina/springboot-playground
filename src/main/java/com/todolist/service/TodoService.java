package com.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.model.TodoModel;
import com.todolist.repository.TodoRepository;

/**
 * TodoService
 */
@Service
public class TodoService {

  @Autowired
  TodoRepository todoRepository;

  public List<TodoModel> getAllTodos() {
    return todoRepository.findAll();
  }

  public Optional<TodoModel> getTodoById(int id) {
    return todoRepository.findById(id);
  }

  public Optional<TodoModel> getTodoByUserId(int userId) {
    return Optional.ofNullable(todoRepository.findByUserId(userId));
  }

  public void deleteTodo(int id) {
    todoRepository.deleteById(id);
  }

  public TodoModel createTodo(TodoModel todo) {
    return todoRepository.save(todo);
  }

  public TodoModel updateTodo(TodoModel todo) {
    return todoRepository.save(todo);
  }
}
