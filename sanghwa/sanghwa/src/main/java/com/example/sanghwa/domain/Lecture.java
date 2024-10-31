package com.example.sanghwa.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Entity
@NoArgsConstructor
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    //@Column이 왜 필요한가?
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) //의존관계에 있는 엔티티도 삭제
    @JoinColumn(name = "student_id")
    private List<LectureRegistration> lectureRegistrations = new ArrayList<>();// Lecture와 Student객체 둘다 가지고 있다.

    @Builder
    public Lecture(Long id, String title, List<LectureRegistration> lectureRegistrations) {
        this.id = id;
        this.title = title;
        this.lectureRegistrations = lectureRegistrations;
    }

    public void update(String title) {
        this.title = title;
    }

}
