package com.example.kiwoong.repository;

import com.example.kiwoong.domain.Enrolment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrolmentRepository extends JpaRepository<Enrolment, Long> {
    boolean existsByStudent_IdAndCourses_Id(Long studentId, Long coursesId);
    void deleteByStudent_IdAndCourses_Id(Long studentId, Long coursesId);
    List<Enrolment> findByCourses_Id(Long coursesId);

    List<Enrolment> findByStudent_Id(Long studentId);


}