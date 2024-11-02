package com.example.kiwoong.dto.Enrolment.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class EnrolmentListResponseDto {

    List<EnrolmentInfoResponseDto> enrolmentInfoResponseDtos;

    public static EnrolmentListResponseDto from(List<EnrolmentInfoResponseDto> enrolmentInfoResponseDtos) {
        return EnrolmentListResponseDto.builder()
                .enrolmentInfoResponseDtos(enrolmentInfoResponseDtos)
                .build();
    }
}