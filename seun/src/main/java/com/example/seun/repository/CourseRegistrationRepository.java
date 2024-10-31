package com.example.seun.repository;

import com.example.seun.domain.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Long> {
    boolean existsByStudentStudentNumberAndLectureId(Long studentNumber, Long lectureId);
    void deleteByStudentStudentNumberAndLectureId(Long studentNumber, Long lectureId);
    List<CourseRegistration> findByLectureId(Long lectureId);
    List<CourseRegistration> findByStudent_StudentNumber(Long studentNumber);
}