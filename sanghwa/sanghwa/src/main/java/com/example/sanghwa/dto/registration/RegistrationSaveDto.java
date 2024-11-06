package com.example.sanghwa.dto.registration;

import com.example.sanghwa.domain.LectureRegistration;

import com.example.sanghwa.repository.LectureRepository;
import com.example.sanghwa.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RegistrationSaveDto {
    private Long studentId;
    private Long lectureId;
}
