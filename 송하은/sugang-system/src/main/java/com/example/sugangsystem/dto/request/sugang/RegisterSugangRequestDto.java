package com.example.sugangsystem.dto.request.sugang;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class RegisterSugangRequestDto {

    private Long studentId;
    private Long courseId;
    private Date date;

}
