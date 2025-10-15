package com.application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.application.model.Group;

public interface GroupRepository extends JpaRepository<Group, String> {

  Optional<Group> findByName(String name);
  Optional<Group> findById(String id);

}
