package com.example.sanghwa.service;

import com.example.sanghwa.domain.Lecture;
import com.example.sanghwa.dto.LectureResponseDto;
import com.example.sanghwa.dto.LectureSaveDto;
import com.example.sanghwa.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class LectureService {

    private final LectureRepository lectureRepository;

    public LectureResponseDto save(LectureSaveDto lectureSaveDto) { //saveDto로 받고
        Lecture lecture = Lecture.builder() //lecture객체에 saveDto정보를 대입
                .title(lectureSaveDto.getTitle())
                .build();
        lectureRepository.save(lecture); //lecture객체 저장
        return LectureResponseDto.from(lecture); //ResponseDto로 반환
    }

    public List<Lecture> findLectures(){  //lectureRepository의 전체 lecture 반환, DTO로 변환할 필요 없지 않나?
        return lectureRepository.findAll(); //list로 출력하는 stream 사용?
    }

    public LectureResponseDto findLectureById(Long id){ //id 받고
        Lecture lecture = lectureRepository.findById(id) //레포지토리 id 찾아 객체 생성
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));
        return LectureResponseDto.from(lecture); //ResponseDto로 변환하여 반환
    }

    public LectureResponseDto updateLecture(Long id, LectureSaveDto lectureSaveDto) { //title만 받을 수도 있는데 속성이 늘어날 수도 있으니
        Lecture lecture = lectureRepository.findById(id) //
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));
        lecture.update(lectureSaveDto.getTitle()); //리포지토리에 삭제, 저장이 안되도 수정이 가능한 이유? 더티체킹?
        return LectureResponseDto.from(lecture);
    }

    public void deleteLecture(Long id) {
        lectureRepository.deleteById(id);
    }



}
