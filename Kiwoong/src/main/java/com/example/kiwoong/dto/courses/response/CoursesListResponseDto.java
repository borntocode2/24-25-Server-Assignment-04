package com.example.kiwoong.dto.courses.response;

import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Builder
@Getter
public class CoursesListResponseDto {
    List<CoursesInfoResponseDto> coursesInfoResponseDtos;

    public static CoursesListResponseDto from(List<CoursesInfoResponseDto> coursesInfoResponseDtos) {
        return CoursesListResponseDto.builder()
                .coursesInfoResponseDtos(coursesInfoResponseDtos)
                .build();
    }
}