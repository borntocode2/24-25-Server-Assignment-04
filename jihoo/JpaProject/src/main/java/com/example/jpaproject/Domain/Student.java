package com.example.jpaproject.Domain;

import com.example.jpaproject.Dto.Student.request.StudentRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @Column(name ="student_id")
    private Long studentId;

    private String name;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrolment> enrollments = new ArrayList<>();

    public void update(StudentRequestDto dto) {
        this.studentId = dto.getStudentId();
        this.name = dto.getName();
    }


}
