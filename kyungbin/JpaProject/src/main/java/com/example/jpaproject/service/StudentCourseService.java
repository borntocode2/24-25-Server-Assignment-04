package com.example.jpaproject.service;

import com.example.jpaproject.domain.Course;
import com.example.jpaproject.domain.Student;
import com.example.jpaproject.domain.StudentCourse;
import com.example.jpaproject.dto.StudentCourseDto.StudentCourseInfoResponseDto;
import com.example.jpaproject.dto.StudentCourseDto.StudentCourseSaveRequestDto;
import com.example.jpaproject.repository.CourseRepository;
import com.example.jpaproject.repository.StudentCourseRepository;
import com.example.jpaproject.repository.StudentRepository;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentCourseService {
    private final StudentCourseRepository studentCourseRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    // 수강신청 기능
    @Transactional
    public StudentCourseInfoResponseDto save(StudentCourseSaveRequestDto studentCourseSaveRequestDto) {
        Course course = courseRepository.findById(studentCourseSaveRequestDto.getCourseId())
                .orElseThrow(() -> new IllegalArgumentException("없는 과목입니다."));

        Student student = studentRepository.findById(studentCourseSaveRequestDto.getStudentId())
                .orElseThrow(() -> new RuntimeException("없는 학생입니다."));

        StudentCourse studentCourse = StudentCourse.builder()
                .student(student)
                .course(course)
                .build();

        studentCourseRepository.save(studentCourse);

        return StudentCourseInfoResponseDto.from(studentCourse);
    }

    // 수강신청 조회 기능
    @Transactional(readOnly = true)
    public StudentCourseInfoResponseDto findByStudentCourseId(int studentCourseId) {
        StudentCourse studentCourse = studentCourseRepository.findById(studentCourseId)
                .orElseThrow(()-> new RuntimeException("없는 수강신청 기록입니다."));

        return StudentCourseInfoResponseDto.from(studentCourse);

    }

    //수강신청 취소 기능
    @Transactional
    public void deleteByStudentCourseId(int studentCourseId) {
        studentCourseRepository.deleteById(studentCourseId);
    }

    //수강신청 목록을 조회하는 기능
    @Transactional(readOnly = true)
    public List<StudentCourseInfoResponseDto> findAll() {
        List<StudentCourse> studentCourses = studentCourseRepository.findAll();

        //Dto를 저장할 새로운 리스트 생성
        List<StudentCourseInfoResponseDto> studentCourseInfoResponseDtos = new ArrayList<>();

        //entity를 돌면서 Dto로 바꾸어 리스트에 추가한다.
        for (StudentCourse studentCourse : studentCourses) {
            studentCourseInfoResponseDtos.add(StudentCourseInfoResponseDto.from(studentCourse));


        }
        return studentCourseInfoResponseDtos; //바뀐 리스트로 반환한다.
    }



}
