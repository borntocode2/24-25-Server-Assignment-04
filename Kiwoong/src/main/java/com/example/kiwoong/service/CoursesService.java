package com.example.kiwoong.service;

import com.example.kiwoong.domain.Courses;
import com.example.kiwoong.dto.courses.request.CoursesRequestDto;
import com.example.kiwoong.dto.courses.response.CoursesInfoResponseDto;
import com.example.kiwoong.dto.courses.response.CoursesListResponseDto;
import com.example.kiwoong.repository.CoursesRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
@RequiredArgsConstructor

public class CoursesService {
    private final CoursesRepository coursesRepository;

    @Transactional
    public CoursesInfoResponseDto save(CoursesRequestDto coursesRequestDto) {
        Courses courses = coursesRequestDto.toEntity();
        coursesRepository.save(courses);

        return CoursesInfoResponseDto.from(courses);
    }

    @Transactional(readOnly = true)
    public CoursesInfoResponseDto findBycoursesId(Long id) {
        Courses courses = coursesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다. 다시 입력해주세요"));

        return CoursesInfoResponseDto.from(courses);
    }

    @Transactional(readOnly = true)
    public CoursesListResponseDto CoursesList() {
        List<Courses> courses = coursesRepository.findAll();
        List<CoursesInfoResponseDto> coursesDtos = courses.stream()
                .map(CoursesInfoResponseDto::from)
                .toList();

        return CoursesListResponseDto.from(coursesDtos);
    }
    @Transactional
    public CoursesInfoResponseDto updateCourses(CoursesRequestDto coursesRequestDto) {
        Courses courses = coursesRepository.findById(coursesRequestDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));

        courses.update(coursesRequestDto);
        return CoursesInfoResponseDto.from(courses);
    }


    // Delete
    @Transactional
    public void deleteCoursesById(Long id) {
        coursesRepository.deleteById(id);
    }


}