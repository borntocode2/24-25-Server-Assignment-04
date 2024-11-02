package org.example.gdgweek4assignmentktw.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.gdgweek4assignmentktw.dto.student.request.StudentSaveRequestDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Entity
/*
@NoArgsConstructor 가 생성해 주는 기본 생성자가 필요한 이유
    1. Reflection 을 통해 DB의 데이터를 entity 객체에 할당 시 기본 생성자가 필요하다
    2. Lazy Loading시 기본 생성자로 프록시 객체를 생성하기 위해
    (프록시 객체는 일단 빈 객체로 생성되었다가 바꿔치기되는 것이 아니라, 비어있는 프록시 객체에 계속 정보가 주입된다)
 */
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId; // 1, 2, 3, 4...

    @Column(name = "student_number")
    private Long studentNumber; // 201814075

    // 학부
    @Column(name = "student_faculty")
    private String studentFaculty;

    @Column(name = "student_name")
    private String studentName; // 김태우

    @Column(name = "student_birthday")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date studentBirthday; // 1999-12-12

    @Column(name = "student_phonenumber")
    private String studentPhonenumber; // 010-9387-4115

    /*
    mappedBy : 연관관계의 주인 설정, 주인이 아닌 쪽에서 mappedBy로 명시
    fetch : DB필드에서 값을 가져오는 전략 설정
        LAZY : 연관 데이터 실제 접근시까지 로딩 지연
        EAGER : 엔티티 로드시 연관된 엔티티 즉시 함께 로딩
    cascade : 부모 엔티티 상태 변화시 자식 엔티티 어떻게 할지 설정
    orphanRemoval : 고아 엔티티 삭제 여부
     */
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY
            , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseRegistration> registrations = new ArrayList<>();

    public void update(StudentSaveRequestDto dto) {
        this.studentNumber = dto.getStudentNumber();
        this.studentFaculty = dto.getStudentFaculty();
        this.studentName = dto.getStudentName();
        this.studentBirthday = dto.getStudentBirthday();
        this.studentPhonenumber = dto.getStudentPhonenumber();
    }
}
