package com.example.jpaproject.Service;

import com.example.jpaproject.Domain.Course;
import com.example.jpaproject.Dto.Course.request.CourseRequestDto;
import com.example.jpaproject.Dto.Course.response.CourseListResponseDto;
import com.example.jpaproject.Dto.Course.response.CourseResponseDto;
import com.example.jpaproject.Repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService {

    private final CourseRepository courseRepository;

    @Transactional
    public CourseResponseDto create(CourseRequestDto dto) {
        Course saveCourse = courseRepository.save(dto.toEntity());
        return CourseResponseDto.from(saveCourse);
    }

    @Transactional(readOnly = true)
    public CourseResponseDto findByCourseId(Long courseId) {
        Course findCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 수강과목입니다."));
        return CourseResponseDto.from(findCourse);
    }

    @Transactional
    public CourseResponseDto updateByCourseId(Long courseId, CourseRequestDto dto) {
        Course updateCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 수강과목입니다."));
        updateCourse.update(dto);
        return CourseResponseDto.from(updateCourse);
    }

    @Transactional
    public void deleteByCourseId(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Transactional(readOnly = true)
    public CourseListResponseDto findAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseResponseDto> courseInfoResponseDTOs = courses.stream()
                .map(CourseResponseDto::from)
                .toList();
        return CourseListResponseDto.from(courseInfoResponseDTOs);
    }
}
