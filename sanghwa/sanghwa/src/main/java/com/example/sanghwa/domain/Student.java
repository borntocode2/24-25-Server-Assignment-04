package com.example.sanghwa.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Student {
    @Id //persistent 임포트할 것
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="student_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LectureRegistration> lectureRegistrations = new ArrayList<>();

    @Builder
    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void update(String name)
    {
        this.name = name;
    }
}
