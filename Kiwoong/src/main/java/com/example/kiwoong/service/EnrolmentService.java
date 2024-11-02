package com.example.kiwoong.service;

import com.example.kiwoong.domain.Courses;
import com.example.kiwoong.domain.Enrolment;
import com.example.kiwoong.domain.Student;
import com.example.kiwoong.dto.Enrolment.response.EnrolmentInfoResponseDto;
import com.example.kiwoong.repository.CoursesRepository;
import com.example.kiwoong.repository.EnrolmentRepository;
import com.example.kiwoong.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrolmentService {

    private final EnrolmentRepository enrolmentRepository;
    private final StudentRepository studentRepository;
    private final CoursesRepository coursesRepository;

    @Transactional
    public void enrolment(Long studentId, Long coursesId) {
        if (enrolmentRepository.existsByStudent_IdAndCourses_Id(studentId, coursesId)) {
            throw new IllegalArgumentException("이미 수강 신청한 강의입니다.");
        }

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
        Courses courses = coursesRepository.findById(coursesId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));

        Enrolment enrolment = Enrolment.of(student, courses);
        enrolmentRepository.save(enrolment);
    }

    @Transactional
    public List<EnrolmentInfoResponseDto> getStudentsByCourses(Long coursesId) {
        List<Enrolment> enrolments = enrolmentRepository.findByCourses_Id(coursesId);

        if (enrolments.isEmpty()) {
            throw new IllegalArgumentException("해당 강의에 등록된 학생이 없습니다.");
        }

        List<EnrolmentInfoResponseDto> students = enrolments.stream()
                .map(enrolment -> EnrolmentInfoResponseDto.from(enrolment.getStudent(), enrolment.getCourses()))
                .collect(Collectors.toList());

        return students; // 학생 리스트 반환
    }

    @Transactional
    public List<EnrolmentInfoResponseDto> getCoursesByStudent(Long studentId) {
        List<Enrolment> enrolments = enrolmentRepository.findByStudent_Id(studentId);

        if (enrolments.isEmpty()) {
            throw new IllegalArgumentException("해당 학생이 등록한 강의가 없습니다.");
        }

        List<EnrolmentInfoResponseDto> courses = enrolments.stream()
                .map(enrolment -> EnrolmentInfoResponseDto.from(enrolment.getStudent(), enrolment.getCourses()))
                .collect(Collectors.toList());

        return courses; // 강의 리스트 반환
    }

    @Transactional
    public void cancelEnrolment(Long studentId, Long coursesId) {
        if (!enrolmentRepository.existsByStudent_IdAndCourses_Id(studentId, coursesId)) {
            throw new IllegalArgumentException("수강 신청 내역이 없습니다.");
        }

        enrolmentRepository.deleteByStudent_IdAndCourses_Id(studentId, coursesId);
    }
}