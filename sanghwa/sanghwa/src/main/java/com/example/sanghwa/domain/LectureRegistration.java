package com.example.sanghwa.domain;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.Id;

public class LectureRegistration {

    @Id
    private Long id;

    @ManyToOne //lecture의 기본키를 가져온다
    @JoinColumn(name = "lecture_id") //기본키를 외래키로 사용
    private Lecture lecture;

    @ManyToOne //student의 기본키를 가져온다
    @JoinColumn(name = "student_id")//기본키를 외래키로 사용
    private Student student;
}
