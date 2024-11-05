package com.example.jpaproject.service;

import com.example.jpaproject.domain.Student;
import com.example.jpaproject.dto.StudentCourseDto.StudentCourseSaveRequestDto;
import com.example.jpaproject.dto.StudentDto.StudentInfoResponseDto;
import com.example.jpaproject.dto.StudentDto.StudentSaveRequestDto;
import com.example.jpaproject.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional // 예외가 발생하는 경우 롤백한다.
    // Create : 학생 정보 생성
    //Student객체를 생성 저장해서 StudentInfoResponseDto에 저장한다.
    public StudentInfoResponseDto save(StudentSaveRequestDto studentSaveRequestDto) {

        // 전달받은 Dto를 엔터티로 변환하여 Repository에 저장한다.
        Student student = studentSaveRequestDto.toEntity();
        studentRepository.save(student);

        return StudentInfoResponseDto.from(student);
    }
    @Transactional
    // Read : id로 학생 정보 조회
    public StudentInfoResponseDto findByStudentId(int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("없는 학생 id입니다."));

        return StudentInfoResponseDto.from(student);
    }

    @Transactional
    // Update : 학생정보를 수정한다.
    public StudentInfoResponseDto updateByStudentId(int id, StudentSaveRequestDto studentSaveRequestDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("없는 학생 id입니다."));
            student.update(studentSaveRequestDto.getName(), studentSaveRequestDto.getMajor());

        return StudentInfoResponseDto.from(student);

    }
    @Transactional
    //Delete : 학생 정보 삭제한다.
    public void deleteByStudentId(int id) {
        studentRepository.deleteById(id);
    }
}
