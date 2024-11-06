package com.example.sanghwa.repository;

import com.example.sanghwa.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LectureRepository extends JpaRepository<Lecture, Long> {

}
