package com.example.sugangsystem.domain.auth;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor

public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String loginId;

    private String pwd;

    private String name;

    @Builder
    private Member(Role role, String loginId, String pwd, String name) {
        this.role = role;
        this.loginId = loginId;
        this.pwd = pwd;
        this.name = name;
    }
}
