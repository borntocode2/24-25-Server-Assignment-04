package com.example.kiwoong.dto.Enrolment.response;

import com.example.kiwoong.domain.Courses;
import com.example.kiwoong.domain.Enrolment;
import com.example.kiwoong.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrolmentInfoResponseDto {
    private Long enrolmentId;
    private Long studentId;      // 학생 ID
    private String studentName;  // 학생 이름
    private Long courseId;       // 강의 ID
    private String courseName;
    private List<EnrolmentInfoResponseDto> students;
    private List<EnrolmentInfoResponseDto> courses;


    public static EnrolmentInfoResponseDto from(Enrolment enrolment) {
        return EnrolmentInfoResponseDto.builder()
                .enrolmentId(enrolment.getId())
                .studentId(enrolment.getStudent().getId())
                .studentName(enrolment.getStudent().getName())
                .courseId(enrolment.getCourses().getId())
                .courseName(enrolment.getCourses().getName())
                .build();
    }
}
