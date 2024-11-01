package com.example.sanghwa.dto;

import com.example.sanghwa.domain.Lecture;
import com.example.sanghwa.domain.LectureRegistration;

import com.example.sanghwa.repository.LectureRepository;
import com.example.sanghwa.repository.StudentRepository;
import jakarta.persistence.Id;

public class RegistrationSaveDto {
    LectureRepository lectureRepository;
    StudentRepository studentRepository;

    @Id
    private Long id;
    private Long studentId;
    private Long lectureId;

    public LectureRegistration toEntity(){
        return LectureRegistration.builder()
                .lecture(lectureRepository.findById(lectureId))

                .build();
    }
}
