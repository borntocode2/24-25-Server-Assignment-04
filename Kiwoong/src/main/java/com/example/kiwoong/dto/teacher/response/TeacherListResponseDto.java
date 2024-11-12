package com.example.kiwoong.dto.teacher.response;

import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Builder
@Getter
public class TeacherListResponseDto {
    List<TeacherInfoResponseDto> teacherInfoResponseDTOs;

    public static TeacherListResponseDto from(List<TeacherInfoResponseDto> teacherInfoResponseDTOs) {
        return TeacherListResponseDto.builder()
                .teacherInfoResponseDTOs(teacherInfoResponseDTOs)
                .build();
    }
}