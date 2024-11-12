package com.example.jpastudy.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class LectureListResponseDto {
    List<LectureInfoResponseDto> lectureInfoResponseDtos;

    public static LectureListResponseDto from(List<LectureInfoResponseDto> lectureInfoResponseDtos) {
        return LectureListResponseDto.builder()
                .lectureInfoResponseDtos(lectureInfoResponseDtos)
                .build();
    }
}
