package com.example.sugangsystem.dto.request.student;

import com.example.sugangsystem.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class StudentUpdateRequestDto {
    private String name;
    private String major;

}
