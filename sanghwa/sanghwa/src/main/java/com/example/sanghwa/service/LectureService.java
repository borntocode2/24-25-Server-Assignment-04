package com.example.sanghwa.service;

import com.example.sanghwa.domain.Lecture;
import com.example.sanghwa.dto.LectureSaveDto;
import com.example.sanghwa.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LectureService {

    private final LectureRepository lectureRepository;

    public LectureSaveDto save(LectureSaveDto lectureSaveDto) {
        Lecture lecture = Lecture.builder()
                .title(lectureSaveDto.getTitle())
                .build();
        lectureRepository.save(lecture);
        return lectureSaveDto.from(lecture);
    }

    public List<Lecture> findAll(){  //lectureRepository의 전체 lecture 반환, DTO로 변환할 필요 없지 않나?
        return lectureRepository.findAll();
    }


}
