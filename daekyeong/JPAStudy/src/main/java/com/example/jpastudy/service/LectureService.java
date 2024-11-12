package com.example.jpastudy.service;

import com.example.jpastudy.domain.Lecture;
import com.example.jpastudy.domain.Student;
import com.example.jpastudy.dto.LectureInfoResponseDto;
import com.example.jpastudy.dto.LectureListResponseDto;
import com.example.jpastudy.dto.LectureSaveRequestDto;
import com.example.jpastudy.repository.LectureRepository;
import com.example.jpastudy.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;
    private final StudentRepository studentRepository;

    @Transactional
    public LectureInfoResponseDto saveLecture(LectureSaveRequestDto lectureSaveRequestDto) {

        Lecture lecture = Lecture.builder()
                .name(lectureSaveRequestDto.getName())
                .professor(lectureSaveRequestDto.getProfessor())
                .major(lectureSaveRequestDto.getMajor())
                .build();

        lectureRepository.save(lecture);
        return LectureInfoResponseDto.from(lecture);
    }

    @Transactional(readOnly = true)
    public LectureInfoResponseDto findLectureById(Long id) {
        Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));

        return LectureInfoResponseDto.from(lecture);
    }

    @Transactional
    public LectureInfoResponseDto updateLectureById(Long id, LectureSaveRequestDto lectureSaveRequestDto) {
        Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));

        lecture.update(lectureSaveRequestDto.getName(), lectureSaveRequestDto.getProfessor()
        , lectureSaveRequestDto.getMajor());

        return LectureInfoResponseDto.from(lecture);
    }

    @Transactional
    public void deleteLectureById(Long id) {
        lectureRepository.deleteById(id);
    }

    @Transactional
    public LectureListResponseDto findAllLectures() {
        List<Lecture> lectures = lectureRepository.findAll();

        List<LectureInfoResponseDto> lectureInfoResponseDtos = lectures.stream()
                .map(LectureInfoResponseDto::from)
                .toList();

        return LectureListResponseDto.from(lectureInfoResponseDtos);
    }
}
