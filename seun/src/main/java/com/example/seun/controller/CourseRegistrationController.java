package com.example.seun.controller;

import com.example.seun.dto.CourseRegisteredLectureForStudentDto;
import com.example.seun.dto.RegisteredStudentForLectureDto;
import com.example.seun.service.CourseRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courseRegistrations")
public class CourseRegistrationController {
    private final CourseRegistrationService courseRegistrationService;

    @PostMapping("/student/{studentNumber}/lecture/{lectureId}")
    public ResponseEntity<Void> courseRegistration(@PathVariable Long studentNumber, @PathVariable Long lectureId) {
        courseRegistrationService.courseRegistration(studentNumber, lectureId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/student/{studentNumber}/lectures")
    public ResponseEntity<List<CourseRegisteredLectureForStudentDto>> getLecturesByStudentNumber(@PathVariable Long studentNumber) {
        List<CourseRegisteredLectureForStudentDto> lectures = courseRegistrationService.getLecturesByStudent(studentNumber);
        return ResponseEntity.ok(lectures);
    }

    @GetMapping("/lecture/{lectureId}/students")
    public ResponseEntity<List<RegisteredStudentForLectureDto>> getStudentsByLectureId(@PathVariable Long lectureId) {
        List<RegisteredStudentForLectureDto> students = courseRegistrationService.getStudentsByLecture(lectureId);
        return ResponseEntity.ok(students);
    }

    @DeleteMapping("/student/{studentNumber}/lecture/{lectureId}")
    public ResponseEntity<Void> cancelCourseRegistration(@PathVariable Long studentNumber, @PathVariable Long lectureId) {
        courseRegistrationService.cancelCourseRegistration(studentNumber, lectureId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
