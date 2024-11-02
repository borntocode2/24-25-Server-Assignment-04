package com.example.jpastudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jpastudy.domain.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Long> {

}
