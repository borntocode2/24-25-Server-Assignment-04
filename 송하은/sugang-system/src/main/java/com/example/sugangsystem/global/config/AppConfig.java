package com.example.sugangsystem.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/*
AppConfig 라는 설정 클래스에 PasswordEncoder() 빈을 등록한다.
 */
@Configuration // 이 클래스가 스프링 설정 클래스임을 나타낸다. 스프링 부트가 애플리케이션을 시작할 때 이 클래스를 읽어, 정의된 빈들을 스프링 컨테이너에 등록한다.
public class AppConfig {

    @Bean // 메서드의 반환값을 스프링 빈으로 등록하겠다. 싱글톤으로 관리되어 필요한 곳에서 자동으로 주입하여 사용할 수 있다.
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
