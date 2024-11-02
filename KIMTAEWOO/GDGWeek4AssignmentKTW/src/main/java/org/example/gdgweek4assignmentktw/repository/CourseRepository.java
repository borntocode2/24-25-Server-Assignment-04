package org.example.gdgweek4assignmentktw.repository;

import org.example.gdgweek4assignmentktw.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    boolean existsByCourseNumber(Long CourseNumber);
}
