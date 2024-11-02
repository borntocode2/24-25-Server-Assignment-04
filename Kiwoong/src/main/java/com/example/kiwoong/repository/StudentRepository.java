package com.example.kiwoong.repository;

import com.example.kiwoong.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}