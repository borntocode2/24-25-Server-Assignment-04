package com.example.sugangsystem.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

// 중간 테이블
@Entity
@Getter
@NoArgsConstructor
public class Sugang {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Date date; // 수강신청한 날짜

    /*
    학생 : 수강 = 1 : N
    강의 : 수강 = 1 : N
    N 쪽에 연관관계의 주인이 존재한다.
    각각 student, course 가 관계를 주도한다.
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id") // student 테이블의 기본키를 참조하여 student_id 라는 컬럼을 생성한다.
    private Student student;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="course_id")
    private Course course; // course 테이블의 기본키를 참조하여 course_id 라는 컬럼을 생성한다.

    @Builder
    public Sugang(Long id, Date date, Student student, Course course) {
        this.id = id;
        this.date = date;
        this.student = student;
        this.course = course;
    }

    public static Sugang createSugang(Student student, Course course) {
        Sugang sugang = new Sugang();
        sugang.student = student;
        sugang.course = course;
        sugang.date = new Date(); // 현재 날짜로 지정
        return sugang;
    }
}
