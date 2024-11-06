package com.example.sugangsystem.service;

import com.example.sugangsystem.domain.auth.Member;
import com.example.sugangsystem.domain.auth.Role;
import com.example.sugangsystem.dto.request.auth.LoginRequestDto;
import com.example.sugangsystem.dto.response.auth.MemberLoginResponseDto;
import com.example.sugangsystem.dto.response.auth.UserInfo;
import com.example.sugangsystem.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public MemberLoginResponseDto saveUserInfo(UserInfo userInfo) {
        validateNotFoundLoginId(userInfo.loginId());

        Member member = memberRepository.findByLoginId(userInfo.loginId())
                .orElseGet(() -> createMember(userInfo));

        return MemberLoginResponseDto.from(member);
    }

    private void validateNotFoundLoginId(String loginId) {
        if (loginId == null || loginId.trim().isEmpty()) {
            throw new IllegalStateException("로그인 ID가 필요합니다.");
        }
    }

    private Member createMember(UserInfo userInfo) {
        return memberRepository.save(
                Member.builder()
                        .loginId(userInfo.loginId())
                        .pwd(passwordEncoder.encode(userInfo.pwd()))
                        .name(userInfo.name())
                        .role(Role.ROLE_USER)
                        .build()
        );
    }

    // 로그인 요청 시 사용자가 입력한 loginId와 비밀번호가 서버에 저장된 정보와 일치하는지 확인하는 역할
    public MemberLoginResponseDto login(LoginRequestDto loginRequestDto) {
        Member member = memberRepository.findByLoginId(loginRequestDto.loginId())
                .orElseThrow(() -> new IllegalArgumentException("회원 정보를 찾을 수 없습니다."));

        // 유저가 입력한 pwd 와 db에 암호화되어 저장된 pwd 를 비교한다.
        validationPassword(loginRequestDto.pwd(), member.getPwd());

        return MemberLoginResponseDto.from(member);
    }

    private void validationPassword(String rawPassword, String encodedPassword) {
        if(!passwordEncoder.matches(rawPassword, encodedPassword)) {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }
    }
}
