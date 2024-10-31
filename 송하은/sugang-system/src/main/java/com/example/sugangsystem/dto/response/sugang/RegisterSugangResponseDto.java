package com.example.sugangsystem.dto.response.sugang;

import com.example.sugangsystem.domain.Sugang;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class RegisterSugangResponseDto {

    private Long id;

    private Long studentId;
    private Long courseId;
    private Date date;

    // entity -> dto
    public static RegisterSugangResponseDto from(Sugang sugang) {
        return RegisterSugangResponseDto.builder()
                .id(sugang.getId())
                .studentId(sugang.getStudent().getId())
                .courseId(sugang.getCourse().getId())
                .date(sugang.getDate())
                .build();

    }
}
