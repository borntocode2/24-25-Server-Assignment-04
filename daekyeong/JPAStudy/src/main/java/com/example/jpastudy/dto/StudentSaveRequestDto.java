package com.example.jpastudy.dto;

import com.example.jpastudy.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentSaveRequestDto {
    private String name;
    private Long id;

    public Student toEntity(){
        return Student.builder()
                .name(name)
                .id(id)
                .build();
    }
}
