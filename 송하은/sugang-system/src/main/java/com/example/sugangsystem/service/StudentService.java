package com.example.sugangsystem.service;

import com.example.sugangsystem.domain.Student;
import com.example.sugangsystem.dto.request.student.StudentSaveRequestDto;
import com.example.sugangsystem.dto.request.student.StudentUpdateRequestDto;
import com.example.sugangsystem.dto.response.student.StudentInfoResponseDto;
import com.example.sugangsystem.dto.response.student.StudentListResponseDto;
import com.example.sugangsystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    // 학생 생성 - Create
    @Transactional
    public StudentInfoResponseDto save(StudentSaveRequestDto studentSaveRequestDto) {
        Student student = studentSaveRequestDto.toEntity();
        studentRepository.save(student);

        return StudentInfoResponseDto.from(student);
    }

    // 학생 한 명 조회 - Read
    @Transactional(readOnly = true)
    public StudentInfoResponseDto findByStudentId(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));

        return StudentInfoResponseDto.from(student); // 다시 dto로 변환하여 컨트롤러에게 전달.
    }

    // 전체 학생 목록 조회 - Read
    @Transactional(readOnly = true)
    public StudentListResponseDto getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentInfoResponseDto> studentDtos = students.stream()
                .map(StudentInfoResponseDto::from)
                .toList();

        return StudentListResponseDto.from(studentDtos);
    }

    // 학생 수정 - Update
    @Transactional
    public StudentInfoResponseDto updateStudentById(Long id, StudentUpdateRequestDto studentUpdateRequestDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
        student.update(studentUpdateRequestDto.getName(), studentUpdateRequestDto.getMajor());

        return StudentInfoResponseDto.from(student);
    }


    // 학생 삭제 - Delete
    @Transactional
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }




}
