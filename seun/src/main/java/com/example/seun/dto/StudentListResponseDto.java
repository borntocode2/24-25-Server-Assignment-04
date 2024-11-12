package com.example.seun.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class StudentListResponseDto {
    List<StudentInfoResponseDto> studentInfoResponseDTOs;

    public static StudentListResponseDto from(List<StudentInfoResponseDto> studentInfoResponseDTOs) {
        return StudentListResponseDto.builder()
                .studentInfoResponseDTOs(studentInfoResponseDTOs)
                .build();
    }
}
