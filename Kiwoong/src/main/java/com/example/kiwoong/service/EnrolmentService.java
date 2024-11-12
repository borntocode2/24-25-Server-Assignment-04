package com.example.kiwoong.service;

import com.example.kiwoong.domain.Courses;
import com.example.kiwoong.domain.Enrolment;
import com.example.kiwoong.domain.Student;
import com.example.kiwoong.dto.Enrolment.request.EnrolmentRequestDto;
import com.example.kiwoong.dto.Enrolment.response.EnrolmentInfoResponseDto;
import com.example.kiwoong.dto.Enrolment.response.EnrolmentListResponseDto;
import com.example.kiwoong.repository.CoursesRepository;
import com.example.kiwoong.repository.EnrolmentRepository;
import com.example.kiwoong.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrolmentService {//수강신청 관련 비즈니스 로직
    private final EnrolmentRepository enrolmentRepository;
    private final StudentRepository studentRepository;
    private final CoursesRepository coursesRepository;

    @Transactional
    public EnrolmentInfoResponseDto save(EnrolmentRequestDto enrolmentRequestDto){
        Student student = studentRepository.findById(enrolmentRequestDto.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));

        Courses courses = coursesRepository.findById(enrolmentRequestDto.getCourseId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));

        Enrolment enrolment = Enrolment.builder()
                .student(student)
                .courses(courses)
                .build();
        enrolmentRepository.save(enrolment);
        return EnrolmentInfoResponseDto.from(enrolment);
    }

    @Transactional(readOnly = true) // 트랜잭션 읽기 전용
    public EnrolmentInfoResponseDto findByEnrolmentId(Long id){ //student id로 수강신청 조회
        Enrolment enrolment = enrolmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 수강신청 목록입니다."));
        return EnrolmentInfoResponseDto.from(enrolment);
    }

    //수강신청 삭제 - 학생 id
    @Transactional
    public void deleteByEnrolmentId(Long id){
        enrolmentRepository.deleteById(id);
    }

    @Transactional( readOnly=true)
    public EnrolmentListResponseDto findAllEnrolmentId(){
        List<Enrolment> enrollmentList = enrolmentRepository.findAll();
        List<EnrolmentInfoResponseDto> enrolmentInfoResponseDTO = enrollmentList.stream()
                .map(EnrolmentInfoResponseDto::from)
                .toList();
        return EnrolmentListResponseDto.from(enrolmentInfoResponseDTO);
    }
}