package com.example.sanghwa.dto.lecture;

import com.example.sanghwa.domain.Lecture;
import lombok.Builder;
import lombok.Getter;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Builder
@Getter
public class LectureListResponseDto{
    List<LectureResponseDto> lectureListDtos;

    public static LectureListResponseDto from(List<LectureResponseDto> lectureDtos) {
        return LectureListResponseDto.builder()
                .lectureListDtos(lectureDtos)
                .build();
    }
}
