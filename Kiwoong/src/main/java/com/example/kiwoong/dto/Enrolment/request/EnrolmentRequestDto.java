package com.example.kiwoong.dto.Enrolment.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class EnrolmentRequestDto {

    private Long studentId;

    private Long courseId;

}