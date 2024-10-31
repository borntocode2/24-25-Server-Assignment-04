package com.example.sanghwa.dto;

import com.example.sanghwa.domain.LectureRegistration;
import com.example.sanghwa.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponseDto {
    private Long id;
    private String title;
    private List<LectureRegistration> lectureRegistrations;

    public static StudentResponseDto from(Student student) {
        return StudentResponseDto.builder()
                .id(student.getId())
                .title(student.getName())
                .lectureRegistrations(student.getLectureRegistrations())
                .build();
    }
}
