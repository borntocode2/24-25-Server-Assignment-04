package org.example.gdgweek4assignmentktw.service;


import lombok.RequiredArgsConstructor;
import org.example.gdgweek4assignmentktw.domain.Student;
import org.example.gdgweek4assignmentktw.dto.student.request.StudentSaveRequestDto;
import org.example.gdgweek4assignmentktw.dto.student.response.StudentInfoResponseDto;
import org.example.gdgweek4assignmentktw.dto.student.response.StudentListResponseDto;
import org.example.gdgweek4assignmentktw.exception.StudentAlreadyExistsException;
import org.example.gdgweek4assignmentktw.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
// @RequiredArgsConstructor으로 생성자 주입
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional
    public StudentInfoResponseDto save(StudentSaveRequestDto dto) {
        if(studentRepository.existsByStudentNumber(dto.getStudentNumber())){
            throw new StudentAlreadyExistsException("이미 존재하는 학번입니다.");
        }

        Student saveStudent = dto.toEntity();
        studentRepository.save(saveStudent);

        return StudentInfoResponseDto.includeAllFieldFrom(saveStudent);
    }

    @Transactional
    public StudentInfoResponseDto findByStudentId(Long studentId) {
        Student foundStudent = studentRepository.findById(studentId)
                .orElseThrow( () -> new IllegalArgumentException("존재하지 않는 학생입니다"));

        return StudentInfoResponseDto.includeAllFieldFrom(foundStudent);
    }

    @Transactional
    public StudentInfoResponseDto updateByStudentId(Long studentId, StudentSaveRequestDto dto) {
        Student updateStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다"));

        if(studentRepository.existsByStudentNumber(dto.getStudentNumber())){
            throw new StudentAlreadyExistsException("이미 존재하는 학번입니다.");
        }


        updateStudent.update(dto);

        return StudentInfoResponseDto.includeAllFieldFrom(updateStudent);
    }

    @Transactional
    public void deleteByStudentId(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Transactional(readOnly = true)
    public StudentListResponseDto findAllStudents() {
        List<Student> students = studentRepository.findAll();

        List<StudentInfoResponseDto> studentDtoList = students.stream()
                .map(StudentInfoResponseDto::includeAllFieldFrom)
                .toList();

        return StudentListResponseDto.changeListToDto(studentDtoList);
    }
}
