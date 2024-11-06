package com.example.sanghwa.service;

import com.example.sanghwa.domain.Lecture;
import com.example.sanghwa.domain.LectureRegistration;
import com.example.sanghwa.domain.Student;
import com.example.sanghwa.dto.registration.RegistrationListResponseDto;
import com.example.sanghwa.dto.registration.RegistrationResponseDto;
import com.example.sanghwa.dto.registration.RegistrationSaveDto;
import com.example.sanghwa.repository.LectureRegistrationRepository;
import com.example.sanghwa.repository.LectureRepository;
import com.example.sanghwa.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LectureRegistrationService {
    private final LectureRegistrationRepository lectureRegistrationRepository;
    private final LectureRepository lectureRepository;
    private final StudentRepository studentRepository;

    @Transactional
    public RegistrationResponseDto saveRegistration(RegistrationSaveDto registrationSaveDto){ //수강 신청
        Lecture lecture = lectureRepository.findById(registrationSaveDto.getLectureId()).orElseThrow(()
                -> new IllegalArgumentException("존재하지 않는 강의입니다."));
        Student student = studentRepository.findById(registrationSaveDto.getStudentId()).orElseThrow(()
                -> new IllegalArgumentException("존재하지 않는 학생입니다."));

        LectureRegistration lectureRegistration = LectureRegistration.builder()
                .lecture(lecture)
                .student(student)
                .build();
        lectureRegistrationRepository.save(lectureRegistration);
        return RegistrationResponseDto.from(lectureRegistration);
    }
    @Transactional
    public List<RegistrationListResponseDto> findAllRegistrationById(Long id){ //학생의 id로 수강신청 리스트 get
        List<LectureRegistration> lectureRegistrations = lectureRegistrationRepository.findByStudent_Id(id);
        return lectureRegistrations.stream()
                .map(RegistrationListResponseDto::from)
                .toList();
    }
    @Transactional
    public List<RegistrationResponseDto> getAllRegistration(){
        List<LectureRegistration> lectureRegistrations = lectureRegistrationRepository.findAll();
        return lectureRegistrations.stream()
                .map(RegistrationResponseDto::from)
                .toList();
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
