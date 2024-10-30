package com.example.sanghwa.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    //@Column이 왜 필요한가?
    @OneToMany
    @JoinColumn(name = "student_id")
    private List<LectureRegistration> lectureRegistrations = new ArrayList<>();// Lecture와 Student객체 둘다 가지고 있다.

    @Builder
    public Lecture(Long id, String title, List<LectureRegistration> lectureRegistrations) {
        this.id = id;
        this.title = title;
        this.lectureRegistrations = lectureRegistrations;
    }

}
