package com.example.jpastudy.controller;

import com.example.jpastudy.dto.LectureInfoResponseDto;
import com.example.jpastudy.dto.LectureListResponseDto;
import com.example.jpastudy.dto.LectureSaveRequestDto;
import com.example.jpastudy.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lecture")
public class LectureController {
    private final LectureService lectureService;

    @PostMapping
    public ResponseEntity<LectureInfoResponseDto> saveLecture(@RequestBody LectureSaveRequestDto lectureSaveRequestDto) {
        return new ResponseEntity<>(lectureService.saveLecture(lectureSaveRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LectureInfoResponseDto> findLectureById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(lectureService.findLectureById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<LectureInfoResponseDto> updateLectureById(@PathVariable(name = "id") Long id, @RequestBody LectureSaveRequestDto lectureSaveRequestDto) {
        return new ResponseEntity<>(lectureService.updateLectureById(id, lectureSaveRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LectureInfoResponseDto> deleteLectureById(@PathVariable(name = "id") Long id) {
        lectureService.deleteLectureById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<LectureListResponseDto> findAllLectures() {
        return new ResponseEntity<>(lectureService.findAllLectures(), HttpStatus.OK);
    }
}
