package com.example.jpaproject.dto.StudentCourseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class StudentCourseSaveRequestDto {
    private int studentId;
    private int courseId;

    // 여기선 toEntity 안해줘도 되는건가??
}
