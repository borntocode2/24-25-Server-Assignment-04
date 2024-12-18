package com.example.sanghwa.controller;

import com.example.sanghwa.domain.Lecture;
import com.example.sanghwa.dto.lecture.LectureListResponseDto;
import com.example.sanghwa.dto.lecture.LectureResponseDto;
import com.example.sanghwa.dto.lecture.LectureSaveDto;
import com.example.sanghwa.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/lecture")
public class LectureController {
    private final LectureService lectureService; //@RequiredArgsConstructor를 선언했을 때 왜 final을 쓰는가?

    //강의등록
    @PostMapping
    public ResponseEntity<LectureResponseDto> save(@RequestBody LectureSaveDto lectureSaveDto) {
        return new ResponseEntity<>(lectureService.save(lectureSaveDto), HttpStatus.OK);
    }

    //강의 전체 조회
    @GetMapping("/lectureList")
    public ResponseEntity<LectureListResponseDto> findAll() {
        return new ResponseEntity<>(lectureService.findLectures(), HttpStatus.CREATED);
    }

    //한 강의 조회
    @GetMapping("/{id}")
    public ResponseEntity<LectureResponseDto> findByLectureId(@PathVariable Long id) {
        return new ResponseEntity<>(lectureService.findLectureById(id), HttpStatus.OK);
    }

    //강의 수정
    @PatchMapping("/{id}")
    public ResponseEntity<LectureResponseDto> update(@PathVariable Long id, @RequestBody LectureSaveDto lectureSaveDto) {
        return new ResponseEntity<>(lectureService.updateLecture(id, lectureSaveDto), HttpStatus.OK);
    }

    //강의 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        lectureService.deleteLecture(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
