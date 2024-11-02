package com.example.kiwoong.controller;

import com.example.kiwoong.dto.courses.request.CoursesRequestDto;
import com.example.kiwoong.dto.courses.response.CoursesInfoResponseDto;
import com.example.kiwoong.dto.courses.response.CoursesListResponseDto;
import com.example.kiwoong.service.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CoursesController {

    private final CoursesService coursesService;

    // 강의 생성
    @PostMapping
    public ResponseEntity<CoursesInfoResponseDto> createCourse(@RequestBody CoursesRequestDto coursesRequestDto) {
        CoursesInfoResponseDto response = coursesService.save(coursesRequestDto);
        return ResponseEntity.ok(response); // 200 OK 응답
    }

    // 강의 조회
    @GetMapping("/{id}")
    public ResponseEntity<CoursesInfoResponseDto> getCourseById(@PathVariable Long id) {
        CoursesInfoResponseDto response = coursesService.findBycoursesId(id);
        return ResponseEntity.ok(response); // 200 OK 응답
    }

    // 모든 강의 조회
    @GetMapping
    public ResponseEntity<CoursesListResponseDto> getAllCourses() {
        CoursesListResponseDto response = coursesService.CoursesList();
        return ResponseEntity.ok(response); // 200 OK 응답
    }

    // 강의 업데이트
    @PutMapping
    public ResponseEntity<CoursesInfoResponseDto> updateCourse(@RequestBody CoursesRequestDto coursesRequestDto) {
        CoursesInfoResponseDto response = coursesService.updateCourses(coursesRequestDto);
        return ResponseEntity.ok(response); // 200 OK 응답
    }

    // 강의 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        coursesService.deleteCoursesById(id);
        return ResponseEntity.noContent().build(); // 204 No Content 응답
    }
}