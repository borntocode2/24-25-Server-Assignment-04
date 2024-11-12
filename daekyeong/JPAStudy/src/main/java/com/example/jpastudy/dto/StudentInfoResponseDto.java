package com.example.jpastudy.dto;

import com.example.jpastudy.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class StudentInfoResponseDto {
    private Long studentId;
    private String name;

    public static StudentInfoResponseDto from(Student student) {
        return StudentInfoResponseDto.builder()
                .studentId(student.getId())
                .name(student.getName())
                .build();
    }
}
