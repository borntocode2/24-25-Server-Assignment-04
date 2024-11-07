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

    @ManyToOne
    @JoinColumn(name = "courses_id")
    private Courses courses;

    public static Enrolment createEnrolment(Student student, Courses courses) {
        Enrolment enrolment = new Enrolment();
        enrolment.student = student;
        enrolment.courses = courses;
        return enrolment;
    }
}