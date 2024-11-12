package com.example.seun.dto;

import com.example.seun.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class LectureRegisteredStudentForLectureDto {
    private Long id;
    private Long studentNumber;
    private String name;

    public static LectureRegisteredStudentForLectureDto from(Student student) {
        return LectureRegisteredStudentForLectureDto.builder()
                .id(student.getId())
                .studentNumber(student.getStudentNumber())
                .name(student.getName())
                .build();
    }
}
