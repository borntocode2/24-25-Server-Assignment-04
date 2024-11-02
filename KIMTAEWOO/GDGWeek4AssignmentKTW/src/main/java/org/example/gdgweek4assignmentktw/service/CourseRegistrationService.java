package org.example.gdgweek4assignmentktw.service;


import lombok.RequiredArgsConstructor;
import org.example.gdgweek4assignmentktw.domain.Course;
import org.example.gdgweek4assignmentktw.domain.CourseRegistration;
import org.example.gdgweek4assignmentktw.domain.Student;
import org.example.gdgweek4assignmentktw.dto.courseRegistration.request.CourseRegistrationRequestDto;
import org.example.gdgweek4assignmentktw.dto.courseRegistration.response.CourseRegistrationListResponseDto;
import org.example.gdgweek4assignmentktw.dto.courseRegistration.response.CourseRegistrationResponseDto;
import org.example.gdgweek4assignmentktw.dto.student.response.StudentInfoResponseDto;
import org.example.gdgweek4assignmentktw.dto.student.response.StudentListResponseDto;
import org.example.gdgweek4assignmentktw.exception.CourseNotExistsException;
import org.example.gdgweek4assignmentktw.exception.StudentNotExistsException;
import org.example.gdgweek4assignmentktw.repository.CourseRegistrationRepository;
import org.example.gdgweek4assignmentktw.repository.CourseRepository;
import org.example.gdgweek4assignmentktw.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // @RequiredArgsConstructor으로 생성자 주입
public class CourseRegistrationService {
    private final CourseRegistrationRepository courseRegistrationRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    @Transactional
    public CourseRegistrationResponseDto doRegistration(CourseRegistrationRequestDto dto) {
        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new CourseNotExistsException("존재하지 않는 강의입니다."));
        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new StudentNotExistsException("존재하지 않는 학생입니다."));

        /*
        builder() 이 static 메서드인 이유
            builder()은 new 키워드를 대채하며 객체를 유연하게 생성하고 필드 값을 단계적으로 설정할 수 있도록 해준다.
            따라서 사용 전 인스턴스를 생성해야 한다면 의미가 퇴색된다.
        builder()은 일종의 팩토리 메서드라고 볼 수 있다.
        권지후님의 코드를 참고하였으며, builder() 어노테이션에 대해 조금 더 자세히 공부해 보았습니다.
         */
        CourseRegistration courseRegistration = CourseRegistration.builder()
                .course(course)
                .student(student)
                .build();
        courseRegistrationRepository.save(courseRegistration);

        return CourseRegistrationResponseDto.includeAllFieldFrom(courseRegistration);
    }

    @Transactional
    public CourseRegistrationResponseDto checkByCourseRegistrationId(Long registrationId) {
        CourseRegistration foundRegistration = courseRegistrationRepository.findById(registrationId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 수강신청 내역입니다. 수강신천 번호를 확인해 주세요."));

        return CourseRegistrationResponseDto.includeAllFieldFrom(foundRegistration);
    }

    @Transactional
    public void cancelByCourseRegistrationId(Long registrationId) {
        if(!courseRegistrationRepository.existsById(registrationId)) {
            throw new StudentNotExistsException("존재하지 않는 수강신청 내역입니다. 수강신청 번호를 확인해 주세요.");
        }
        courseRegistrationRepository.deleteById(registrationId);
    }

    @Transactional(readOnly = true)
    public CourseRegistrationListResponseDto findAllRegistrations() {
        List<CourseRegistration> registrations = courseRegistrationRepository.findAll();

        List<CourseRegistrationResponseDto> registrationDtoList = registrations.stream()
                .map(CourseRegistrationResponseDto::includeAllFieldFrom)
                .toList();

        return CourseRegistrationListResponseDto.changeListToDto(registrationDtoList);
    }

    @Transactional(readOnly = true)
    public CourseRegistrationListResponseDto findAllRegistrationsByStudentNumber(Long studentNumber) {
        List<CourseRegistration> registrations = courseRegistrationRepository.findByStudent_StudentNumber(studentNumber);

        List<CourseRegistrationResponseDto> registrationDtoListofStudentNumber = registrations.stream()
                .map(CourseRegistrationResponseDto::includeAllFieldFrom)
                .toList();

        return CourseRegistrationListResponseDto.changeListToDto(registrationDtoListofStudentNumber);
    }

}
