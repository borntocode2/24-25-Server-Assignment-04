package com.example.jpaproject.Dto.Student.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class StudentListResponseDto {

    List<StudentResponseDto> studentInfoResponseDTOs;

    public static StudentListResponseDto from(List<StudentResponseDto> studentInfoResponseDTOs) {
        return StudentListResponseDto.builder()
                .studentInfoResponseDTOs(studentInfoResponseDTOs)
                .build();
    }
}
