package com.example.gdg_jpa.controller;


import com.example.gdg_jpa.dto.StudentDto;
import com.example.gdg_jpa.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    // 생성
    @PostMapping
    public ResponseEntity<StudentDto.Response> createStudent(@RequestBody StudentDto.Request request) {
        return ResponseEntity.ok(studentService.createStudent(request));

    }

    // 조회
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto.Response> getStudent(@PathVariable Long id) {

        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    // 수정
    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto.Response> updateStudent(@PathVariable Long id, @RequestBody StudentDto.Request request) {
        return ResponseEntity.ok(studentService.updateStudentById(id, request));
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<StudentDto.Response> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
