package com.example.jpaproject.Dto.Student.response;

import com.example.jpaproject.Domain.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponseDto {

    private Long studentId;

    private String name;

    public static StudentResponseDto from(Student student) {
        return StudentResponseDto.builder()
                .studentId((student.getStudentId()))
                .name(student.getName())
                .build();
    }
}
