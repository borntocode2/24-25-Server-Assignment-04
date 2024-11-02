package org.example.gdgweek4assignmentktw.dto.course.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.gdgweek4assignmentktw.domain.Course;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseSaveRequestDto {
    private Long courseNumber;
    private String courseName;
    private String courseRoom;
    private String courseTime;
    private String courseProfessor;

    public Course toEntity() {
        return Course.builder()
                .courseNumber(this.courseNumber)
                .courseName(this.courseName)
                .courseRoom(this.courseRoom)
                .courseTime(this.courseTime)
                .courseProfessor(this.courseProfessor)
                .build();
    }
}
