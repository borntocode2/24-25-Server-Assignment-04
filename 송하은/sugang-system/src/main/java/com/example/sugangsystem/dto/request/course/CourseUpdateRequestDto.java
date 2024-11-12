package com.example.sugangsystem.dto.request.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CourseUpdateRequestDto {

    private String title; // 강의명
    private String professor; // 교수

}
