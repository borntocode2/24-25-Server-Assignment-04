package com.example.kiwoong.repository;

import com.example.kiwoong.domain.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoursesRepository extends JpaRepository<Courses, Long> {
}