package com.example.sanghwa.dto.student;

import com.example.sanghwa.dto.lecture.LectureResponseDto;
import lombok.Builder;
import lombok.Getter;
import java.util.List;
@Builder
@Getter
public class StudentListResponseDto{
    List<StudentResponseDto> studentListDtos;

    public static StudentListResponseDto from(List<StudentResponseDto> studentDtos) {
        return StudentListResponseDto.builder()
                .studentListDtos(studentDtos)
                .build();
    }
}
