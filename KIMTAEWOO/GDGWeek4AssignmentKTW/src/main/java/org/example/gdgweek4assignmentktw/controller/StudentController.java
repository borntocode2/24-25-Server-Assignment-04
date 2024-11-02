package org.example.gdgweek4assignmentktw.controller;

import lombok.RequiredArgsConstructor;
import org.example.gdgweek4assignmentktw.dto.student.request.StudentSaveRequestDto;
import org.example.gdgweek4assignmentktw.dto.student.response.StudentInfoResponseDto;
import org.example.gdgweek4assignmentktw.dto.student.response.StudentListResponseDto;
import org.example.gdgweek4assignmentktw.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    //학생 저장
    @PostMapping
    public ResponseEntity<StudentInfoResponseDto> saveStudent(@RequestBody StudentSaveRequestDto dto) {
        return new ResponseEntity<>(studentService.save(dto), HttpStatus.OK);
    }

    // studentId로 학생 조회
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentInfoResponseDto> findByStudentId(@PathVariable Long studentId) {
        return new ResponseEntity<>(studentService.findByStudentId(studentId), HttpStatus.OK);
    }

    // studentId로 학생 정보 업데이트
    @PatchMapping("/{studentId}")
    public ResponseEntity<StudentInfoResponseDto> updateByStudentId(@PathVariable Long studentId
            ,@RequestBody StudentSaveRequestDto dto) {
        return new ResponseEntity<>(studentService.updateByStudentId(studentId, dto), HttpStatus.OK);
    }

    // studentId로 학생 삭제
    @DeleteMapping("{studentId}")
    public ResponseEntity<String> deleteByStudentId(@PathVariable Long studentId) {
        studentService.deleteByStudentId(studentId);
        String deleteResponseMessage = studentId + "번 학생이 성공적으로 삭제되었습니다";
        return new ResponseEntity<>(deleteResponseMessage, HttpStatus.OK);
    }

    // 모든 학생 조회
    @GetMapping
    public ResponseEntity<StudentListResponseDto> findAllStudents() {
        return new ResponseEntity<>(studentService.findAllStudents(), HttpStatus.OK);
    }
}
