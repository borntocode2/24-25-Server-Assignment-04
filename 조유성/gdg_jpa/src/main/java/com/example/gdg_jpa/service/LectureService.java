package com.example.gdg_jpa.service;

import com.example.gdg_jpa.domain.Lecture;
import com.example.gdg_jpa.dto.LectureDto;
import com.example.gdg_jpa.repository.LectureRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Transactional
@AllArgsConstructor
@Service
public class LectureService {

    private final LectureRepository lectureRepository;

    // 생성
    @Transactional
    public LectureDto.Response createLecture(LectureDto.Request request) {

        Lecture lecture = Lecture.builder()
                .lectureName(request.getLectureName())
                .build();

        lectureRepository.save(lecture);

        return LectureDto.Response.from(lecture);
    }
    // 조회
    @Transactional
    public LectureDto.Response readLectureById(Long id) {
        return LectureDto.Response.from(lectureRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 강의가 존재하지 않습니다.")));
    }

    // 수정
    @Transactional
    public LectureDto.Response updateLecture(Long id, LectureDto.Request request) {
        Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 강의가 존재하지 않습니다."));

        Lecture updateLecture=Lecture.builder()
                .id(id)
                .lectureName(request.getLectureName())
                .build();

        lectureRepository.save(updateLecture);

        return LectureDto.Response.from(updateLecture);
    }

    // 삭제
    @Transactional
    public void deleteLecture(Long id) {
        lectureRepository.deleteById(id);
    }
}
