package com.example.sanghwa.service;

import com.example.sanghwa.domain.Student;

import com.example.sanghwa.dto.StudentResponseDto;

import com.example.sanghwa.dto.StudentSaveDto;
import com.example.sanghwa.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentService {
    
    private final StudentRepository studentRepository;

    public StudentResponseDto save(StudentSaveDto studentSaveDto) { //saveDto로 받고
        Student student = Student.builder() //student객체에 saveDto정보를 대입
                .name(studentSaveDto.getName())
                .build();
        studentRepository.save(student); //student객체 저장
        return StudentResponseDto.from(student); //ResponseDto로 반환
    }

    public List<Student> findstudents(){  //studentRepository의 전체 student 반환, DTO로 변환할 필요 없지 않나?
        return studentRepository.findAll(); //list로 출력하는 stream 사용?
    }

    public StudentResponseDto findstudentById(Long id){ //id 받고
        Student student = studentRepository.findById(id) //레포지토리 id 찾아 객체 생성
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
        return StudentResponseDto.from(student); //ResponseDto로 변환하여 반환
    }

    public StudentResponseDto updatestudent(Long id, StudentSaveDto studentSaveDto) {
        Student student = studentRepository.findById(id) //
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
        student.update(studentSaveDto.getName()); //리포지토리에 삭제, 저장이 안되도 수정이 가능한 이유? 더티체킹?
        return StudentResponseDto.from(student);
    }

    public void deletestudent(Long id) {
        studentRepository.deleteById(id);
    }



}

