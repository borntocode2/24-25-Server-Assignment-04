package com.example.kiwoong.dto.courses.request;

import com.example.kiwoong.domain.Courses;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CoursesRequestDto {

    private Long id;

    private String name;

    private String day;

    private String room;

    public Courses toEntity() {
        return Courses.builder()
                .id(id)
                .name(name)
                .day(day)
                .room(room)
                .build();
    }
}