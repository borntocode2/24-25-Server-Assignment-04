package com.example.kiwoong.dto.student.response;

import com.example.kiwoong.domain.Courses;
import com.example.kiwoong.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class StudentInfoResponseDto {
    private Long id;
    private Long studentNumber;
    private String name;
    private Long age;
    private String major;

    public static StudentInfoResponseDto from(Student student) {
        return StudentInfoResponseDto.builder()
                .id(student.getId())
                .studentNumber(student.getStudentNumber())
                .name(student.getName())
                .age(student.getAge())
                .major(student.getMajor())
                .build();
    }
}