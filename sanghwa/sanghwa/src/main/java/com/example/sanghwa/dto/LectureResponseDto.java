package com.example.sanghwa.dto;

import com.example.sanghwa.domain.Lecture;
import com.example.sanghwa.domain.LectureRegistration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LectureResponseDto {
    private Long id;
    private String title;

    public static LectureResponseDto from(Lecture lecture) {
        return LectureResponseDto.builder()
                .id(lecture.getId())
                .title(lecture.getTitle())
                .build();
    }
}
