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
public class Student {
    @Id
    @Column(name = "student_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sugang> sugangList = new ArrayList<>();

    @Builder
    public Student(Long id, Long studentNum, String name, List<Sugang> sugangList) {
        this.id = id;
        this.name = name;
    }

    public void update(Long studentId, String name) {
        this.id = studentId;
        this.name = name;
    }
}
