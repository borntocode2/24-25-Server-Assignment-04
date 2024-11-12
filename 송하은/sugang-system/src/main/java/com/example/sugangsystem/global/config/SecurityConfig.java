package com.example.sugangsystem.global.config;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration // 스프링의 설정 클래스임을 나타낸다.
@EnableWebSecurity // 스프링 시큐리티 활성화, 보안 필터가 모든 HTTP 요청을 보호하도록 설정
public class SecurityConfig {

    /*
    SecurityFilterChain 을 빈으로 등록하고,
    스프링 시큐리티의 보안 규칙을 정의한다.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic(AbstractHttpConfigurer::disable) // HTTP Basic 인증 비활성화. 대신 다른 인증방식(여기서는 세션 인증방식)을 사용할 수 있다.
                .csrf(AbstractHttpConfigurer::disable) // CSRF 보호 비활성화
                .sessionManagement(sessionManagement -> // 세션을 필요할 때만 생성하도록 설정
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                )
                .formLogin(AbstractHttpConfigurer::disable) // 기본 폼 로그인 비활성화
                .logout(logout -> logout // 로그아웃 관련 설정
                        .logoutUrl("/api/members/logout")
                        .logoutSuccessHandler(logoutSuccessHandler())
                        .invalidateHttpSession(true) // 로그아웃 시 현재 세션 무효화
                        .deleteCookies("JSESSIONID") // 쿠키 삭제
                        .permitAll() // 모든 사용자가 로그아웃 기능 사용할 수 있도록 설정
                )
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/members/join","/api/members/login").permitAll() // 회원가입, 로그인 요청 모든 사용자에게 허용
                                .anyRequest().authenticated() // 그외 모든 요청은 인증 필요
                );
        return http.build();
    }

    // 로그아웃 성공시 실행되는 동작
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return (request,response,authentication) -> {
            response.setStatus(HttpServletResponse.SC_OK); // 로그아웃 성공시 HTTP 상태코드 200 OK 로 설정
            response.setContentType("text/plain; charset=UTF-8");
            response.getWriter().write("로그아웃 완료"); // 응답 본문에 "로그아웃 완료" 메시지 작성
            response.getWriter().flush(); // 응답을 즉시 클라이언트로 전송한다.
        };
    }
}
