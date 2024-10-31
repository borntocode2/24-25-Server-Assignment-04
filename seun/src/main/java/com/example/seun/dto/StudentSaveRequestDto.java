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
    private String name;

    public Student toEntity() {
        return Student.builder()
                .name(name)
                .build();
    }
}
