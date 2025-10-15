package com.application.repository;

import com.application.model.Group;
import com.application.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GroupRepository extends JpaRepository<Group, String> {

  Optional<Group> findByName(String name);

  Optional<Group> findById(String id);

  @Query(
      "select u from Group g inner join User u  where u.status ="
          + " :student_status and g.name = :group_name")
  List<User> findByUserStatus(
      @Param("student_status") User.Status status, @Param("group_name") String groupName);
}
