package com.example.sanghwa.service;

import com.example.sanghwa.domain.Student;

import com.example.sanghwa.dto.student.StudentResponseDto;

import com.example.sanghwa.dto.student.StudentSaveDto;
import com.example.sanghwa.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    @Transactional
    public StudentResponseDto save(StudentSaveDto studentSaveDto) { //saveDto로 받고
        Student student = Student.builder().name(studentSaveDto.getName()).build(); //student객체에 saveDto정보를 대입
        studentRepository.save(student); //student객체 저장
        return StudentResponseDto.from(student); //ResponseDto로 반환
    }
    @Transactional
    public List<Student> findStudents(){  //studentRepository의 전체 student 반환, DTO로 변환할 필요 없지 않나?
        return studentRepository.findAll();
    }

    @Transactional
    public StudentResponseDto findStudentById(Long id){ //id 받고
        Student student = studentRepository.findById(id) //레포지토리 id 찾아 객체 생성
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
        return StudentResponseDto.from(student); //ResponseDto로 변환하여 반환
    }

    public StudentResponseDto updateStudent(Long id, StudentSaveDto studentSaveDto) {
        Student student = studentRepository.findById(id) //
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
        student.update(studentSaveDto.getName()); //리포지토리에 삭제, 저장이 안되도 수정이 가능한 이유? 더티체킹?
        return StudentResponseDto.from(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }



}

