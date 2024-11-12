package com.example.seun.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class LectureRegisteredLecturesResponseDto {
    private List<LectureRegisteredLectureForStudentDto> lectures;
}
