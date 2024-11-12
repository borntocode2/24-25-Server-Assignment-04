package com.example.seun.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class LectureRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id", nullable = false)
    private Lecture lecture;

    public static LectureRegistration of(Student student, Lecture lecture) {
        LectureRegistration registration = new LectureRegistration();
        registration.student = student;
        registration.lecture = lecture;
        return registration;
    }

    public LectureRegistration(Student student, Lecture lecture) {
        this.student = student;
        this.lecture = lecture;
    }
}
