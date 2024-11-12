package com.example.jpaproject.Dto.Course.response;


import com.example.jpaproject.Domain.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
public class CourseResponseDto {

    private Long courseId;

    private String title;

    private String professor;

    public static CourseResponseDto from(Course course) {
        return CourseResponseDto.builder()
                .courseId(course.getCourseId())
                .title(course.getTitle())
                .professor(course.getProfessor())
                .build();
    }
}
