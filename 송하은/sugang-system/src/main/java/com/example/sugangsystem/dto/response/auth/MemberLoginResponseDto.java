package com.example.sugangsystem.dto.response.auth;

import com.example.sugangsystem.domain.auth.Member;
import lombok.Builder;

@Builder
public record MemberLoginResponseDto(
        Member findMember
) {
    public static MemberLoginResponseDto from(Member member) {
        return MemberLoginResponseDto.builder()
                .findMember(member)
                .build();
    }
}