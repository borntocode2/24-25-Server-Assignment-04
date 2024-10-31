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

    private Long grade;

    private String content;

    @ManyToOne
    @JoinColumn(name = "studentNumber")
    private Student student;

    @OneToMany(mappedBy = "lecture", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseRegistration> courseRegistrations = new ArrayList<>();

    @Builder
    public Lecture(Long id, String title, Long grade, String content, Student student) {
        this.id = id;
        this.title = title;
        this.grade = grade;
        this.content = content;
        this.student = student;
    }

    public void update(String title, Long grade, String content) {
        this.title = title;
        this.grade = grade;
        this.content = content;
    }
}
