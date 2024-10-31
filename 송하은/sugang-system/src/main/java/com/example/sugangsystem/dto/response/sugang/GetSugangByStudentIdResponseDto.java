package com.example.sugangsystem.dto.response.sugang;

import com.example.sugangsystem.domain.Sugang;
import com.example.sugangsystem.dto.response.course.CourseInfoResponseDto;
import com.example.sugangsystem.dto.response.course.CourseListResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@Builder
public class GetSugangListByStudentIdResponseDto {

    private Long sugangId;
    private Long courseId;
    private String courseTitle;
    private Date date;


}
