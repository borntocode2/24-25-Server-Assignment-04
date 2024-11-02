package com.example.jpastudy.service;

import com.example.jpastudy.domain.Lecture;
import com.example.jpastudy.domain.Student;
import com.example.jpastudy.domain.Sugang;
import com.example.jpastudy.dto.SugangInfoResponseDto;
import com.example.jpastudy.dto.SugangListResponseDto;
import com.example.jpastudy.dto.SugangRequestDto;
import com.example.jpastudy.repository.LectureRepository;
import com.example.jpastudy.repository.StudentRepository;
import com.example.jpastudy.repository.SugangRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SugangService {
    private final SugangRepository sugangRepository;
    private final StudentRepository studentRepository;
    private final LectureRepository lectureRepository;

    @Transactional
    public SugangInfoResponseDto save(SugangRequestDto sugangRequestDto) {
        Student student = studentRepository.findById(sugangRequestDto.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
        Lecture lecture = lectureRepository.findById(sugangRequestDto.getLectureId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));

        Sugang sugang = Sugang.builder()
                .student(student)
                .lecture(lecture)
                .build();
        sugangRepository.save(sugang);
        return SugangInfoResponseDto.from(sugang);
    }

    @Transactional(readOnly = true)
    public SugangListResponseDto findSugangInfoByStudentId(Long studentId) {
        List<Sugang> sugangList = sugangRepository.findByStudentId(studentId);

        List<SugangInfoResponseDto> sugangInfoResponseDtoList = sugangList.stream()
                .map(SugangInfoResponseDto::from)
                .toList();
        
        return SugangListResponseDto.from(sugangInfoResponseDtoList);
    }

    @Transactional
    public void cancleSugang(Long id) {
        sugangRepository.deleteById(id);
    }

    @Transactional
    public SugangListResponseDto findSugangList() {
        List<Sugang> sugangList = sugangRepository.findAll();

        List<SugangInfoResponseDto> sugangInfoResponseDtoList = sugangList.stream()
                .map(SugangInfoResponseDto::from)
                .toList();

        return SugangListResponseDto.from(sugangInfoResponseDtoList);
    }
}
