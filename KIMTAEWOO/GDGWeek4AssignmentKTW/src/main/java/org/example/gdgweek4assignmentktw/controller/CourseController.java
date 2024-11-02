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

    // 강의 저장
    @PostMapping
    public ResponseEntity<CourseInfoResponseDto> saveCourse(@RequestBody CourseSaveRequestDto dto) {
        return new ResponseEntity(courseService.save(dto), HttpStatus.CREATED);
    }

    // courseId 로 강의 조회
    @GetMapping("/{courseId}")
    public ResponseEntity<CourseInfoResponseDto> findByCourseId(@PathVariable Long courseId) {
        return new ResponseEntity<>(courseService.findByCourseId(courseId), HttpStatus.OK);
    }

    // courseId 로 강의 정보 업데이트
    @PatchMapping("/{courseId}")
    public ResponseEntity<CourseInfoResponseDto> updateByCourseId(@PathVariable Long courseId
            , @RequestBody CourseSaveRequestDto dto ) {
        return new ResponseEntity<>(courseService.updateByCourseId(courseId, dto), HttpStatus.OK);
    }

    // courseId 로 강의 삭제
    @DeleteMapping("/courseId")
    public ResponseEntity<String> deleteByLectureId(@PathVariable Long courseId) {
        courseService.deleteByCourseId(courseId);
        String deleteResponseMessage = courseId + "번 강의가 성공적으로 삭제되었습니다.";
        return new ResponseEntity<>(deleteResponseMessage, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CourseListResponseDto> findAllLectures() {
        return new ResponseEntity<>(courseService.findAllCourses(), HttpStatus.OK);
    }

}