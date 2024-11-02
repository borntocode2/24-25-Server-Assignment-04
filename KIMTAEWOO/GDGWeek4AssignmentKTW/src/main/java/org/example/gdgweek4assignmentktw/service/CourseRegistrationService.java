package org.example.gdgweek4assignmentktw.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.gdgweek4assignmentktw.domain.Course;
import org.example.gdgweek4assignmentktw.domain.CourseRegistration;
import org.example.gdgweek4assignmentktw.domain.Student;
import org.example.gdgweek4assignmentktw.dto.courseRegistration.request.CourseRegistrationRequestDto;
import org.example.gdgweek4assignmentktw.dto.courseRegistration.response.CourseRegistrationResponseDto;
import org.example.gdgweek4assignmentktw.exception.CourseNotExistsException;
import org.example.gdgweek4assignmentktw.exception.StudentNotExistsException;
import org.example.gdgweek4assignmentktw.repository.CourseRegistrationRepository;
import org.example.gdgweek4assignmentktw.repository.CourseRepository;
import org.example.gdgweek4assignmentktw.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseRegistrationService {
    private final CourseRegistrationRepository courseRegistrationRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    @Transactional
    public CourseRegistrationResponseDto doRegistration(Long courseId, Long studentId) {
        // 예외 핸들링
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotExistsException("존재하지 않는 강의입니다"));
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotExistsException("존재하지 않는 학생입니다"));

        //
        CourseRegistration courseRegistration = CourseRegistration.createWithCourseAndStudent(course, student);
        courseRegistrationRepository.save(courseRegistration);

        return CourseRegistrationResponseDto.includeAllFieldFrom(courseRegistration);
    }

    @Transactional
    public CourseRegistrationResponseDto findByCourseRegistrationId(Long registrationId) {
        CourseRegistration foundRegistration = courseRegistrationRepository.findById(registrationId)
                .orElseThrow(() -> new IllegalArgumentException("존재하니 않는 수강신청입니다"));

        return CourseRegistrationResponseDto.includeAllFieldFrom(foundRegistration);
    }

    @Transactional
    public void cancelByCourseRegistrationId(Long registrationId) {
        courseRegistrationRepository.deleteById(registrationId);
    }

    //studentId 로 수강신청 목록 조회
    public List<CourseRegistrationResponseDto> getAllCourseRegistrations(Long studentId) {
        List<CourseRegistration> registrations = courseRegistrationRepository.findByStudent_StudentId(studentId);

        if(registrations.isEmpty()) {
            System.out.println("수강신청 내역이 없습니다");
            return Collections.emptyList();
        }

        return registrations.stream()
                .map(CourseRegistrationResponseDto::includeAllFieldFrom)
                .collect(Collectors.toList());
    }

}
