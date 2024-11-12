package com.example.jpaproject.dto.CourseDto;

import com.example.jpaproject.domain.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
// 과목 데이터를 만들 때 필요한 요청 정보
public class CourseSaveRequestDto {
    private String subjectName;
    private int roomNum;

    public Course toEntity(CourseSaveRequestDto dto){
        return Course.builder()
                .subjectName(dto.getSubjectName())
                .roomNum(dto.getRoomNum())
                .build();
    }
}
