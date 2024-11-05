package com.example.sanghwa.controller;

import com.example.sanghwa.domain.Student;
import com.example.sanghwa.dto.student.StudentResponseDto;
import com.example.sanghwa.dto.student.StudentSaveDto;
import com.example.sanghwa.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;//@RequiredArgsConstructor를 선언했을 때 왜 final을 쓰는가?

    @PostMapping
    public ResponseEntity<StudentResponseDto> save(@RequestBody StudentSaveDto studentSaveDto) {
        return new ResponseEntity<>(studentService.save(studentSaveDto), HttpStatus.OK);
    }

    @GetMapping("/studentList")
    public ResponseEntity<List<Student>> findAll() {
        return new ResponseEntity<>(studentService.findStudents(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentResponseDto> findByStudentId(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.findStudentById(id), HttpStatus.OK);
    }

    @PatchMapping("{id}")
    public ResponseEntity<StudentResponseDto> update(@PathVariable Long id, @RequestBody StudentSaveDto studentSaveDto) {
        return new ResponseEntity<>(studentService.updateStudent(id, studentSaveDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
