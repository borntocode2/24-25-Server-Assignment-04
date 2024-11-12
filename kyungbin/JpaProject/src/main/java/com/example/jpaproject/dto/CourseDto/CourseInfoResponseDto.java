package com.example.jpaproject.dto.CourseDto;

import com.example.jpaproject.domain.Course;
import com.example.jpaproject.domain.StudentCourse;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
// 클라이언트에 응답할 수강과목에 대한 정보
public class CourseInfoResponseDto {
    private int id;
    private String subjectName;
    private int roomNum;
    private List<StudentCourse> studentCourseList;

    public static CourseInfoResponseDto from(Course course){
        return CourseInfoResponseDto.builder()
                .id(course.getId())
                .subjectName(course.getSubjectName())
                .roomNum(course.getRoomNum())
                .build();
    }
}
