package com.example.kiwoong.repository;

import com.example.kiwoong.domain.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoursesRepository extends JpaRepository<Courses, Long> {
    @Query("SELECT c FROM Courses c WHERE c.name = :name")
    List<Courses> findCoursesByName(@Param("name") String name);//강의 이름으로 검색

    //JPQL로 in절을 사용하였습니다
    //@Param은 매개변수가 어떤 컬럼과 매칭될지 정해줌.
    @Query("SELECT c FROM Courses c WHERE c.name in :namePart")
    List<Courses> findByNameContaining(@Param("name")String namePart); //이름 일부로 검색

    //'화'로 검색할 수 도 있고 '화요일'로 검색할 수도 있어 in을 사용했는데 더 좋은 방법이 있을까요?
    @Query("SELECT c FROM Courses c WHERE c.day in :dayPart")
    List<Courses> findByDayContaining(@Param("day")String dayPart); //날짜로 검색
}