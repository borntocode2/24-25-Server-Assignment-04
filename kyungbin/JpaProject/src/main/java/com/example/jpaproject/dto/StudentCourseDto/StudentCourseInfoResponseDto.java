package com.example.jpaproject.dto.StudentCourseDto;

import com.example.jpaproject.domain.StudentCourse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class StudentCourseInfoResponseDto {
    private int id; // 수강정보 id
    private int studentId; // 학생 id
    private int courseId; // 과목 id
    private String courseName; //과목명
    private String studentName; //학생 이름

    public static StudentCourseInfoResponseDto from(StudentCourse studentCourse) {
        return StudentCourseInfoResponseDto.builder()
                .id(studentCourse.getId())
                .studentId(studentCourse.getStudent().getId())
                .courseId(studentCourse.getCourse().getId())
                .courseName(studentCourse.getCourse().getSubjectName())
                .studentName(studentCourse.getStudent().getName())
                .build();

    }
}
