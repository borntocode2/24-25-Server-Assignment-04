package com.example.sugangsystem.dto.request.course;

import com.example.sugangsystem.domain.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CourseSaveRequestDto {

    private String title; // 강의명
    private String professor; // 교수

    public Course toEntity() {
        return Course.builder()
                .title(title)
                .professor(professor)
                .build();

    }
}
