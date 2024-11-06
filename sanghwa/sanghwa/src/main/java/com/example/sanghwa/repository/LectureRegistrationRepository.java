package com.example.sanghwa.repository;

import com.example.sanghwa.domain.LectureRegistration;
import jakarta.servlet.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LectureRegistrationRepository extends JpaRepository<LectureRegistration, Long> {
    List<LectureRegistration> findByStudent_Id(Long studentId); //lectureRegistration에서 StdentId를 가져와서 찾는 쿼리 작성해야댐..
}
