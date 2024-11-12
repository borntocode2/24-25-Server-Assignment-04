package com.example.jpaproject.Dto.Course.response;

import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Builder
@Getter
public class CourseListResponseDto {

    List<CourseResponseDto> CourseInfoResponseDTOs;

    public static CourseListResponseDto from(List<CourseResponseDto> CourseInfoResponseDTOs) {
        return CourseListResponseDto.builder()
                .CourseInfoResponseDTOs(CourseInfoResponseDTOs)
                .build();
    }
}
