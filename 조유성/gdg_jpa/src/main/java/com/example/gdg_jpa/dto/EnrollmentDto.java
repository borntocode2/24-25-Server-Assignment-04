package com.example.gdg_jpa.dto;

import com.example.gdg_jpa.domain.Enrollment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class EnrollmentDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request{
        private Long id;
        private Long studentId;
        private Long lectureId;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response{
        private Long id;
        private String studentName;
        private String lectureName;

        public static Response from(Enrollment enrollment) {
            return Response.builder()
                    .id(enrollment.getId())
                    .studentName(enrollment.getStudent().getName())
                    .lectureName(enrollment.getLecture().getLectureName())
                    .build();
        }
    }
}
