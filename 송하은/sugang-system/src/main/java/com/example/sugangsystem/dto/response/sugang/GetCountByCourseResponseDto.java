package com.example.sugangsystem.dto.response.sugang;

import lombok.Builder;
import lombok.Getter;
import java.util.Map;

@Getter
@Builder
public class GetCountByCourseResponseDto {

    private Long courseId;
    private String courseTitle;
    private String professor;
    private Long count;

    // entity -> dto
    public static GetCountByCourseResponseDto from(Map<String,Object> data) {
        return GetCountByCourseResponseDto.builder()
                .courseId((Long)data.get("강의번호"))
                .courseTitle((String) data.get("강의명"))
                .professor((String)data.get("교수"))
                .count((Long)data.get("신청인원"))
                .build();
    }

}
