package com.example.gdg_jpa.service;


import com.example.gdg_jpa.domain.Enrollment;
import com.example.gdg_jpa.domain.Lecture;
import com.example.gdg_jpa.domain.Student;
import com.example.gdg_jpa.dto.EnrollmentDto;
import com.example.gdg_jpa.repository.EnrollmentRepository;
import com.example.gdg_jpa.repository.LectureRepository;
import com.example.gdg_jpa.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final LectureRepository lectureRepository;
    private final StudentRepository studentRepository;

    @Transactional // 수강신청
    public EnrollmentDto.Response createEnrollment(EnrollmentDto.Request request) {
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("학생이 존재하지 않습니다."));

        Lecture lecture = lectureRepository.findById(request.getLectureId())
                .orElseThrow(() -> new IllegalArgumentException("강의가 존재하지 않습니다."));

        Enrollment enrollment = Enrollment.builder()
                .student(student)
                .lecture(lecture)
                .build();

        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
        return EnrollmentDto.Response.from(savedEnrollment);
    }

    @Transactional // 수강신청 조회
    public List<EnrollmentDto.Response> getStudentEnrollments(Long studentId) {
        List<Enrollment> enrollments=enrollmentRepository.findByStudentId(studentId);
        List<EnrollmentDto.Response> responses=new ArrayList<>();

        for(Enrollment enrollment:enrollments){
            responses.add(EnrollmentDto.Response.from(enrollment));
        }
        return responses;
    }

    @Transactional // 수강 신청 취소
    public void cancelEnrollment(EnrollmentDto.Request request) {

        Enrollment enrollment = enrollmentRepository
                .findByStudentIdAndLectureId(request.getStudentId(), request.getLectureId())
                .orElseThrow(() -> new IllegalArgumentException("해당 내역이 존재하지 않습니다."));

        enrollmentRepository.delete(enrollment);
    }

}