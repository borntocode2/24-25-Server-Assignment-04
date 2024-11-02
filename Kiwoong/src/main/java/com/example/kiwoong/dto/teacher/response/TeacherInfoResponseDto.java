package com.example.kiwoong.dto.teacher.response;

import com.example.kiwoong.domain.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TeacherInfoResponseDto {
    private String name;
    private Long age;
    private String major;

    public static TeacherInfoResponseDto from(Teacher teacher) {
        return TeacherInfoResponseDto.builder()
                .name(teacher.getName())
                .age(teacher.getAge())
                .major(teacher.getMajor())
                .build();
    }
}