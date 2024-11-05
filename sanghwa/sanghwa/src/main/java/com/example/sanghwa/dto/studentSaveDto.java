package com.example.sanghwa.dto;

import com.example.sanghwa.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentSaveDto {
    private String name;

    public Student toEntity(){
        return Student.builder()
                .name(name)
                .build();
    }
}
