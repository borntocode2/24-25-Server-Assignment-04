package com.example.sanghwa.dto.lecture;

import lombok.Builder;
import lombok.Getter;
import java.util.List;
@Builder
@Getter
public class LectureListResponseDto{
    private List<LectureResponseDto> lectureListDtos;

    public static LectureListResponseDto from(List<LectureResponseDto> lectureDtos) {
        return LectureListResponseDto.builder()
                .lectureListDtos(lectureDtos)
                .build();
    }
}
