package com.example.sanghwa.dto.student;

import com.example.sanghwa.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponseDto {
    private Long id;
    private String name;

    public static StudentResponseDto from(Student student) {
        return StudentResponseDto.builder()
                .id(student.getId())
                .name(student.getName())
                .build();
    }
}
