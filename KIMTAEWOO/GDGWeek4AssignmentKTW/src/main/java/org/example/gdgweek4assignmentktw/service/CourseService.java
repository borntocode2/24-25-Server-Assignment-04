package org.example.gdgweek4assignmentktw.service;


import lombok.RequiredArgsConstructor;
import org.example.gdgweek4assignmentktw.domain.Course;
import org.example.gdgweek4assignmentktw.dto.course.response.CourseListResponseDto;
import org.example.gdgweek4assignmentktw.exception.CourseAlreadyExistsException;
import org.example.gdgweek4assignmentktw.exception.StudentNotExistsException;
import org.example.gdgweek4assignmentktw.repository.CourseRepository;
import org.example.gdgweek4assignmentktw.dto.course.request.CourseSaveRequestDto;
import org.example.gdgweek4assignmentktw.dto.course.response.CourseInfoResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    @Transactional
    public CourseInfoResponseDto save(CourseSaveRequestDto dto) {
        if(courseRepository.existsByCourseNumber(dto.getCourseNumber())){
            throw new CourseAlreadyExistsException("이미 존재하는 강의번호입니다. 다른 강의번호를 사용해주세요.");
        }

        Course saveCourse = dto.toEntity();
        courseRepository.save(saveCourse);

        return CourseInfoResponseDto.includeAllFieldFrom(saveCourse);
    }

    @Transactional
    public CourseInfoResponseDto findByCourseId(Long courseId) {
        Course foundCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));

        return CourseInfoResponseDto.includeAllFieldFrom(foundCourse);
    }

    @Transactional
    public CourseInfoResponseDto updateByCourseId(Long courseId, CourseSaveRequestDto dto) {
        Course updateCourse = courseRepository.findById(courseId)
                .orElseThrow( () -> new IllegalArgumentException("존재하지 않는 강의입니다."));

        if(courseRepository.existsByCourseNumber(dto.getCourseNumber())){
            throw new CourseAlreadyExistsException("이미 존재하는 강의번호입니다. 다른 강의번호를 사용해주세요.");
        }

        updateCourse.update(dto);

        return CourseInfoResponseDto.includeAllFieldFrom(updateCourse);
    }

    @Transactional
    public String deleteByCourseId(Long courseId) {
        if(!courseRepository.existsById(courseId)) {
            throw new StudentNotExistsException("존재하지 않는 과목입니다.");
        }
        courseRepository.deleteById(courseId);
        return courseId + "번 강의가 성공적으로 삭제되었습니다.";
    }

    @Transactional(readOnly = true)
    public CourseListResponseDto findAllCourses() {
        List<Course> courses = courseRepository.findAll();

        List<CourseInfoResponseDto> courseDtoList = courses.stream()
                .map(CourseInfoResponseDto::includeAllFieldFrom)
                .toList();

        return CourseListResponseDto.changeListToDto(courseDtoList);
    }

}
