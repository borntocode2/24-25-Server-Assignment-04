package org.example.gdgweek4assignmentktw.dto.course.response;

import lombok.Builder;

import java.util.List;

@Builder
public class CourseListResponseDto {
    List<CourseInfoResponseDto> courseInfoResponseDTOs;

    public static CourseListResponseDto changeListToDto(List<CourseInfoResponseDto> dtoList) {
        return CourseListResponseDto.builder()
                .courseInfoResponseDTOs(dtoList)
                .build();
    }
}
