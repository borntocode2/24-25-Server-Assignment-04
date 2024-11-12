package com.example.jpastudy.repository;

import com.example.jpastudy.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
