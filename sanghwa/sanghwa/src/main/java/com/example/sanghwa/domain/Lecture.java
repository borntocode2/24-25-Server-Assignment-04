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
    @Column(name = "lecture_id")
    private Long id;

    private String title;

    //@Column이 왜 필요한가?
    @OneToMany(mappedBy= "lecture", cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true) //의존관계에 있는 엔티티도 삭제
    private List<LectureRegistration> lectureRegistrations = new ArrayList<>();// Lecture와 Student객체 둘다 가지고 있다.

    @Builder
    public Lecture(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public void update(String title) {
        this.title = title;
    }
}
