package com.example.gdg_jpa.repository;

import com.example.gdg_jpa.domain.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findByStudentId(Long studentId);

    Optional<Enrollment> findByStudentIdAndLectureId(Long studentId, Long lectureId);

}
