package com.example.jpaproject.Service;

import com.example.jpaproject.Domain.Student;
import com.example.jpaproject.Dto.Student.request.StudentRequestDto;
import com.example.jpaproject.Dto.Student.response.StudentListResponseDto;
import com.example.jpaproject.Dto.Student.response.StudentResponseDto;
import com.example.jpaproject.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;

    @Transactional
    public void create(StudentRequestDto dto) {
        Long studentId = dto.getStudentId();
        if(isDuplicate(studentId)){
                throw new RuntimeException("중복된 학번입니다.");
        }
        studentRepository.save(dto.toEntity());
    }

    @Transactional(readOnly = true)
    public StudentResponseDto findByStudentId(Long studentId) {
        Student findStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
        return StudentResponseDto.from(findStudent);
    }

    @Transactional
    public StudentResponseDto updateStudent(StudentRequestDto dto) {
        Student findStudent = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));

        findStudent.update(dto);
        return StudentResponseDto.from(findStudent);
    }

    @Transactional
    public void deleteByStudentId(Long studentId) {
        Student findStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
        studentRepository.deleteById(studentId);
    }

    @Transactional(readOnly = true)
    public StudentListResponseDto findAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponseDto> studentInfoResponseDTOs = students.stream()
                .map(StudentResponseDto::from)
                .toList();
        return StudentListResponseDto.from(studentInfoResponseDTOs);

    }

    //중복검사
    public boolean isDuplicate(Long studentId){
        return studentRepository.existsById(studentId);
    }
}
