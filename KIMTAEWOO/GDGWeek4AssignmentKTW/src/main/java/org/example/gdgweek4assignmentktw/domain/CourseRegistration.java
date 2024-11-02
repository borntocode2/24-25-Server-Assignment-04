package org.example.gdgweek4assignmentktw.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.gdgweek4assignmentktw.dto.course.response.CourseInfoResponseDto;
import org.example.gdgweek4assignmentktw.dto.courseRegistration.request.CourseRegistrationRequestDto;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Builder
public class CourseRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_registration_id")
    private Long courseRegistrationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    // Hibernate 제공 어노테이션, 엔티티가 처음 생서되어 DB에 저장될 때 필드에 현재 시간 설정
    @CreationTimestamp
    private LocalDateTime registrationTime;

    @Builder
    public CourseRegistration(Long courseRegistrationId, Course course
            , Student student, LocalDateTime registrationTime){
        this.courseRegistrationId = courseRegistrationId;
        this.course = course;
        this.student = student;
        this.registrationTime = null; //  생성시 무시, 찍어놓은 타임스탬프로 자동 설정
    }

    // 정적 팩토리 메서드
    public static CourseRegistration createWithCourseAndStudent(Course course, Student student) {
        CourseRegistration courseRegistration = new CourseRegistration();
        courseRegistration.course = course;
        courseRegistration.student = student;
        return courseRegistration;
    }

}
