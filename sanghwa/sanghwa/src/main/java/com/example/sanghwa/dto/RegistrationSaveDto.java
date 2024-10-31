package com.example.sanghwa.dto;

import com.example.sanghwa.domain.Lecture;

public class RegistrationSaveDto {
    private Long id;


    public Lecture toEntity(){
        return Lecture.builder()
                .id(id)
                .build();
    }
}
