package com.example.kiwoong.service;

import com.example.kiwoong.domain.Courses;
import com.example.kiwoong.domain.Student;
import com.example.kiwoong.dto.courses.response.CoursesInfoResponseDto;
import com.example.kiwoong.dto.student.request.StudentRequestDto;
import com.example.kiwoong.dto.student.response.StudentInfoResponseDto;
import com.example.kiwoong.dto.student.response.StudentListResponseDto;
import com.example.kiwoong.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional
    public StudentInfoResponseDto save(StudentRequestDto studentRequestDto) {
        Student student = studentRequestDto.toEntity();
        studentRepository.save(student);

        return StudentInfoResponseDto.from(student);
    }

    @Transactional(readOnly = true)
    public StudentInfoResponseDto findByStudentId(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("학생을 찾을 수 없습니다."));
        return StudentInfoResponseDto.from(student);
    }

    @Transactional(readOnly = true)
    public StudentListResponseDto StudentsList() {
        List<Student> students = studentRepository.findAll();
        List<StudentInfoResponseDto> studentDtos = students.stream()
                .map(StudentInfoResponseDto::from)
                .toList();

        return StudentListResponseDto.from(studentDtos);
    }
    @Transactional
    public StudentInfoResponseDto updateStudent(StudentRequestDto studentRequestDto) {
        Student student = studentRepository.findById(studentRequestDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));

        student.update(studentRequestDto);
        return StudentInfoResponseDto.from(student);
    }


    // Delete
    @Transactional
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }


}
