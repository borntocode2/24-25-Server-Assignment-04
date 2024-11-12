package com.example.kiwoong.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "TABLE_TEACHER")
public class Teacher {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long id;

    @Column(name = "teacher_name")
    private String name;

    @Column(name = "teacher_age")
    private Long age;

    @Column(name = "teacher_major")
    private String major;


    @Builder
    public Teacher(Long id, String name, Long age, String major, List<Courses> courses){
        this.id = id;
        this.name = name;
        this.age = age;
        this.major = major;
    }
}