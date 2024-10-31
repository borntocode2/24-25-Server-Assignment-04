package com.example.seun.service;

import com.example.seun.domain.CourseRegistration;
import com.example.seun.domain.Lecture;
import com.example.seun.domain.Student;
import com.example.seun.dto.CourseRegisteredLectureForStudentDto;
import com.example.seun.dto.RegisteredStudentForLectureDto;
import com.example.seun.repository.CourseRegistrationRepository;
import com.example.seun.repository.LectureRepository;
import com.example.seun.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseRegistrationService {

    private final CourseRegistrationRepository courseRegistrationRepository;
    private final StudentRepository studentRepository;
    private final LectureRepository lectureRepository;

    @Transactional
    public void courseRegistration(Long studentNumber, Long lectureId) {
        if(courseRegistrationRepository.existsByStudentStudentNumberAndLectureId(studentNumber, lectureId)) {
            throw new IllegalArgumentException("이미 수강 신청한 강의입니다.");
        }

        Student student = studentRepository.findById(studentNumber)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));

        CourseRegistration courseRegistration = new CourseRegistration(student, lecture);
        courseRegistrationRepository.save(courseRegistration);
    }

    @Transactional
    public List<RegisteredStudentForLectureDto> getStudentsByLecture(Long lectureId) {
        List<CourseRegistration> courseRegistrations = courseRegistrationRepository.findByLectureId(lectureId);

        return courseRegistrations.stream()
                .map(CourseRegistration::getStudent)
                .map(RegisteredStudentForLectureDto::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<CourseRegisteredLectureForStudentDto> getLecturesByStudent(Long studentNumber) {
        List<CourseRegistration> courseRegistrations = courseRegistrationRepository.findByStudent_StudentNumber(studentNumber);

        return courseRegistrations.stream()
                .map(CourseRegistration::getLecture)
                .map(CourseRegisteredLectureForStudentDto::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public void cancelCourseRegistration(Long studentNumber, Long lectureId) {
        if (!courseRegistrationRepository.existsByStudentStudentNumberAndLectureId(studentNumber, lectureId)) {
            throw new IllegalArgumentException("수강 신청 내역이 없습니다.");
        }

        courseRegistrationRepository.deleteByStudentStudentNumberAndLectureId(studentNumber, lectureId);
    }
}
