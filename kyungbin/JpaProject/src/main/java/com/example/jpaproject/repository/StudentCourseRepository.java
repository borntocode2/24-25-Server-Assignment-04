package com.example.jpaproject.repository;

import com.example.jpaproject.domain.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {

}
