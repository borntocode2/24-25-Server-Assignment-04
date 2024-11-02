package org.example.gdgweek4assignmentktw.controller;

import lombok.RequiredArgsConstructor;
import org.example.gdgweek4assignmentktw.domain.Course;
import org.example.gdgweek4assignmentktw.domain.Student;
import org.example.gdgweek4assignmentktw.dto.courseRegistration.request.CourseRegistrationRequestDto;
import org.example.gdgweek4assignmentktw.dto.courseRegistration.response.CourseRegistrationListResponseDto;
import org.example.gdgweek4assignmentktw.dto.courseRegistration.response.CourseRegistrationResponseDto;
import org.example.gdgweek4assignmentktw.repository.CourseRepository;
import org.example.gdgweek4assignmentktw.repository.StudentRepository;
import org.example.gdgweek4assignmentktw.service.CourseRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courseRegistration")
public class CourseRegistrationController {

    private final CourseRegistrationService courseRegistrationService;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    // 수강신청 등록
    @PostMapping
    public ResponseEntity<CourseRegistrationResponseDto> doRegistration(@RequestBody CourseRegistrationRequestDto dto) {
        CourseRegistrationResponseDto responseDto = courseRegistrationService.doRegistration(dto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    // courseRegistrationId 로 수강신청 조회
    @GetMapping("/{courseRegistrationId}")
    public ResponseEntity<CourseRegistrationResponseDto> checkRegistration(@PathVariable Long courseRegistrationId) {
        return new ResponseEntity<>(courseRegistrationService.checkByCourseRegistrationId(courseRegistrationId),HttpStatus.OK);
    }

    // 전체 수강신청 조회
    @GetMapping("/findAll")
    public ResponseEntity<CourseRegistrationListResponseDto> findAllRegistrations() {
        return new ResponseEntity<>(courseRegistrationService.findAllRegistrations(), HttpStatus.OK);
    }

    // 수강신청 취소
    @DeleteMapping("/{courseRegistrationId}")
    public ResponseEntity<String> cancelRegistration(@PathVariable Long courseRegistrationId) {
        courseRegistrationService.cancelByCourseRegistrationId(courseRegistrationId);
        String cancelResponseMessage = "요청하신 " + courseRegistrationId + "번 수강신청의 취소가 완료되었습니다";
        return new ResponseEntity<>(cancelResponseMessage,HttpStatus.OK);
    }

    // 학번을 통해 해당 학생의 수강신청 내역 조회
    @GetMapping("/findAll/{studentNumber}")
    public ResponseEntity<CourseRegistrationListResponseDto> findAllRegistrationsByStudnetNumber(@PathVariable Long studentNumber) {
        return new ResponseEntity<>(courseRegistrationService.findAllRegistrationsByStudentNumber(studentNumber),HttpStatus.OK);
    }

}
