package org.example.gdgweek4assignmentktw.repository;

import org.example.gdgweek4assignmentktw.domain.CourseRegistration;
import org.example.gdgweek4assignmentktw.domain.Student;
import org.example.gdgweek4assignmentktw.dto.student.response.StudentListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByStudentNumber(Long studentNumber);
}
