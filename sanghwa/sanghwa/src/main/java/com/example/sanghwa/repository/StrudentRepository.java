package com.example.sanghwa.repository;

import com.example.sanghwa.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StrudentRepository extends JpaRepository<Student, Long> {
}
