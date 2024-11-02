package com.example.jpastudy.service;

import com.example.jpastudy.domain.Student;
import com.example.jpastudy.dto.StudentInfoResponseDto;
import com.example.jpastudy.dto.StudentListResponseDto;
import com.example.jpastudy.dto.StudentSaveRequestDto;
import com.example.jpastudy.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional
    public StudentInfoResponseDto saveStudent(StudentSaveRequestDto studentSaveRequestDto) {
        Student student = studentSaveRequestDto.toEntity();
        studentRepository.save(student);

        return StudentInfoResponseDto.from(student);
    }

    @Transactional(readOnly = true)
    public StudentInfoResponseDto findStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));

        return StudentInfoResponseDto.from(student);
    }

    @Transactional
    public StudentInfoResponseDto updateStudentById(Long id, StudentSaveRequestDto studentSaveRequestDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));

        student.update(studentSaveRequestDto.getId(), studentSaveRequestDto.getName());

        return StudentInfoResponseDto.from(student);
    }

    @Transactional
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    public StudentListResponseDto findAllStudent() {
        List<Student> students = studentRepository.findAll();

        List<StudentInfoResponseDto> studentInfoResponseDtos = students.stream()
                .map(StudentInfoResponseDto::from)
                .toList();

        return StudentListResponseDto.from(studentInfoResponseDtos);
    }

}
