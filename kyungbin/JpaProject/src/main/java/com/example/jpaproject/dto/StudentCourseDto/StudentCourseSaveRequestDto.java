package com.example.jpaproject.dto.StudentCourseDto;

import com.example.jpaproject.domain.StudentCourse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class StudentCourseSaveRequestDto {
    private int studentId;
    private int courseId;

    /*
    이미 service에서 이미 형변환해주었기 때문에 여기서 또 할 필요는 없음.
    public StudentCourse toEntity(StudentCourseSaveRequestDto dto){
        return StudentCourse.builder()
                .id(studentId)
                .build();
                }
                */


}
