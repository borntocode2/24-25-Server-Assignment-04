package com.example.jpastudy.controller;

import com.example.jpastudy.dto.StudentInfoResponseDto;
import com.example.jpastudy.dto.StudentListResponseDto;
import com.example.jpastudy.dto.StudentSaveRequestDto;
import com.example.jpastudy.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentInfoResponseDto> saveStudent(@RequestBody StudentSaveRequestDto studentSaveRequestDto) {
        return new ResponseEntity<>(studentService.saveStudent(studentSaveRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentInfoResponseDto> findStudentById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(studentService.findStudentById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentInfoResponseDto> updateStudentById(@PathVariable(name = "id") Long id, @RequestBody StudentSaveRequestDto studentSaveRequestDto) {
        return new ResponseEntity<>(studentService.updateStudentById(id, studentSaveRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentInfoResponseDto> deleteStudentById(@PathVariable(name = "id") Long id) {
        studentService.deleteStudentById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<StudentListResponseDto> findAllStudents() {
        return new ResponseEntity<>(studentService.findAllStudent(), HttpStatus.OK);
    }


}
