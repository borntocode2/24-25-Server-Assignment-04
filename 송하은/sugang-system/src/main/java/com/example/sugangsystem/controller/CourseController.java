package com.example.sugangsystem.controller;

import com.example.sugangsystem.dto.request.course.CourseSaveRequestDto;
import com.example.sugangsystem.dto.request.course.CourseUpdateRequestDto;
import com.example.sugangsystem.dto.response.course.CourseInfoResponseDto;
import com.example.sugangsystem.dto.response.course.CourseListResponseDto;
import com.example.sugangsystem.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    // 강의 생성
    @PostMapping("/create")
    public ResponseEntity<CourseInfoResponseDto> save(@RequestBody CourseSaveRequestDto courseSaveRequestDto) {
        return new ResponseEntity<>(courseService.save(courseSaveRequestDto), HttpStatus.CREATED);
    }

    // 강의 1개 조회
    @GetMapping("/{courseId}")
    public ResponseEntity<CourseInfoResponseDto> findById(@PathVariable Long courseId) {
        return new ResponseEntity<>(courseService.findByCourseId(courseId), HttpStatus.OK);
    }

    // 전체 강의 목록 조회
    @GetMapping("/all")
    public ResponseEntity<CourseListResponseDto> findAll() {
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    // 강의 수정
    @PatchMapping("/{courseId}")
    public ResponseEntity<CourseInfoResponseDto> update(@PathVariable Long courseId, @RequestBody CourseUpdateRequestDto courseUpdateRequestDto) {
        return new ResponseEntity<>(courseService.updateByCourseId(courseId, courseUpdateRequestDto), HttpStatus.OK);
    }

    // 강의 삭제
    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> delete(@PathVariable Long courseId) {
        courseService.deleteById(courseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
