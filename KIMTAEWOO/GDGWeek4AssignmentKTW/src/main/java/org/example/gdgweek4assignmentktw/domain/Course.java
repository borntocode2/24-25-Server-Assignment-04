package org.example.gdgweek4assignmentktw.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.gdgweek4assignmentktw.dto.course.request.CourseSaveRequestDto;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1씩 자동으로 올라가도록 설정
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "course_number")
    private Long courseNumber;

    @Column(name = "course_name")
    private String courseName; // 운영체제

    @Column(name = "course_room")
    private String courseRoom; // M404

    @Column(name = "course_time")
    private String courseTime; // 12:00 ~ 13:15 와 같이 String으로 저장

    @Column(name = " course_professor")
    private String courseProfessor;

    /*
    연관관계의 주인은 별도의 설정을 할 필요 없다.
    OneToOne 과 ManyToOne의 fetch 속성의 기본값은 EAGER 이다.
        EAGAR 일 때 : lecture을 조회할 때마다 lecture과 연관된 student 정보가 항상 같이 로드된다
        LAZY 일 때 : Lecture 만 조회할 때는 student 정보가 로드되지 않고,
                    실제로 student 필드에 접근하는 시점에 정보가 조회된다
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    @Builder
    public Course(Long courseNumber, String courseName, String courseRoom
            , String courseTime, String courseProfessor, Student student){
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.courseRoom = courseRoom;
        this.courseTime = courseTime;
        this.courseProfessor = courseProfessor;
        this.student = student;
    }

    public void update(CourseSaveRequestDto dto) {
        this.courseNumber = dto.getCourseNumber();
        this.courseName = dto.getCourseName();
        this.courseRoom = dto.getCourseRoom();
        this.courseTime = dto.getCourseTime();
        this.courseProfessor = dto.getCourseProfessor();
    }

}
