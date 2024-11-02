package org.example.gdgweek4assignmentktw.repository;

import org.example.gdgweek4assignmentktw.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByStudentNumber(Long studentNumber);
}
