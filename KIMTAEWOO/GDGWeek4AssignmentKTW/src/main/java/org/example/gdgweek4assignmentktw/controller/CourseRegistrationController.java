package org.example.gdgweek4assignmentktw.controller;

import lombok.RequiredArgsConstructor;
import org.example.gdgweek4assignmentktw.dto.courseRegistration.response.CourseRegistrationResponseDto;
import org.example.gdgweek4assignmentktw.service.CourseRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/CourseRegistration")
public class CourseRegistrationController {

    private final CourseRegistrationService courseRegistrationService;

    @PostMapping("/courseId/{courseId}/studentId/{studentId}")
    public ResponseEntity<?> doRegistration(@PathVariable Long courseId, Long studentId) {
        return new ResponseEntity<>(courseRegistrationService.doRegistration(courseId, studentId), HttpStatus.OK);
    }
}
