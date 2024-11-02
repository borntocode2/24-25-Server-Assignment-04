package com.example.jpaproject.dto.StudentCourseDto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder

// 여러개의 수강신청 정보를 하나의 list로 묶어 응답을 보낸다.
public class StudentCourseListResponseDto {
    List<StudentCourseInfoResponseDto> studentCourseInfoResponseDTOs;


    public static StudentCourseListResponseDto from(List<StudentCourseInfoResponseDto> studentCourseInfoResponseDTOs){
        return StudentCourseListResponseDto.builder()
                .studentCourseInfoResponseDTOs(studentCourseInfoResponseDTOs)
                .build();
    }
}
