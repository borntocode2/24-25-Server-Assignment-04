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
public class RegistrationResponseDto {
    //컨트롤러에 전송할 DTO이기 때문에 강의,학생 객체가 아닌 강의 이름, 학생 이름만 전달
    private Long id;
    private String lectureTitle;
    private String studentName;

    public static RegistrationResponseDto from(LectureRegistration lectureRegistration) {
        return RegistrationResponseDto.builder()
                .id(lectureRegistration.getId())
                .lectureTitle(lectureRegistration.getLectureTitle())
                .studentName(lectureRegistration.getStudentName())
                .build();
    }



}
