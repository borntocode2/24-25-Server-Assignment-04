package com.example.jpaproject.dto.StudentDto;

import com.example.jpaproject.domain.Student;
import com.example.jpaproject.domain.StudentCourse;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder

// 클라이언트에게 응답할 학생정보
public class StudentInfoResponseDto {
    private int id;
    private String name; // 학생 이름

    private int studentId; // 학번
    private String major; // 전공
    private List<StudentCourse> studentCourses;

    // entity에서 정보를 가져와서 클라이언트에 응답하기 위해 Dto로 변환해준다.
    public static StudentInfoResponseDto from(Student student) {
        return StudentInfoResponseDto.builder()
                .id(student.getId())
                .name(student.getName())
                .studentId(student.getStudentId())
                .major(student.getMajor())
                .build();

    }
}
