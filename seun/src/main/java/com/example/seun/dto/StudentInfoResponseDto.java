package com.example.seun.dto;

import com.example.seun.domain.Student;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class StudentInfoResponseDto {
    private Long student_number;
    private String name;

    public static StudentInfoResponseDto from(Student student) {
        return StudentInfoResponseDto.builder()
                .student_number(student.getStudentNumber())
                .name(student.getName())
                .build();
    }

}
