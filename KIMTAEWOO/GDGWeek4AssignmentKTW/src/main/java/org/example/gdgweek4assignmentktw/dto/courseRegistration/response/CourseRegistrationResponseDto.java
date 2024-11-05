package org.example.gdgweek4assignmentktw.dto.courseRegistration.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import org.example.gdgweek4assignmentktw.domain.CourseRegistration;
import java.time.LocalDateTime;

@Builder
@Getter
public class CourseRegistrationResponseDto {
    private Long courseRegistrationId;
    private Long courseId;
    private Long studentId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registrationTime;

    public static CourseRegistrationResponseDto includeAllFieldFrom(CourseRegistration courseRegistration){
        return CourseRegistrationResponseDto.builder()
                .courseRegistrationId(courseRegistration.getCourseRegistrationId())
                .courseId(courseRegistration.getCourse().getCourseId())
                .studentId(courseRegistration.getStudent().getStudentId())
                .registrationTime(courseRegistration.getRegistrationTime())
                .build();
    }

}
