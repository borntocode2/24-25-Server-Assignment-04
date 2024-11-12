package com.example.sugangsystem.dto.response.course;

import com.example.sugangsystem.domain.Course;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CourseInfoResponseDto {

    private Long id;
    private String title; // 강의명
    private String professor; // 교수


    // entity -> dto
    public static CourseInfoResponseDto from(Course course) {
        return CourseInfoResponseDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .professor(course.getProfessor())
                .build();
    }
}
