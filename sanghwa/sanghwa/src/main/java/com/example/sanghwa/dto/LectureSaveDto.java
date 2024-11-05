package com.example.sanghwa.dto;

import com.example.sanghwa.domain.Lecture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LectureSaveDto {
    private String title;

    public Lecture toEntity(){
        return Lecture.builder()
                .title(title)
                .build();
    }
}
