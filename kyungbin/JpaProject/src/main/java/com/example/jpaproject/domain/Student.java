package com.example.jpaproject.domain;

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
    private int id;

    private String name; // 학생 이름
    @Column(name = "student_id")
    private int studentId; // 학번
    private String major; // 전공

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentCourse> studentCourses = new ArrayList<>(); // 한 학생이 여러 수강 정보를 가질 수 있다.

    @Builder
    public Student(int id, String name, int studentId, String major, List<StudentCourse> studentCourses) {
        this.id = id;
        this.name = name;
        this.studentId = studentId;
        this.major = major;
    }
    //update 메소드 추가
    public void update(String name, String major) {
        this.name = name;
        this.major = major;
    }


}
