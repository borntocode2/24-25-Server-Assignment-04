package com.example.jpaproject.Controller;

import com.example.jpaproject.Dto.Student.request.StudentRequestDto;
import com.example.jpaproject.Dto.Student.response.StudentListResponseDto;
import com.example.jpaproject.Dto.Student.response.StudentResponseDto;
import com.example.jpaproject.Service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponseDto> create(@RequestBody StudentRequestDto dto) {
        log.info("student create 요청 -{}", dto);
        studentService.create(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResponseDto> findByStudentId(@PathVariable Long studentId) {
        log.info("student read 요청 -{}", studentId);
        StudentResponseDto findStudent = studentService.findByStudentId(studentId);
        return ResponseEntity.ok().body(findStudent);
    }

    @PatchMapping("/{studentId}")
    public ResponseEntity<StudentResponseDto> update(@PathVariable Long studentId, @RequestBody StudentRequestDto dto) {
        log.info("student update 요청 -{}", dto.getStudentId());
            StudentResponseDto updateStudent = studentService.updateStudent(dto);
            return ResponseEntity.ok().body(updateStudent);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<StudentResponseDto> delete(@PathVariable Long studentId) {
        log.info("student delete 요청 -{}", studentId);
        studentService.deleteByStudentId(studentId);
            return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<StudentListResponseDto> findAllStudents() {
        log.info("student findAll 요청 -{}");
        StudentListResponseDto allStudents = studentService.findAllStudents();
        return ResponseEntity.ok().body(allStudents);
    }
}
