package com.example.kiwoong.domain;

import com.example.kiwoong.dto.courses.request.CoursesRequestDto;
import com.example.kiwoong.dto.student.request.StudentRequestDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "TABLE_COURSES")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courses_id")
    private Long id;

    @Column(name = "courses_name")
    private String name;

    @Column(name = "courses_day")
    private String day;

    @Column(name = "courses_room")
    private String room;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public void update(CoursesRequestDto dto) {
        if (dto.getId() != null) {
            this.id = dto.getId();
        }
        if (dto.getName() != null) {
            this.name = dto.getName();
        }
        if (dto.getDay() != null) {
            this.day = dto.getDay();
        }
        if (dto.getRoom() != null) {
            this.room = dto.getRoom();
        }
    }

    @Builder
    public Courses(Long id, String name, String day, String room, Student student){
        this.id = id;
        this.name = name;
        this.day = day;
        this.room = room;
        this.student = student;
    }
}
