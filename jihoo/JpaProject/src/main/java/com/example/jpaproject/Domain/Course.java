package com.example.jpaproject.Domain;

import com.example.jpaproject.Dto.Course.request.CourseRequestDto;
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
public class Course {

    @Id
    @Column(name = "Course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String title;

    private String professor;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Enrolment> enrollments = new ArrayList<>();

    public void update(CourseRequestDto dto) {
        this.title = dto.getTitle();
        this.professor = dto.getProfessor();
    }
}
