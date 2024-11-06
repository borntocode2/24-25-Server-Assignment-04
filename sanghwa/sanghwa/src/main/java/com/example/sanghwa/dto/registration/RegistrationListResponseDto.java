package com.example.sanghwa.dto.registration;

import com.example.sanghwa.domain.LectureRegistration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationListResponseDto {
    private String title;
    private String name;

    public static RegistrationListResponseDto from(LectureRegistration lectureRegistration){
        return RegistrationListResponseDto.builder()
                .title(lectureRegistration.getLectureTitle())
                .name(lectureRegistration.getStudentName())
                .build();

    }

}
