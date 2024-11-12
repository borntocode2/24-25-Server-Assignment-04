package com.example.seun.controller;

import com.example.seun.dto.LectureRegisteredLecturesResponseDto;
import com.example.seun.dto.LectureRegisteredStudentForLectureDto;
import com.example.seun.dto.LectureRegisteredStudentsResponseDto;
import com.example.seun.service.LectureRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courseRegistrations")
public class LectureRegistrationController {
    private final LectureRegistrationService lectureRegistrationService;

    @PostMapping("/student/{studentNumber}/lecture/{lectureId}")
    public ResponseEntity<Void> LectureRegistration(@PathVariable Long studentNumber, @PathVariable Long lectureId) {
        lectureRegistrationService.LectureRegistration(studentNumber, lectureId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/student/{studentNumber}/lectures")
    public ResponseEntity<LectureRegisteredLecturesResponseDto> getLecturesByStudentNumber(@PathVariable Long studentNumber) {
        LectureRegisteredLecturesResponseDto lecturesResponse = lectureRegistrationService.getLecturesByStudent(studentNumber);
        return ResponseEntity.ok(lecturesResponse);
    }

    @GetMapping("/lecture/{lectureId}/students")
    public ResponseEntity<LectureRegisteredStudentsResponseDto> getStudentsByLectureId(@PathVariable Long lectureId) {
        LectureRegisteredStudentsResponseDto studentsResponse = lectureRegistrationService.getStudentsByLecture(lectureId);
        return ResponseEntity.ok(studentsResponse);
    }


    @DeleteMapping("/student/{studentNumber}/lecture/{lectureId}")
    public ResponseEntity<Void> cancelLectureRegistration(@PathVariable Long studentNumber, @PathVariable Long lectureId) {
        lectureRegistrationService.cancelLectureRegistration(studentNumber, lectureId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
