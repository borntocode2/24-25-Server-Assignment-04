package com.example.jpastudy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LectureSaveRequestDto {
    private String name;
    private String professor;
    private String major;
}
