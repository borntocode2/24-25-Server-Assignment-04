package com.example.jpastudy.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class SugangListResponseDto {
    List<SugangInfoResponseDto> sugangInfoResponseDtos;

    public static SugangListResponseDto from(List<SugangInfoResponseDto> sugangInfoResponseDtos) {
        return SugangListResponseDto.builder()
                .sugangInfoResponseDtos(sugangInfoResponseDtos)
                .build();
    }
}
