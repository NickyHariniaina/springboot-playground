package com.application.service;

import com.application.model.User;
import com.application.model.Group;
import com.application.model.exception.NotFoundException;
import com.application.repository.GroupRepository;
import com.application.repository.UserRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

  private UserRepository userRepository;
  private GroupRepository groupRepository;


  public Optional<User> getUserById(String id) {
    return userRepository.findById(id);
  }

  public Optional<User> getUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  public Optional<User> getUserByRef(String ref) {
    return userRepository.findByRef(ref);
  }

  public Optional<User> getUserByFirstname(String firstname) {
    return userRepository.findByFirstname(firstname);
  }

  public Optional<User> getUserByLastname(String lastname) {
    return userRepository.findByLastname(lastname);
  }

  public Optional<User> findById(String id) {
    return userRepository.findById(id);
  }

  public Optional<User> findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  public Optional<User> findByRef(String ref) {
    return userRepository.findByRef(ref);
  }

  public Optional<User> findByFirstname(String firstname) {
    return userRepository.findByFirstname(firstname);
  }

  public Optional<User> findByLastname(String lastname) {
    return userRepository.findByLastname(lastname);
  }

  public List<User> findAllByStatus(User.Status status, Pageable pageable) {
    return userRepository.findAllByStatus(status, pageable);
  }

  public List<User> findAllByStatusAndSex(User.Status status, User.Sex sex, Pageable pageable) {
    return userRepository.findAllByStatusAndSex(status, sex, pageable);
  }

  public List<User> findAllByUsernameStartingWith(String username, Pageable pageable) {
    return userRepository.findAllByUsernameStartingWith(username, pageable);
  }

  public List<User> findByUsernameStartingWith(String username, Pageable pageable) {
    return userRepository.findAllByUsernameStartingWith(username, pageable);
  }

  public void createUser(User user) {
    userRepository.save(user);
  }

  public List<User> getAllUser() {
    return userRepository.findAll();
  }

  @Transactional
  public void insertUserIntoGroup(String groupId, String userId) {
    Group group = groupRepository.findById(groupId).orElseThrow(() -> new NotFoundException("Group not found."));
    User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found."));

    user.setGroup(group);
    group.getUsers().add(user);
  }

  public void updateUser(User user) {
    Optional<User> userById = userRepository.findById(user.getId());
    if (userById.isPresent()) {
      userRepository.save(user);
    } else {
      throw new NotFoundException("User not found");
    }
  }

  public void deleteUser(String id) {
    Optional<User> userById = userRepository.findById(id);
    if (userById.isPresent()) {
      userRepository.delete(userById.get());
    } else {
      throw new NotFoundException("User not found");
    }
  }
}
