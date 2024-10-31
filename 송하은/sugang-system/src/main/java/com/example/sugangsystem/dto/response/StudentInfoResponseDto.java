package com.example.sugangsystem.dto.response;

import com.example.sugangsystem.domain.Student;
import lombok.Builder;
import lombok.Getter;

// 학생들의 정보를 반환하는 DTO 이다.
@Builder
@Getter
public class StudentInfoResponseDto {

    private Long id;
    private String name;
    private String major;

    // entity -> dto
    public static StudentInfoResponseDto from(Student student){
        return StudentInfoResponseDto.builder()
                .id(student.getId())
                .name(student.getName())
                .major(student.getMajor())
                .build();
    }
}
