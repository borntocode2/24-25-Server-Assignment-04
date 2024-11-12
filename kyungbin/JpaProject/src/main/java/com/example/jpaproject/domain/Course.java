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
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "subject_name")
    private String subjectName; // 과목명
    @Column(name = "room_no")
    private int roomNum; // 강의실 번호

    // 하나의 과목이 여러개의 수강 정보를 가질 수 있다.
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentCourse> studentCourseList = new ArrayList<>();

    @Builder
    public Course(int id, String subjectName, int roomNum, List<StudentCourse> studentCourseList) {
        this.id = id;
        this.subjectName = subjectName;
        this.roomNum = roomNum;
        this.studentCourseList = studentCourseList;
    }
    //update 메소드 추가
    public void update(String subjectName, int roomNum) {
        this.subjectName = subjectName;
        this.roomNum = roomNum;
    }
}
