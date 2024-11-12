package com.example.sugangsystem.dto.response.sugang;

import com.example.sugangsystem.domain.Sugang;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class SugangRegisterResponseDto {

    private Long id;

    private Long studentId;
    private Long courseId;
    private Date date;

    // entity -> dto
    public static SugangRegisterResponseDto from(Sugang sugang) {
        return SugangRegisterResponseDto.builder()
                .id(sugang.getId())
                .studentId(sugang.getStudent().getId())
                .courseId(sugang.getCourse().getId())
                .date(sugang.getDate())
                .build();

    }
}
