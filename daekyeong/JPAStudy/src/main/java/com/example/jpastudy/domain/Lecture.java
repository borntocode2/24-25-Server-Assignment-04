package com.example.jpastudy.domain;

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

    private String name;
    private String professor; //교수명
    private String major; //전공

    @OneToMany(mappedBy = "lecture", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sugang> sugangList = new ArrayList<>();

    @Builder
    public Lecture(Long id, String name, String professor, String major, List<Sugang> sugangList) {
        this.id = id;
        this.name = name;
        this.professor = professor;
        this.major = major;
        this.sugangList = sugangList;
    }

    public void update(String name, String professor, String major) {
        this.name = name;
        this.professor = professor;
        this.major = major;
    }
}
