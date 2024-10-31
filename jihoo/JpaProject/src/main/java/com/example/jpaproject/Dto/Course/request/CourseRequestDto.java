package com.example.jpaproject.Dto.Course.request;

import com.example.jpaproject.Domain.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequestDto {

    private String title;

    private String professor;

    public Course toEntity() {
        return Course.builder()
                .title(title)
                .professor(professor)
                .build();
    }
}
