package com.example.sugangsystem.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

// 학생 정보 요청 dto
@Getter
@NoArgsConstructor
public class StudentInfoRequestDto {

    private Long id;
    private String name;
    private String major;

}
