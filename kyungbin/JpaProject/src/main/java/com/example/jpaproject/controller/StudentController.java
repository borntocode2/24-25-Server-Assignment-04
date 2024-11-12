package com.example.jpaproject.controller;

import com.example.jpaproject.dto.StudentDto.StudentInfoResponseDto;
import com.example.jpaproject.dto.StudentDto.StudentSaveRequestDto;
import com.example.jpaproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentInfoResponseDto> save(@RequestBody StudentSaveRequestDto studentSaveRequestDto) {
        return new ResponseEntity<>(studentService.save(studentSaveRequestDto), HttpStatus.CREATED);
    }
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentInfoResponseDto> findByStudnetId(@PathVariable(name = "studentId") int studentId) {
        return new ResponseEntity<>(studentService.findByStudentId(studentId), HttpStatus.OK);
    }
    @PatchMapping("/{studentId}")
    public ResponseEntity<StudentInfoResponseDto> updateByStudentd(@PathVariable(name = "studentId") int studentId,
                                                              @RequestBody StudentSaveRequestDto studentSaveRequestDto) {
        return new ResponseEntity<>(studentService.updateByStudentId(studentId, studentSaveRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<StudentInfoResponseDto> deleteByStudentId(@PathVariable(name = "studentId") int studentId) {
        studentService.deleteByStudentId(studentId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
