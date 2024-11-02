package com.example.kiwoong.controller;

import com.example.kiwoong.dto.student.request.StudentRequestDto;
import com.example.kiwoong.dto.student.response.StudentInfoResponseDto;
import com.example.kiwoong.dto.student.response.StudentListResponseDto;
import com.example.kiwoong.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    // 학생 생성
    @PostMapping
    public ResponseEntity<StudentInfoResponseDto> createStudent(@RequestBody StudentRequestDto studentRequestDto) {
        StudentInfoResponseDto response = studentService.save(studentRequestDto);
        return ResponseEntity.ok(response); // 200 OK 응답
    }

    // 학생 조회
    @GetMapping("/{id}")
    public ResponseEntity<StudentInfoResponseDto> getStudentById(@PathVariable Long id) {
        StudentInfoResponseDto response = studentService.findByStudentId(id);
        return ResponseEntity.ok(response); // 200 OK 응답
    }

    // 모든 학생 조회
    @GetMapping
    public ResponseEntity<StudentListResponseDto> getAllStudents() {
        StudentListResponseDto response = studentService.StudentsList();
        return ResponseEntity.ok(response); // 200 OK 응답
    }

    // 학생 업데이트
    @PutMapping
    public ResponseEntity<StudentInfoResponseDto> updateStudent(@RequestBody StudentRequestDto studentRequestDto) {
        StudentInfoResponseDto response = studentService.updateStudent(studentRequestDto);
        return ResponseEntity.ok(response); // 200 OK 응답
    }

    // 학생 삭제
    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
        return ResponseEntity.noContent().build(); // 204 No Content 응답
    }
}
