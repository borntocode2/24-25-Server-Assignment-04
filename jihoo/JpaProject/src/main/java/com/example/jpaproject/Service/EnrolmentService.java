package com.example.jpaproject.Service;

import com.example.jpaproject.Domain.Course;
import com.example.jpaproject.Domain.Enrolment;
import com.example.jpaproject.Domain.Student;
import com.example.jpaproject.Dto.Enrolment.request.EnrolmentRequestDto;
import com.example.jpaproject.Dto.Enrolment.response.EnrolmentInfoResponseDto;
import com.example.jpaproject.Dto.Enrolment.response.EnrolmentListResponseDto;
import com.example.jpaproject.Repository.CourseRepository;
import com.example.jpaproject.Repository.EnrolmentRepository;
import com.example.jpaproject.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EnrolmentService {

    private final EnrolmentRepository enrolmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Transactional
    public EnrolmentInfoResponseDto create(EnrolmentRequestDto dto) {
        Student targetStudent = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
        Course targetCourse = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 과목입니다."));

        Enrolment enrolment = Enrolment.builder()
                .student(targetStudent)
                .course(targetCourse)
                .build();
        enrolmentRepository.save(enrolment);
        return EnrolmentInfoResponseDto.from(enrolment);
    }

    @Transactional(readOnly = true)
    public EnrolmentInfoResponseDto findByEnrolment(Long enrolmentId) {
        Enrolment findEnrolment = enrolmentRepository.findById(enrolmentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 수강신청입니다."));
        return EnrolmentInfoResponseDto.from(findEnrolment);
    }

    @Transactional
    public void deleteByEnrolment(Long enrolmentId) {
        Enrolment findEnrolment = enrolmentRepository.findById(enrolmentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 수강신청입니다."));
        enrolmentRepository.deleteById(enrolmentId);
    }

    @Transactional(readOnly = true)
    public EnrolmentListResponseDto getAllEnrolments() {
        List<Enrolment> enrolments = enrolmentRepository.findAll();
        List<EnrolmentInfoResponseDto> enrolmentInfoResponseDtos = enrolments.stream()
                .map(EnrolmentInfoResponseDto::from)
                .toList();
        return EnrolmentListResponseDto.from(enrolmentInfoResponseDtos);
    }
}
