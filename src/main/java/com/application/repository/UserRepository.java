package com.application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.application.model.User;

/**
 * UserRepository
 */

public interface UserRepository extends JpaRepository<User, String>{

  Optional<User> findById(String id);
  Optional<User> findByEmail(String email);
  Optional<User> findByRef(String ref);
  Optional<User> findByFirstname(String firstname);
  Optional<User> findByLastname(String lastname);
  List<User> findAllByStatus(User.Status status);

  @Query("select * from \"user\" u where u.status = :student_status and u.sex = :student_sex")
  List<User> findAllByStatusAndSex(@Param("student_status") User.Status status, @Param("student_sex") User.Sex sex);

  List<User> findAllByUsernameStartingWith(String username);
}
