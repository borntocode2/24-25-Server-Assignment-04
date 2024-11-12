package com.example.sugangsystem.dto.request.sugang;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class SugangRegisterRequestDto {

    private Long studentId;
    private Long courseId;
    private Date date;

}
