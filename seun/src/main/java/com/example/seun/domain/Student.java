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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentNumber;

    private String name;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LectureRegistration> lectureRegistrations = new ArrayList<>();

    @Builder
    public Student(Long studentNumber, String name) {
        this.studentNumber = studentNumber;
        this.name = name;
    }

    public void update(Long studentNumber, String name){
        this.studentNumber = studentNumber;
        this.name = name;
    }

}
