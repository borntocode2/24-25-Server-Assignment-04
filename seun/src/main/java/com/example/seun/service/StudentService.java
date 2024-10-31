package com.example.seun.service;

import com.example.seun.domain.Student;
import com.example.seun.dto.StudentInfoResponseDto;
import com.example.seun.dto.StudentListResponseDto;
import com.example.seun.dto.StudentSaveRequestDto;
import com.example.seun.repository.StudentRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional
    public StudentInfoResponseDto save(StudentSaveRequestDto studentSaveRequestDto) {
        Student student = studentSaveRequestDto.toEntity();
        studentRepository.save(student);

        return StudentInfoResponseDto.from(student);
    }

    @Transactional
    public StudentInfoResponseDto updateByStudentNumber(Long studentNumber, StudentSaveRequestDto studentSaveRequestDto) {
        Student student = studentRepository.findById(studentNumber)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));

        student.update(studentSaveRequestDto.getName());

        return StudentInfoResponseDto.from(student);
    }

    @Transactional
    public StudentInfoResponseDto getStudentByStudentNumber(Long studentNumber) {
        Student student = studentRepository.findById(studentNumber)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));

        return StudentInfoResponseDto.from(student);
    }

    @Transactional
    public void deleteByStudentNumber(Long studentNumber) {
        studentRepository.deleteById(studentNumber);
    }

    @Transactional(readOnly = true)
    public StudentListResponseDto findAllLectures(){
        List<Student> students = studentRepository.findAll();

        List<StudentInfoResponseDto> studentInfoResponseDtos = students.stream()
                .map(StudentInfoResponseDto::from)
                .toList();

        return StudentListResponseDto.from(studentInfoResponseDtos);
    }
}
