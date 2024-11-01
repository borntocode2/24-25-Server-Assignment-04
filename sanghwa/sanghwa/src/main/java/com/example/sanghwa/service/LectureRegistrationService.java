package com.example.sanghwa.service;

import com.example.sanghwa.domain.LectureRegistration;
import com.example.sanghwa.dto.RegistrationResponseDto;
import com.example.sanghwa.dto.RegistrationSaveDto;
import com.example.sanghwa.repository.LectureRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LectureRegistrationService {
    private final LectureRegistrationRepository lectureRegistrationRepository;

    public RegistrationResponseDto courseRequest(RegistrationSaveDto registrationSaveDto){
        LectureRegistration lectureRegistration = registrationSaveDto.toEntity();



    }


}
