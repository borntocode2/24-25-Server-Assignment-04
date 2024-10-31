package com.example.seun.dto;

import com.example.seun.domain.Lecture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CourseRegisteredLectureForStudentDto {
    private Long id;
    private String title;
    private Long grade;
    private String content;

    public static CourseRegisteredLectureForStudentDto from(Lecture lecture){
        return CourseRegisteredLectureForStudentDto.builder()
                .id(lecture.getId())
                .title(lecture.getTitle())
                .grade(lecture.getGrade())
                .content(lecture.getContent())
                .build();
    }
}
