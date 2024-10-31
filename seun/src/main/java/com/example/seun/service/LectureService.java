package com.example.seun.service;

import com.example.seun.domain.Lecture;
import com.example.seun.dto.LectureInfoResponseDto;
import com.example.seun.dto.LectureListResponseDto;
import com.example.seun.dto.LectureSaveRequestDto;
import com.example.seun.repository.LectureRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;

    @Transactional
    public LectureInfoResponseDto save(LectureSaveRequestDto lectureSaveRequestDto) {
        Lecture lecture = Lecture.builder()
                .title(lectureSaveRequestDto.getTitle())
                .grade(lectureSaveRequestDto.getGrade())
                .content(lectureSaveRequestDto.getContent())
                .build();
        lectureRepository.save(lecture);

        return LectureInfoResponseDto.from(lecture);
    }

    @Transactional(readOnly = true)
    public LectureInfoResponseDto findByLectureId(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));

        return LectureInfoResponseDto.from(lecture);
    }

    @Transactional
    public LectureInfoResponseDto updateByLectureId(Long lectureId, LectureSaveRequestDto lectureSaveRequestDto) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));

        lecture.update(lectureSaveRequestDto.getTitle(), lectureSaveRequestDto.getGrade(), lectureSaveRequestDto.getContent());

        return LectureInfoResponseDto.from(lecture);
    }

    @Transactional
    public void deleteByLectureId(Long lectureId) {
        lectureRepository.deleteById(lectureId);
    }

    @Transactional(readOnly = true)
    public LectureListResponseDto findAllLectures(){
        List<Lecture> lectures = lectureRepository.findAll();

        List<LectureInfoResponseDto> lectureInfoResponseDtos = lectures.stream()
                .map(LectureInfoResponseDto::from)
                .toList();

        return LectureListResponseDto.from(lectureInfoResponseDtos);
    }

}
