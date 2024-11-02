package com.example.kiwoong.dto.student.request;

import com.example.kiwoong.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDto {

    private Long studentNumber;

    private String name;

    private Long age;

    private String major;

    public Student toEntity() {
        return Student.builder()
                .studentNumber(studentNumber)
                .name(name)
                .age(age)
                .major(major)
                .build();
    }
}