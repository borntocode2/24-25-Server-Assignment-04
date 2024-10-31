package com.example.sugangsystem.dto.response.course;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CourseListResponseDto {

    List<CourseInfoResponseDto> courseDtos;

    public static CourseListResponseDto from(List<CourseInfoResponseDto> courseDtos) {
        return CourseListResponseDto.builder()
                .courseDtos(courseDtos)
                .build();

    }


}
