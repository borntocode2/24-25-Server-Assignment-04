package com.example.jpaproject.dto.StudentDto;

import com.example.jpaproject.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor

// 학생 데이터를 만들 때 요청할 정보
public class StudentSaveRequestDto {
    private String name; // 학생 이름
    private int studentId; // 학번
    private String major; // 전공

    // 데이터베이스에접근 할 수 있도록 Dto를 entity로 변환해준다.
    public Student toEntity(){
        return Student.builder()
                .name(name)
                .studentId(studentId)
                .major(major)
                .build();
    }
}
