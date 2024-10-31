package com.example.sanghwa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity //DB에 같은 이름의 테이블하고 매핑된다.
public class LectureRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne //lecture의 기본키를 가져온다
    @JoinColumn(name = "lecture_id") //기본키를 외래키로 사용
    private Lecture lecture;

    @ManyToOne //student의 기본키를 가져온다
    @JoinColumn(name = "student_id")//기본키를 외래키로 사용
    private Student student;

    public void update(Lecture lecture){
        this.lecture = lecture;
    }
}

