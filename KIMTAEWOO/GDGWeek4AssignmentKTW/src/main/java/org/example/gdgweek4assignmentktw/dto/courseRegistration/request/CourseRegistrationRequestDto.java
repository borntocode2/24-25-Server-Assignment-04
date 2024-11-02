package org.example.gdgweek4assignmentktw.dto.courseRegistration.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.gdgweek4assignmentktw.domain.Course;
import org.example.gdgweek4assignmentktw.domain.CourseRegistration;
import org.example.gdgweek4assignmentktw.domain.Student;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CourseRegistrationRequestDto {
    private Long courseId;
    private Long studentId;
}
