package com.example.sanghwa.dto.lecture;

import com.example.sanghwa.domain.Lecture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


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
