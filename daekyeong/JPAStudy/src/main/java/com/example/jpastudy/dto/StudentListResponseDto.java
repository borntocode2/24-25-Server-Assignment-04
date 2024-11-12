package com.example.jpastudy.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StudentListResponseDto {
    List<StudentInfoResponseDto> studentInfoResponseDtos;

    public static StudentListResponseDto from(List<StudentInfoResponseDto> studentInfoResponseDtos) {
        return StudentListResponseDto.builder()
                .studentInfoResponseDtos(studentInfoResponseDtos)
                .build();
    }
}
