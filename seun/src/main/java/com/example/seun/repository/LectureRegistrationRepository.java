package com.example.seun.repository;

import com.example.seun.domain.LectureRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureRegistrationRepository extends JpaRepository<LectureRegistration, Long> {
    boolean existsByStudent_IdAndLecture_Id(Long studentId, Long lectureId);
    void deleteByStudent_IdAndLecture_Id(Long studentId, Long lectureId);
    List<LectureRegistration> findByLectureId(Long lectureId);
    List<LectureRegistration> findByStudent_Id(Long studentId);
}