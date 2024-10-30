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
    private Long id;
    private String name;

    @OneToMany
    private List<LectureRegistration> LectureRegistrations = new ArrayList<>();

    @Builder
    public Student(Long id, String name, List<LectureRegistration> LectureRegistrations) {
        this.id = id;
        this.name = name;
        this.LectureRegistrations = LectureRegistrations;
    }






}
