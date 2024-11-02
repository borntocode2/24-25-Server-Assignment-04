package com.example.gdg_jpa.dto;

import com.example.gdg_jpa.domain.Lecture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class LectureDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request{
        private Long id;
        private String lectureName;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response{
        private Long id;
        private String lectureName;

        public static Response from(Lecture lecture) {
            return Response.builder()
                    .id(lecture.getId())
                    .lectureName(lecture.getLectureName())
                    .build();
        }
    }
}
