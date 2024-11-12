package com.example.gdg_jpa.controller;


import com.example.gdg_jpa.domain.Lecture;
import com.example.gdg_jpa.dto.LectureDto;
import com.example.gdg_jpa.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lecture")
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;

    // 생성
    @PostMapping
    public ResponseEntity<Lecture> createLecture(@RequestBody LectureDto.Request request) {
        lectureService.createLecture(request);
        return ResponseEntity.ok().build();
    }

    // 조회
    @GetMapping("/{id}")
    public ResponseEntity<LectureDto.Response> getLectures(
            @PathVariable Long id) {

        return new ResponseEntity(lectureService.readLectureById(id), HttpStatus.OK);
    }

    // 수정
    @PatchMapping("/{id}")
    public ResponseEntity<LectureDto.Response> updateLecture(
            @PathVariable Long id,
            @RequestBody LectureDto.Request request) {

        return new ResponseEntity(lectureService.updateLecture(id,request),HttpStatus.OK);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<LectureDto.Response> deleteLecture(@PathVariable Long id) {
        lectureService.deleteLecture(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
