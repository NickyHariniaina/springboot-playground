package com.application.service;

import com.application.model.Group;
import com.application.model.User;
import com.application.model.exception.NotFoundException;
import com.application.repository.GroupRepository;
import com.application.repository.UserRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired private UserRepository userRepository;
  @Autowired private GroupRepository groupRepository;

  public Optional<User> getUserById(String id) {
    return userRepository.findById(id);
  }

  public Optional<User> getUserByUsername(String username) {
    return userRepository.findByUsername(username);
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

  public List<User> getAllByStatus(User.Status status, Pageable pageable) {
    return userRepository.findAllByStatus(status, pageable);
  }

  public List<User> getAllByStatusAndSex(User.Status status, User.Sex sex, Pageable pageable) {
    return userRepository.findAllByStatusAndSex(status, sex, pageable);
  }

  public void createUser(User user) {
    System.out.println(user.getFirstname());
    System.out.println(user.getLastname());
    userRepository.save(user);
  }

  public List<User> getAllUser() {
    return userRepository.findAll();
  }

  @Transactional
  public void insertUserIntoGroup(String groupId, String userId) {
    Group group =
        groupRepository
            .findById(groupId)
            .orElseThrow(() -> new NotFoundException("Group not found."));
    User user =
        userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found."));

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
