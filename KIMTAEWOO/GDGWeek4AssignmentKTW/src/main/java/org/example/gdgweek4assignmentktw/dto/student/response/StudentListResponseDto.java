package org.example.gdgweek4assignmentktw.dto.student.response;

import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Builder
@Getter
public class StudentListResponseDto {
    List<StudentInfoResponseDto> studentInfoResponseDTOs;

    public static StudentListResponseDto changeListToDto(List<StudentInfoResponseDto> dtoList) {
        return StudentListResponseDto.builder()
                .studentInfoResponseDTOs(dtoList)
                .build();
    }

}
