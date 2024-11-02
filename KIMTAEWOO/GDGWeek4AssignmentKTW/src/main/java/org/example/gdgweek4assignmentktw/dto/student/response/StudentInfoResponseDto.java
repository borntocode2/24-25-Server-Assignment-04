package org.example.gdgweek4assignmentktw.dto.student.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import org.example.gdgweek4assignmentktw.domain.Student;

import java.util.Date;

@Getter
@Builder
public class StudentInfoResponseDto {
    private Long studentId;
    private Long studentNumber;
    private String studentFaculty;
    private String studentName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date studentBirthday;
    private String studentPhonenumber;

    //정적 팩토리 메서드의 장점을 살리기 위해 더 직관적으로 메서드 작명
    public static StudentInfoResponseDto includeAllFieldFrom(Student student) {
        return StudentInfoResponseDto.builder()
                .studentId(student.getStudentId())
                .studentNumber(student.getStudentNumber())
                .studentFaculty(student.getStudentFaculty())
                .studentName(student.getStudentName())
                .studentBirthday(student.getStudentBirthday())
                .studentPhonenumber(student.getStudentPhonenumber())
                .build();
    }
}
