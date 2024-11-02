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
    private Long studentId;
    private Long coursesId;
    private String studentName;
    private String courseName;
    private List<EnrolmentInfoResponseDto> students;
    private List<EnrolmentInfoResponseDto> courses;

    public EnrolmentInfoResponseDto(String studentName, Long studentId, String courseName, Long coursesId) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.courseName = courseName;
        this.coursesId = coursesId;

    }

    public EnrolmentInfoResponseDto(List<EnrolmentInfoResponseDto> students, List<EnrolmentInfoResponseDto> courses) {
        this.students = students;
        this.courses = courses;
    }


    public static EnrolmentInfoResponseDto from(Student student) {
        return new EnrolmentInfoResponseDto(student.getName(), student.getId(), null, null);
    }
    public static EnrolmentInfoResponseDto from(Student student, Courses courses) {
        return new EnrolmentInfoResponseDto(student.getName(), student.getId(), courses.getName(), courses.getId());
    }
    public static EnrolmentInfoResponseDto from(Enrolment enrolment) {
        return EnrolmentInfoResponseDto.builder()
                .enrolmentId(enrolment.getId())
                .studentId(enrolment.getStudent().getId())
                .coursesId(enrolment.getCourses().getId())
                .studentName(enrolment.getStudent().getName())
                .courseName(enrolment.getCourses().getName())
                .build();
    }
}
