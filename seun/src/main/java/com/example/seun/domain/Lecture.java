package com.example.seun.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Long credit;

    private String content;

    @OneToMany(mappedBy = "lecture", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LectureRegistration> lectureRegistrations = new ArrayList<>();

    @Builder
    public Lecture(String title, Long credit, String content) {
        this.title = title;
        this.credit = credit;
        this.content = content;
    }

    public void update(String title, Long credit, String content) {
        this.title = title;
        this.credit = credit;
        this.content = content;
    }
}
