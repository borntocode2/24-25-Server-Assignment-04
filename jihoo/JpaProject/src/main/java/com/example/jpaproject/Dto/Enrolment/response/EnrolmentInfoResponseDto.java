package com.example.jpaproject.Dto.Enrolment.response;

import com.example.jpaproject.Domain.Enrolment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrolmentInfoResponseDto {

    private Long enrolmentId;
    private Long studentId;
    private Long courseId;
    private String studentName;
    private String courseTitle;
    private LocalDate requestDate;

    public static EnrolmentInfoResponseDto from(Enrolment enrolment) {
        return EnrolmentInfoResponseDto.builder()
                .enrolmentId(enrolment.getId())
                .studentId(enrolment.getStudent().getStudentId())
                .courseId(enrolment.getCourse().getCourseId())
                .studentName(enrolment.getStudent().getName())
                .courseTitle(enrolment.getCourse().getTitle())
                .requestDate(enrolment.getRequestDate())
                .build();
    }
}
