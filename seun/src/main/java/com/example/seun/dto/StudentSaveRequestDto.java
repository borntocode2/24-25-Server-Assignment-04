package com.example.seun.dto;

import com.example.seun.domain.Lecture;
import com.example.seun.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentSaveRequestDto {
    private Long studentNumber;
    private String name;

    public Student toEntity() {
        return Student.builder()
                .studentNumber(studentNumber)
                .name(name)
                .build();
    }
}
