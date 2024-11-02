package org.example.gdgweek4assignmentktw.dto.courseRegistration.response;

import lombok.Builder;
import lombok.Getter;
import org.example.gdgweek4assignmentktw.domain.Course;
import org.example.gdgweek4assignmentktw.domain.CourseRegistration;
import org.example.gdgweek4assignmentktw.domain.Student;

import java.time.LocalDateTime;

@Getter
@Builder
public class CourseRegistrationResponseDto {
    private Long courseRegistrationId;
    private Course course;
    private Student student;
    private LocalDateTime registrationTime;

    public static CourseRegistrationResponseDto includeAllFieldFrom(CourseRegistration courseRegistration){
        return CourseRegistrationResponseDto.builder()
                .courseRegistrationId(courseRegistration.getCourseRegistrationId())
                .course(courseRegistration.getCourse())
                .student(courseRegistration.getStudent())
                .registrationTime(courseRegistration.getRegistrationTime())
                .build();
    }
}
