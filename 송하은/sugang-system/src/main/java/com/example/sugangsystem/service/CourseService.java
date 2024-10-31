package com.example.sugangsystem.service;

import com.example.sugangsystem.domain.Course;
import com.example.sugangsystem.domain.Student;
import com.example.sugangsystem.dto.request.course.CourseSaveRequestDto;
import com.example.sugangsystem.dto.request.course.CourseUpdateRequestDto;
import com.example.sugangsystem.dto.request.student.StudentUpdateRequestDto;
import com.example.sugangsystem.dto.response.course.CourseInfoResponseDto;
import com.example.sugangsystem.dto.response.course.CourseListResponseDto;
import com.example.sugangsystem.dto.response.student.StudentInfoResponseDto;
import com.example.sugangsystem.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    // 강의 생성 - create
    public CourseInfoResponseDto save(CourseSaveRequestDto courseSaveRequestDto) {
        Course course = courseSaveRequestDto.toEntity();
        courseRepository.save(course);

        return CourseInfoResponseDto.from(course);
    }

    // 강의 한 개 조회 - read
    public CourseInfoResponseDto findByCourseId(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));

        return CourseInfoResponseDto.from(course);
    }

    // 강의 전체 목록 조회 - read
    public CourseListResponseDto findAll() {
        List<Course> courses = courseRepository.findAll();
        List<CourseInfoResponseDto> courseDtos = courses.stream()
                .map(CourseInfoResponseDto::from)
                .toList();

        return CourseListResponseDto.from(courseDtos);
    }

    // 강의 수정
    @Transactional
    public CourseInfoResponseDto updateByCourseId(Long id, CourseUpdateRequestDto courseUpdateRequestDto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));
        course.update(courseUpdateRequestDto.getTitle(), courseUpdateRequestDto.getProfessor());

        return CourseInfoResponseDto.from(course);
    }

    // 강의 삭제
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}
