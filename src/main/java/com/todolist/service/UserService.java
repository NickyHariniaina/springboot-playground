package com.todolist.service;

import com.todolist.model.UserModel;
import com.todolist.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * UserService
 */
@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<UserModel> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<UserModel>  getUserById(int id) {
    return userRepository.findById(id);
  }

  public UserModel createUser(UserModel user) {
    return userRepository.save(user);
  }

  public UserModel updateUser(UserModel user) {
    return userRepository.save(user);
  }

  public void deletUser(int id) {
    userRepository.deleteById(id);
  }

  public Optional<UserModel> getUserByUsername(String username) {
    return Optional.ofNullable(userRepository.findByUsername(username));
  }

  public Optional<UserModel> getUserByEmail(String email) {
    return Optional.ofNullable(userRepository.findByEmail(email));
  }
}
