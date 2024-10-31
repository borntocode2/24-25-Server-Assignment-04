package com.example.sugangsystem.controller;

import com.example.sugangsystem.dto.request.student.StudentSaveRequestDto;
import com.example.sugangsystem.dto.request.student.StudentUpdateRequestDto;
import com.example.sugangsystem.dto.response.student.StudentInfoResponseDto;
import com.example.sugangsystem.dto.response.student.StudentListResponseDto;
import com.example.sugangsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    // 학생 생성
    @PostMapping("/create")
    public ResponseEntity<StudentInfoResponseDto> createStudent(@RequestBody StudentSaveRequestDto studentSaveRequestDto) {
        return new ResponseEntity<>(studentService.save(studentSaveRequestDto), HttpStatus.CREATED);
    }

    // 학생 한 명 조회
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentInfoResponseDto> findByStudentId(@PathVariable Long studentId) {
        return new ResponseEntity<>(studentService.findByStudentId(studentId), HttpStatus.OK);
    }

    // 전체 학생 조회
    @GetMapping("/all")
    public ResponseEntity<StudentListResponseDto> findAll() {
        return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
    }

    // 학생 정보 수정
    @PatchMapping("/{studentId}")
    public ResponseEntity<StudentInfoResponseDto> updateByStudentId(@PathVariable Long studentId, @RequestBody StudentUpdateRequestDto studentUpdateRequestDto) {
        return new ResponseEntity<>(studentService.updateStudentById(studentId, studentUpdateRequestDto), HttpStatus.OK);
    }

    // 학생 삭제
    @DeleteMapping("/{studentId}")
    public ResponseEntity<StudentInfoResponseDto> deleteByStudentId(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
