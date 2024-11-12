package com.example.kiwoong.dto.teacher.request;

import com.example.kiwoong.domain.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRequestDto {

    private String name;

    private Long age;

    private String major;

    public Teacher toEntity() {
        return Teacher.builder()
                .name(name)
                .age(age)
                .major(major)
                .build();
    }
}