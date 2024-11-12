package com.example.jpaproject.Dto.Student.request;

import com.example.jpaproject.Domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDto {

    private Long studentId;

    private String name;

    public Student toEntity(){
        return Student.builder()
                .studentId(studentId)
                .name(name)
                .build();
    }
}
