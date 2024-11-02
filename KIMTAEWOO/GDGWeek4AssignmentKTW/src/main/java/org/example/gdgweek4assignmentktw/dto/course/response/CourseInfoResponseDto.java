package org.example.gdgweek4assignmentktw.dto.course.response;

import lombok.Builder;
import lombok.Getter;
import org.example.gdgweek4assignmentktw.domain.Course;

@Getter
@Builder
public class CourseInfoResponseDto {
    private Long courseId;
    private Long courseNumber;
    private String courseName;
    private String courseRoom;
    private String courseTime;
    private String courseProfessor;

    //정적 팩토리 메서드의 장점을 살리기 위해 더 직관적으로 메서드 작명
    public static CourseInfoResponseDto includeAllFieldFrom(Course course) {
        return CourseInfoResponseDto.builder()
                .courseId(course.getCourseId())
                .courseNumber(course.getCourseNumber())
                .courseName(course.getCourseName())
                .courseRoom(course.getCourseRoom())
                .courseTime(course.getCourseTime())
                .courseProfessor(course.getCourseProfessor())
                .build();
    }
}
