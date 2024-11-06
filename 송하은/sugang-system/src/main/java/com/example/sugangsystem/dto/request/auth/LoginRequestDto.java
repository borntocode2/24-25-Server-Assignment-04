package com.example.sugangsystem.dto.request.auth;

public record LoginRequestDto(
        String loginId,
        String pwd
) {
}