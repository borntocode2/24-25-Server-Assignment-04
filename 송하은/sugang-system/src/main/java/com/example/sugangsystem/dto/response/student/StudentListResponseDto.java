package com.example.sugangsystem.dto.response.student;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class StudentListResponseDto {

    List<StudentInfoResponseDto> studentDtos;

    public static StudentListResponseDto from(List<StudentInfoResponseDto> studentDtos) {
        return StudentListResponseDto.builder()
                .studentDtos(studentDtos)
                .build();

    }

}
