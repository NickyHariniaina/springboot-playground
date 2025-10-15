package com.application.repository;

import com.application.model.Course;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/** CourseRepository */
public interface CourseRepository extends JpaRepository<Course, String> {
  Optional<Course> findById(String id);

  List<Course> findAllByCredits(Integer credits);
}
