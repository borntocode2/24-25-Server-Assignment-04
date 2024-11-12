package com.example.kiwoong.dto.student.response;

import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Builder
@Getter
public class StudentListResponseDto {
    List<StudentInfoResponseDto> studentInfoResponseDto;

    public static StudentListResponseDto from(List<StudentInfoResponseDto> studentInfoResponseDto) {
        return StudentListResponseDto.builder()
                .studentInfoResponseDto(studentInfoResponseDto)
                .build();
    }
}