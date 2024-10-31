package com.example.jpaproject.Repository;

import com.example.jpaproject.Domain.Enrolment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrolmentRepository extends JpaRepository<Enrolment, Long> {
}
