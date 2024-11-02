package org.example.gdgweek4assignmentktw.dto.courseRegistration.response;


import lombok.Builder;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;
@Builder
@Getter
public class CourseRegistrationListResponseDto {
    List<CourseRegistrationResponseDto> registrationDTOS;

    public static CourseRegistrationListResponseDto changeListToDto(List<CourseRegistrationResponseDto> dtoList){
        return CourseRegistrationListResponseDto.builder()
                .registrationDTOS(dtoList)
                .build();
    }

    public static CourseRegistrationListResponseDto returnEmptyList() {
        return CourseRegistrationListResponseDto.builder()
                .registrationDTOS(Collections.emptyList())
                .build();
    }

}
