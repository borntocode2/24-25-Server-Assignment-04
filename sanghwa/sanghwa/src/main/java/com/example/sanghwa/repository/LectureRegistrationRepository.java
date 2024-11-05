package com.example.sanghwa.repository;

import com.example.sanghwa.domain.LectureRegistration;
import jakarta.servlet.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LectureRegistrationRepository extends JpaRepository<LectureRegistration, Long> {
    @Query("SELECT r FROM LectureRegistration r WHERE r.student.id = :studentId")
    List<LectureRegistration> findByStudentId(Long studentId);
}
