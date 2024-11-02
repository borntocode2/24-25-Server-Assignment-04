package org.example.gdgweek4assignmentktw.dto.student.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.gdgweek4assignmentktw.domain.CourseRegistration;
import org.example.gdgweek4assignmentktw.domain.Student;

import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
public class StudentSaveRequestDto {
    private Long studentNumber;
    private String studentFaculty;
    private String studentName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date studentBirthday;
    private String studentPhonenumber;
    private List<CourseRegistration> registrations;

    public Student toEntity() {
        return Student.builder()
                .studentNumber(this.studentNumber)
                .studentFaculty(this.studentFaculty)
                .studentName(this.studentName)
                .studentBirthday(this.studentBirthday)
                .studentPhonenumber(this.studentPhonenumber)
                .build();
    }

}
