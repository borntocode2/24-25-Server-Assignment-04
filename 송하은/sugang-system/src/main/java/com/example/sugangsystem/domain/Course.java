package com.example.sugangsystem.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String title; // 강의명

    private String professor; // 교수

    /*
    강의 : 수강 = 1 : N
    mappedBy="course" => Sugang 엔터티의 course 필드가 관계를 주도하고 있다.
    해당 강의를 신청한 수강신청 목록이다.
     */
    @OneToMany(mappedBy="course", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sugang> sugangList = new ArrayList<>();

    @Builder
    public Course(Long id, String title, String professor) {
        this.id = id;
        this.title = title;
        this.professor = professor;
    }

    public void update(String title, String professor) {
        this.title = title;
        this.professor = professor;
    }
}
