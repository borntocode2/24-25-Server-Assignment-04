package com.example.jpaproject.Repository;

import com.example.jpaproject.Domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
