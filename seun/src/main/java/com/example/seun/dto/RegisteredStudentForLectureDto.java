package com.example.seun.dto;

import com.example.seun.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RegisteredStudentForLectureDto {
    private Long studentNumber;
    private String name;

    public static RegisteredStudentForLectureDto from(Student student) {
        return RegisteredStudentForLectureDto.builder()
                .studentNumber(student.getStudentNumber())
                .name(student.getName())
                .build();
    }
}
