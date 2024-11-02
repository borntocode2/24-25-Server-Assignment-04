package com.example.seun.dto;

import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Builder
@Getter
public class LectureListResponseDto {
    List<LectureInfoResponseDto> lectureInfoResponseDTOs;

    public static LectureListResponseDto from(List<LectureInfoResponseDto> lectureInfoResponseDTOs) {
        return LectureListResponseDto.builder()
                .lectureInfoResponseDTOs(lectureInfoResponseDTOs)
                .build();
    }
}
