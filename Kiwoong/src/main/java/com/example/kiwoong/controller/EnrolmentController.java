package com.example.kiwoong.controller;

import com.example.kiwoong.dto.Enrolment.response.EnrolmentInfoResponseDto;
import com.example.kiwoong.service.EnrolmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrolments")
@RequiredArgsConstructor
public class EnrolmentController {

    private final EnrolmentService enrolmentService;

    // 수강 신청
    @PostMapping("/register")
    public ResponseEntity<Void> registerEnrolment(@RequestParam Long studentId, @RequestParam Long coursesId) {
        enrolmentService.enrolment(studentId, coursesId);
        return ResponseEntity.ok().build(); // 200 OK 응답
    }

    // 강의별 학생 조회
    @GetMapping("/students/{coursesId}")
    public ResponseEntity<List<EnrolmentInfoResponseDto>> getStudentsByCourses(@PathVariable Long coursesId) {
        List<EnrolmentInfoResponseDto> response = enrolmentService.getStudentsByCourses(coursesId);
        return ResponseEntity.ok(response); // 학생 리스트 반환
    }

    // 학생별 강의 조회
    @GetMapping("/courses/{studentId}")
    public ResponseEntity<List<EnrolmentInfoResponseDto>> getCoursesByStudent(@PathVariable Long studentId) {
        List<EnrolmentInfoResponseDto> response = enrolmentService.getCoursesByStudent(studentId);
        return ResponseEntity.ok(response); // 강의 리스트 반환
    }

    // 수강 신청 취소
    @DeleteMapping("/cancel")
    public ResponseEntity<Void> cancelLectureRegistration(@RequestParam Long studentId, @RequestParam Long lectureId) {
        enrolmentService.cancelEnrolment(studentId, lectureId);
        return ResponseEntity.ok().build(); // 200 OK 응답
    }
}