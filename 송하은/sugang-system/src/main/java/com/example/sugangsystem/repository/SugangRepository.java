package com.example.sugangsystem.repository;

import com.example.sugangsystem.domain.Sugang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SugangRepository extends JpaRepository<Sugang, Long> {
    // 학생 id 에 해당하는 수강신청 목록 조회
    List<Sugang> findByStudent_Id(Long id);

    // 학생 id, 수강 id 가 일치하는 수강신청 내역 조회 (수강신청 취소시 사용)
    Optional<Sugang> findByIdAndStudent_Id(Long id, Long studentId);

}
