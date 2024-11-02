package com.example.jpastudy.dto;

import com.example.jpastudy.domain.Sugang;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SugangInfoResponseDto {
    private int id;
    private Long studentId;
    private String studentName;
    private Long lectureId;
    private String lectureName;
    private String professorName;
    private String majorName;

    public static SugangInfoResponseDto from(Sugang sugang) {
        return SugangInfoResponseDto.builder()
                .studentId(sugang.getStudent().getId())
                .studentName(sugang.getStudent().getName())
                .lectureId(sugang.getLecture().getId())
                .lectureName(sugang.getLecture().getName())
                .professorName(sugang.getLecture().getProfessor())
                .majorName(sugang.getLecture().getMajor())
                .build();
    }
}
