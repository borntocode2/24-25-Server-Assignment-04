package com.example.sanghwa.service;

import com.example.sanghwa.domain.LectureRegistration;
import com.example.sanghwa.domain.Student;
import com.example.sanghwa.dto.RegistrationResponseDto;
import com.example.sanghwa.dto.RegistrationSaveDto;
import com.example.sanghwa.repository.LectureRegistrationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LectureRegistrationService {
    private final LectureRegistrationRepository lectureRegistrationRepository;

    @Transactional
    public RegistrationResponseDto saveRegistration(RegistrationSaveDto registrationSaveDto){ //수강 신청
        LectureRegistration lectureRegistration = registrationSaveDto.toEntity();
        lectureRegistrationRepository.save(lectureRegistration);
        return RegistrationResponseDto.from(lectureRegistration);
    }
    @Transactional
    public List<LectureRegistration> findAllRegistrationById(Long id){ //학생의 id로 수강신청 리스트 get
        return lectureRegistrationRepository.findByStudentId(id);
    }
    @Transactional
    public void deleteRegistrationById(Long id){
        if(!lectureRegistrationRepository.existsById(id))
        {
            throw new IllegalArgumentException("수강 신청 내역이 존재하지 않습니다.");
        }
        lectureRegistrationRepository.deleteById(id);
    }
}
