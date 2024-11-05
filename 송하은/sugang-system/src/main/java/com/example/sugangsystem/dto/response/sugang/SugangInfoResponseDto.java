package com.example.sugangsystem.dto.response.sugang;

import com.example.sugangsystem.domain.Sugang;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class SugangInfoResponseDto {

    private Long sugangId;
    private Long courseId;
    private String courseTitle;
    private Date date;

    // entity -> dto
    public static SugangInfoResponseDto from(Sugang sugang) {
        return SugangInfoResponseDto.builder()
                .sugangId(sugang.getId())
                .courseId(sugang.getCourse().getId())
                .courseTitle(sugang.getCourse().getTitle())
                .date(sugang.getDate())
                .build();
    }

}
