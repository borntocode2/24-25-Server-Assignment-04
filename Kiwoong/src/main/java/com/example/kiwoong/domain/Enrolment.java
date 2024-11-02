package com.example.kiwoong.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Enrolment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Getter
    @ManyToOne
    @JoinColumn(name = "courses_id")
    private Courses courses;

    private Enrolment(Student student, Courses courses) {
        this.student = student;
        this.courses = courses;
    }
    public static Enrolment of(Student student, Courses courses) {
        return new Enrolment(student, courses);
    }
}