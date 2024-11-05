package org.example.gdgweek4assignmentktw.controller;

import lombok.RequiredArgsConstructor;
import org.example.gdgweek4assignmentktw.dto.courseRegistration.request.CourseRegistrationRequestDto;
import org.example.gdgweek4assignmentktw.dto.courseRegistration.response.CourseRegistrationListResponseDto;
import org.example.gdgweek4assignmentktw.dto.courseRegistration.response.CourseRegistrationResponseDto;
import org.example.gdgweek4assignmentktw.service.CourseRegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courseRegistration")
public class CourseRegistrationController {
    private final CourseRegistrationService courseRegistrationService;

    // 수강신청 등록
    @PostMapping
    public ResponseEntity<CourseRegistrationResponseDto> doRegistration(@RequestBody CourseRegistrationRequestDto dto) {
        return ResponseEntity.ok()
                .body(courseRegistrationService.doRegistration(dto));
    }

    // courseRegistrationId 로 수강신청 조회
    @GetMapping("/{courseRegistrationId}")
    public ResponseEntity<CourseRegistrationResponseDto> checkRegistration(@PathVariable Long courseRegistrationId) {
        return ResponseEntity.ok()
                .body(courseRegistrationService.checkByCourseRegistrationId(courseRegistrationId));
    }

    // 전체 수강신청 조회
    @GetMapping("/findAll")
    public ResponseEntity<CourseRegistrationListResponseDto> findAllRegistrations() {
        return ResponseEntity.ok()
                .body(courseRegistrationService.findAllRegistrations());
    }

    // 수강신청 취소
    @DeleteMapping("/{courseRegistrationId}")
    public ResponseEntity<String> cancelRegistration(@PathVariable Long courseRegistrationId) {
        return ResponseEntity.ok()
                .body(courseRegistrationService.cancelByCourseRegistrationId(courseRegistrationId));
    }

    // 학번을 통해 해당 학생의 수강신청 내역 조회
    @GetMapping("/findAll/{studentNumber}")
    public ResponseEntity<CourseRegistrationListResponseDto> findAllRegistrationsByStudnetNumber(@PathVariable Long studentNumber) {
        return ResponseEntity.ok()
                .body(courseRegistrationService.findAllRegistrationsByStudentNumber(studentNumber));
    }

}
