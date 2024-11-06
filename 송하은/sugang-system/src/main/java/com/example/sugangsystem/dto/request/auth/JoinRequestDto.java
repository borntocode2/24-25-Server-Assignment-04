package com.example.sugangsystem.dto.request.auth;

public record JoinRequestDto(
        String loginId,
        String pwd,
        String name
){
}