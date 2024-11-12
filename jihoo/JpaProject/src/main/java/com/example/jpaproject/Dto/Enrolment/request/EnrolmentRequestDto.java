package com.example.jpaproject.Dto.Enrolment.request;

import com.example.jpaproject.Dto.Enrolment.request.EnrolmentRequestDto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EnrolmentRequestDto {

    private Long studentId;

    private Long courseId;

}
