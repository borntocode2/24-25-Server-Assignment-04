package com.example.jpastudy.repository;

import com.example.jpastudy.domain.Sugang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SugangRepository extends JpaRepository<Sugang, Long> {
    List<Sugang> findByStudentId(Long studentId);
}
