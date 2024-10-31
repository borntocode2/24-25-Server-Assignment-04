package com.example.seun.controller;

import com.example.seun.dto.StudentInfoResponseDto;
import com.example.seun.dto.StudentListResponseDto;
import com.example.seun.dto.StudentSaveRequestDto;
import com.example.seun.service.StudentService;
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

    @PatchMapping("/{studentNumber}")
    public ResponseEntity<StudentInfoResponseDto> updateByStudentNumber(@PathVariable(name = "studentNumber") Long studentNumbeber,
                                                                        @RequestBody StudentSaveRequestDto studentSaveRequestDto) {
        return new ResponseEntity<>(studentService.updateByStudentNumber(studentNumbeber, studentSaveRequestDto), HttpStatus.OK);
    }

    @GetMapping("/{studentNumber}")
    public ResponseEntity<StudentInfoResponseDto> getByStudentNumber(@PathVariable(name = "studentNumber") Long studentNumber) {
        return new ResponseEntity<>(studentService.getStudentByStudentNumber(studentNumber), HttpStatus.OK);
    }

    @DeleteMapping("/{studentNumber}")
    public ResponseEntity<Void> deleteByStudentNumber(@PathVariable(name = "studentNumber") Long studentNumber) {
        studentService.deleteByStudentNumber(studentNumber);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<StudentListResponseDto> findAllStudents() {
        return new ResponseEntity<>(studentService.findAllLectures(), HttpStatus.OK);
    }
}
