package com.example.sugangsystem.dto.request;

import com.example.sugangsystem.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentSaveRequestDto {
    private String name;
    private String major;

    public Student toEntity() {
        return Student.builder()
                .name(name)
                .major(major)
                .build();
    }
}
