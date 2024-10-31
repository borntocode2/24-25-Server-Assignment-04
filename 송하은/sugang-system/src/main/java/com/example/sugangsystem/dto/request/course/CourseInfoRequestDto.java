package com.example.sugangsystem.dto.request.course;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CourseInfoRequestDto {
    private Long id;
    private String title; // 강의명
    private String professor; // 교수

}
