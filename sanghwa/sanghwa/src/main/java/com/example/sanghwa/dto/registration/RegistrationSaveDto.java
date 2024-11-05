package com.example.sanghwa.dto.registration;

import com.example.sanghwa.domain.LectureRegistration;

import com.example.sanghwa.repository.LectureRepository;
import com.example.sanghwa.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RegistrationSaveDto {
    LectureRepository lectureRepository;
    StudentRepository studentRepository;
    private Long id;
    private Long studentId;
    private Long lectureId;

    @Transactional
    public LectureRegistration toEntity(){
        return LectureRegistration.builder()
                .lecture(lectureRepository.findById(lectureId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다.")))
                .student(studentRepository.findById(studentId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다.")))
                .build();
    }
}
