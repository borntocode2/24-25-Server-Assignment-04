package com.example.kiwoong.domain;

import com.example.kiwoong.dto.student.request.StudentRequestDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "TABLE_STUDENT")
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "student_number")//학번
    private Long studentNumber;

    @Column(name = "student_name")
    private String name;

    @Column(name = "student_age")
    private Long age;

    @Column(name = "student_major")
    private String major;

    //fetch는 불러오는 방식 설정
    //cascade all은 persist(부모와 자식을 한번에 영속화)와 remove(persist로 저장해놓은 엔티티 제거)를 모두 해줌
    //orphanRemoval = true 는 고아 객체를 자동으로 지워줌
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Enrolment> enrolments = new ArrayList<>();

    public void update(StudentRequestDto dto) {
        if (dto.getId() != null) {
            this.id = dto.getId();
        }
        if (dto.getStudentNumber() != null) {
            this.studentNumber = dto.getStudentNumber();
        }
        if (dto.getName() != null) {
            this.name = dto.getName();
        }
        if (dto.getAge() > 0) {
            this.age = dto.getAge();
        }
        if (dto.getMajor() != null) {
            this.major = dto.getMajor();
        }
    }

    @Builder
    public Student(Long id, Long studentNumber, String name, Long age, String major){
        this.id = id;
        this.studentNumber = studentNumber;
        this.name = name;
        this.age = age;
        this.major = major;
    }
}