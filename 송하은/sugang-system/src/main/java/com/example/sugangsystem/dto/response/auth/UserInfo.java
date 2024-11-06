package com.example.sugangsystem.dto.response.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;

// 모든 필드를 final 로 선언해서 불변 객체롤 만든다. => record 사용
public record UserInfo(
        String loginId,
        String pwd,
        String name
) {
}