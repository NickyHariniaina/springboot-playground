package com.todolist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolist.model.UserModel;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
  List<UserModel> findAllByUsernameContaining(String stringSlice);
  List<UserModel> findAllByEmailStartingWith(String stringSlice);
  List<UserModel> findAllByEmailLike(String stringSlice);
  Optional<UserModel> findByUsername(String username);
  Optional<UserModel> findByEmail(String email);
  boolean existsByEmail(String email);
  boolean existsByUsername(String username);
}
