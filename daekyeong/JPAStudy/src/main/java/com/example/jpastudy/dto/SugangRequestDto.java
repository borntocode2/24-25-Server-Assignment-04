package com.example.jpastudy.dto;

import com.example.jpastudy.domain.Lecture;
import com.example.jpastudy.domain.Student;
import com.example.jpastudy.domain.Sugang;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SugangRequestDto {

    private Long id;
    private Long studentId;
    private Long lectureId;
}
