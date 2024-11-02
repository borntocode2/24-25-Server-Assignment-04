package com.example.seun.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LectureSaveRequestDto {
    private String title;
    private Long credit;
    private String content;
}
