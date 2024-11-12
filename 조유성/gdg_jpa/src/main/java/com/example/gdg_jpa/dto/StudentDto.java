package com.example.gdg_jpa.dto;

import com.example.gdg_jpa.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StudentDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request{
        private Long id;
        private String name;
        private int year;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response{
        private Long id;
        private String name;
        private int year;

        public static Response from(Student student){
            return   Response.builder()
                    .id(student.getId())
                    .name(student.getName())
                    .year(student.getYear())
                    .build();
        }
    }
}
