package org.example.gdgweek4assignmentktw.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Getter
/*
JPA 엔티티 클래스에서 기본 생성자가 필요하지만, 외부에서 무분별하게 호출되지 않도록 제한할 때 사용.
Lazy Loading의 프록시 객체 생성을 위해 private 이 아닌 protected 로 설정
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
/*
클래스 레벨에서 Builder을 어노테이션을 붙이면
모든 요소를 받는 package-private 생성자가 자동으로 생셩되며
이 생성자에 @Builder 어노테이션을 붙인 것과 동일하게 동작한다.
 */
@Builder
@AllArgsConstructor // Builder을 위한 AllArgsConstructor
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

    @Column(name = "registration_time")
    // @CreationTimestamp: Hibernate 제공 어노테이션, 엔티티가 처음 생서되어 DB에 저장될 때 필드에 현재 시간 자동 설정
    @CreationTimestamp
    // Timestamp 를 통해 제공되는 시간 형식이 복잡하여 직관적인 형식으로 변경
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registrationTime;

    // 기존의 정적 팩토리 메서드
    public static CourseRegistration createWithCourseAndStudent(Course course, Student student) {
        CourseRegistration courseRegistration = new CourseRegistration();
        courseRegistration.course = course;
        courseRegistration.student = student;
        return courseRegistration;
    }

}
