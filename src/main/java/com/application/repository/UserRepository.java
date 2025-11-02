package com.application.repository;

import com.application.model.User;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {

  Optional<User> findById(String id);

  Optional<User> findByEmail(String email);

  Optional<User> findByRef(String ref);

  Optional<User> findByFirstname(String firstname);

  Optional<User> findByLastname(String lastname);

  Optional<User> findByUsername(String username);

  List<User> findAllByStatus(User.Status status, Pageable pageable);

  @Query("select u from User u where u.status = :student_status and u.sex = :student_sex")
  List<User> findAllByStatusAndSex(
      @Param("student_status") User.Status status, @Param("student_sex") User.Sex sex, Pageable pageable);


  List<User> findAllByGroupId(String groupId, Pageable pageable);

  List<User> findAllByGroupIdAndSex(String groupId, User.Sex sex, Pageable pageable);
}
