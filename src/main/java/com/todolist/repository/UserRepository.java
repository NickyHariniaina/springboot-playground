package com.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolist.model.UserModel;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
  UserModel findByUsername(String username);
  UserModel findByEmail(String email);
}
