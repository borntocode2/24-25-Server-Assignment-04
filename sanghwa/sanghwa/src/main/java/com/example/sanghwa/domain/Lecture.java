package com.example.sanghwa.domain;

import jakarta.persistence.*;
import lombok.Builder;

public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    //@Column이 왜 필요한가?
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @Builder
    public Lecture(Long id, String title, Student student) {
        this.id = id;
        this.title = title;
        this.student = student;
    }

}
