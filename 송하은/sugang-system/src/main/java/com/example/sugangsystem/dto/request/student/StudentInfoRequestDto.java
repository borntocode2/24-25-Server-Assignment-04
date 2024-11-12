package com.example.sugangsystem.dto.request.student;

import lombok.Getter;
import lombok.NoArgsConstructor;

// 학생 정보 요청 dto
@Getter
@NoArgsConstructor
public class StudentInfoRequestDto {

    private Long id;
    private String name;
    private String major;

}
