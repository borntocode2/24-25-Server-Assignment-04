package com.example.jpaproject.Controller;

import com.example.jpaproject.Dto.Enrolment.request.EnrolmentRequestDto;
import com.example.jpaproject.Dto.Enrolment.response.EnrolmentInfoResponseDto;
import com.example.jpaproject.Dto.Enrolment.response.EnrolmentListResponseDto;
import com.example.jpaproject.Service.EnrolmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/enrolments")
public class EnrolmentController {

    private final EnrolmentService enrolmentService;

    @PostMapping
    public ResponseEntity<?> createEnrolment(@RequestBody EnrolmentRequestDto dto) {
        log.info("enrolment create 요청");
        EnrolmentInfoResponseDto enrolment = enrolmentService.create(dto);
        return ResponseEntity.ok().body(enrolment);
    }

    @GetMapping("/{enrolmentId}")
    public ResponseEntity<?> findByEnrolment(@PathVariable Long enrolmentId) {
        log.info("enrolment read 요청");
        EnrolmentInfoResponseDto findEnrolment = enrolmentService.findByEnrolment(enrolmentId);
        return ResponseEntity.ok().body(findEnrolment);
    }

    @DeleteMapping("/{enrolmentId}")
    public ResponseEntity<?> deleteEnrolment(@PathVariable Long enrolmentId) {
        log.info("enrolment delete 요청");
        enrolmentService.deleteByEnrolment(enrolmentId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getAllEnrolments() {
        log.info("enrolment list 요청");
            EnrolmentListResponseDto allEnrolments = enrolmentService.getAllEnrolments();
            return ResponseEntity.ok().body(allEnrolments);
    }
}