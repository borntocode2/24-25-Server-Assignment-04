package com.example.gdg_jpa.service;

import com.example.gdg_jpa.domain.Student;
import com.example.gdg_jpa.dto.StudentDto;
import com.example.gdg_jpa.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Transactional
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // 생성
    public StudentDto.Response createStudent(StudentDto.Request request) {

        Student student=Student.builder()
                .id(request.getId())
                .name(request.getName())
                .year(request.getYear())
                .build();

        studentRepository.save(student);

        return StudentDto.Response.from(student);
    }

    // 조회
    public StudentDto.Response getStudentById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("학생이 존재하지 않습니다."));

        return StudentDto.Response.from(student);
    }

    // 수정
    public StudentDto.Response updateStudentById(Long id, StudentDto.Request request) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("학생이 존재하지 않습니다."));

        Student updateStudent = Student.builder()
                .id(id)       // URL path의 id 사용
                .name(request.getName())
                .year(request.getYear())
                .build();

        return StudentDto.Response.from(studentRepository.save(updateStudent));
    }

    // 삭제
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
