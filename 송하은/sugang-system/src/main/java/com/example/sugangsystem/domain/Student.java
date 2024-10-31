package com.example.sugangsystem.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.nio.file.FileStore;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String major;

    /*
    학생 : 수강 = 1 : N
    mappedBy="student" => Sugang 엔터티의 student 필드가 관계를 주도하고 있다.
    학생이 신청한 수강목록이다.
     */
    @OneToMany(mappedBy="student", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sugang> sugangList = new ArrayList<>();

    @Builder
    public Student(Long id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
    }

    public void update(String name, String major) {
        this.name = name;
        this.major = major;
    }
}
