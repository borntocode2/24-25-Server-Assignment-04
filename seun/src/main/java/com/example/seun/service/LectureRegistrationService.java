package com.example.seun.service;

import com.example.seun.domain.LectureRegistration;
import com.example.seun.domain.Lecture;
import com.example.seun.domain.Student;
import com.example.seun.dto.LectureRegisteredLectureForStudentDto;
import com.example.seun.dto.LectureRegisteredLecturesResponseDto;
import com.example.seun.dto.LectureRegisteredStudentForLectureDto;
import com.example.seun.dto.LectureRegisteredStudentsResponseDto;
import com.example.seun.repository.LectureRegistrationRepository;
import com.example.seun.repository.LectureRepository;
import com.example.seun.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectureRegistrationService {

    private final LectureRegistrationRepository lectureRegistrationRepository;
    private final StudentRepository studentRepository;
    private final LectureRepository lectureRepository;

    @Transactional
    public void LectureRegistration(Long studentId, Long lectureId) {
        if(lectureRegistrationRepository.existsByStudent_IdAndLecture_Id(studentId, lectureId)) {
            throw new IllegalArgumentException("이미 수강 신청한 강의입니다.");
        }

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));

        LectureRegistration lectureRegistration = LectureRegistration.of(student, lecture);
        lectureRegistrationRepository.save(lectureRegistration);
    }

    @Transactional
    public LectureRegisteredStudentsResponseDto getStudentsByLecture(Long lectureId) {
        List<LectureRegisteredStudentForLectureDto> students = lectureRegistrationRepository.findByLectureId(lectureId).stream()
                .map(LectureRegistration::getStudent)
                .map(LectureRegisteredStudentForLectureDto::from)
                .collect(Collectors.toList());
        return new LectureRegisteredStudentsResponseDto(students);
    }

    @Transactional
    public LectureRegisteredLecturesResponseDto getLecturesByStudent(Long studentId) {
        List<LectureRegisteredLectureForStudentDto> lectures = lectureRegistrationRepository.findByStudent_Id(studentId).stream()
                .map(LectureRegistration::getLecture)
                .map(LectureRegisteredLectureForStudentDto::from)
                .collect(Collectors.toList());
        return new LectureRegisteredLecturesResponseDto(lectures);
    }

    @Transactional
    public void cancelLectureRegistration(Long studentId, Long lectureId) {
        if (!lectureRegistrationRepository.existsByStudent_IdAndLecture_Id(studentId, lectureId)) {
            throw new IllegalArgumentException("수강 신청 내역이 없습니다.");
        }

        lectureRegistrationRepository.deleteByStudent_IdAndLecture_Id(studentId, lectureId);
    }
}
