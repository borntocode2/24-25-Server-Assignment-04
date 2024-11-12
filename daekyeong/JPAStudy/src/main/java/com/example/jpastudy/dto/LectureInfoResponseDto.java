package com.example.jpastudy.dto;

import com.example.jpastudy.domain.Lecture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class LectureInfoResponseDto {
    private Long id;
    private String name;
    private String professor;
    private String major;

    public static LectureInfoResponseDto from(Lecture lecture) {
        return LectureInfoResponseDto.builder()
                .id(lecture.getId())
                .name(lecture.getName())
                .professor(lecture.getProfessor())
                .major(lecture.getMajor())
                .build();
    }
}
