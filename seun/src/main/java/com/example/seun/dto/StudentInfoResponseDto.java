package com.example.seun.dto;

import com.example.seun.domain.Student;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class StudentInfoResponseDto {
    private Long id;
    private Long studentNumber;
    private String name;

    public static StudentInfoResponseDto from(Student student) {
        return StudentInfoResponseDto.builder()
                .id(student.getId())
                .studentNumber(student.getStudentNumber())
                .name(student.getName())
                .build();
    }

}
