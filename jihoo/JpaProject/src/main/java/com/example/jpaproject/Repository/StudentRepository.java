package com.example.jpaproject.Repository;

import com.example.jpaproject.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
