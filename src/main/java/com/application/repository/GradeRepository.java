package com.application.repository;

import com.application.model.Grade;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/** GradeRepository */
public interface GradeRepository extends JpaRepository<Grade, String> {
  Optional<Grade> findById(String id);
}
