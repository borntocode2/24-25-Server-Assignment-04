package com.example.gdg_jpa.controller;


import com.example.gdg_jpa.dto.EnrollmentDto;
import com.example.gdg_jpa.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/enrollment")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    // 수강신청 요청
    @PostMapping
    public ResponseEntity<EnrollmentDto.Response> createEnrollment(
            @RequestBody EnrollmentDto.Request request) {

        EnrollmentDto.Response response = enrollmentService.createEnrollment(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    // 수강신청 조회
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<EnrollmentDto.Response>> getStudentEnrollments(
            @PathVariable Long studentId) {
        return ResponseEntity.ok(enrollmentService.getStudentEnrollments(studentId));
    }

    // 수강신청 취소
    @DeleteMapping ("/student/{studentId}")
    public ResponseEntity<EnrollmentDto.Response> getStudentEnrollment(
            @RequestBody EnrollmentDto.Request request){
        enrollmentService.cancelEnrollment(request);

        return ResponseEntity.ok(new EnrollmentDto.Response());
    }

}
