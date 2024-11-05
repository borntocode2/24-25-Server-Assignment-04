package org.example.gdgweek4assignmentktw.controller;

import lombok.RequiredArgsConstructor;
import org.example.gdgweek4assignmentktw.dto.course.request.CourseSaveRequestDto;
import org.example.gdgweek4assignmentktw.dto.course.response.CourseInfoResponseDto;
import org.example.gdgweek4assignmentktw.dto.course.response.CourseListResponseDto;
import org.example.gdgweek4assignmentktw.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
// 클래스의 final 필드나 @NotNull이 붙은 필드에 대해 필수적인 생성자 자동 생성, 생성자를 통한 의존성 주입
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    // 강의 생성
    @PostMapping
    public ResponseEntity<CourseInfoResponseDto> saveCourse(@RequestBody CourseSaveRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseService.save(dto));
    }

    // courseId 로 강의 조회
    @GetMapping("/{courseId}")
    public ResponseEntity<CourseInfoResponseDto> findByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(courseService.findByCourseId(courseId));
    }

    // 전체 강의 조회
    @GetMapping
    public ResponseEntity<CourseListResponseDto> findAllCourses() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(courseService.findAllCourses());
    }

    // courseId 로 강의 수정
    @PatchMapping("/{courseId}")
    public ResponseEntity<CourseInfoResponseDto> updateByCourseId(@PathVariable Long courseId, @RequestBody CourseSaveRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(courseService.updateByCourseId(courseId, dto));
    }

    // courseId 로 강의 삭제
    @DeleteMapping("/{courseId}")
    public ResponseEntity<String> deleteByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(courseService.deleteByCourseId(courseId));
    }
    
}
