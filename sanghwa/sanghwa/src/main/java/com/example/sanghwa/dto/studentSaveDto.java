package com.example.sanghwa.dto;

import com.example.sanghwa.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentSaveDto {
    private Long id;
    private String name;

    public Student toEntity(){
        return Student.builder()
                .id(id)
                .name(name)
                .build();
    }
}
