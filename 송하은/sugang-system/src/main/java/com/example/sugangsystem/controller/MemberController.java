package com.example.sugangsystem.controller;

import com.example.sugangsystem.dto.request.auth.LoginRequestDto;
import com.example.sugangsystem.dto.response.auth.MemberLoginResponseDto;
import com.example.sugangsystem.dto.response.auth.UserInfo;
import com.example.sugangsystem.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    /**
     * 통합된 회원가입 및 사용자 정보 저장 API
     * @param userInfo 사용자 정보 DTO
     * @return 성공 시 회원 로그인 응답 DTO와 200 OK 반환
     */
    @PostMapping("/join")
    public ResponseEntity<MemberLoginResponseDto> registerOrUpdateUserInfo(@RequestBody UserInfo userInfo){
        MemberLoginResponseDto response = memberService.saveUserInfo(userInfo);
        // return new ResponseEntity<>(response,HttpStatus.OK); 와 같은 방식이다.
        // 하지만 아래 방식으로 하는 것이 가독성과 유연성을 높인다. (필요한 경우 옵션도 여러개 추가 가능)
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * 로그인 API
     * @param loginRequestDto 로그인 요청 DTO
     * @return 성공 시 회원 로그인 응답 DTO와 200 OK 반환
     */
    @PostMapping("/login")
    public ResponseEntity<MemberLoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request) {
        MemberLoginResponseDto response = memberService.login(loginRequestDto);

        // 세션을 가져오거나 없으면 생성한다.
        HttpSession session = request.getSession(true);

        // Authentication 객체를 생성하여, 사용자가 인증된 상태임을 나타내는 정보를 담는다.
        Authentication authentication = new UsernamePasswordAuthenticationToken(loginRequestDto.loginId(),null,null);

        // SecurityContext 를 생성하고, 여기에 Authentication 객체를 설정한다.
        // 이로써 사용자가 인증되었다는 정보를 Spring Security 가 알 수 있게 된다.
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);

        // 세션에 SecurityContext 저장
        // 이 설정으로 인해 이후 요청에서도 세션을 통해 인증 상태가 유지된다.
        SecurityContextHolder.setContext(context);
        // "SPRING_SECURITY_CONTEXT"는 Spring Security에서 인증 정보를 세션에 저장할 때 사용하는 기본 키
        session.setAttribute("SPRING_SECURITY_CONTEXT", context); // 현재 세션에 SecurityContext를 저장하여 사용자가 인증된 상태를 유지할 수 있도록 하는 코드

        return ResponseEntity.ok(response);
    }

}
