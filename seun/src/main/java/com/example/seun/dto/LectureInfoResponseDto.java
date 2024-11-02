package com.example.seun.dto;

import com.example.seun.domain.Lecture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class LectureInfoResponseDto {
    private Long id;
    private String title;
    private Long credit;
    private String content;

    public static LectureInfoResponseDto from(Lecture lecture) {
        return LectureInfoResponseDto.builder()
                .id(lecture.getId())
                .title(lecture.getTitle())
                .credit(lecture.getCredit())
                .content(lecture.getContent())
                .build();
    }
}
