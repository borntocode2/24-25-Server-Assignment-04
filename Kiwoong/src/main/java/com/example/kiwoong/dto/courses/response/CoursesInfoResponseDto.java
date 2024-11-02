package com.example.kiwoong.dto.courses.response;

import com.example.kiwoong.domain.Courses;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
public class CoursesInfoResponseDto {
    private String name;
    private String day;
    private String room;

    public static CoursesInfoResponseDto from(Courses courses) {
        return CoursesInfoResponseDto.builder()
                .name(courses.getName())
                .day(courses.getDay())
                .room(courses.getRoom())
                .build();
    }
}