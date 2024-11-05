package com.example.sanghwa.controller;

import com.example.sanghwa.domain.Lecture;
import com.example.sanghwa.dto.LectureResponseDto;
import com.example.sanghwa.dto.LectureSaveDto;
import com.example.sanghwa.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/lectures")
public class LectureController {
    private LectureService lectureService;

    @PostMapping
    public ResponseEntity<LectureResponseDto> save(@RequestBody LectureSaveDto lectureSaveDto) {
        return new ResponseEntity<>(lectureService.save(lectureSaveDto), HttpStatus.OK);
    }

    @GetMapping("/lectureList")
    public ResponseEntity<List<Lecture>> findAll() {
        return new ResponseEntity<>(lectureService.findLectures(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LectureResponseDto> findByLectureId(@PathVariable Long id) {
        return new ResponseEntity<>(lectureService.findLectureById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<LectureResponseDto> update(@PathVariable Long id, @RequestBody LectureSaveDto lectureSaveDto) {
        return new ResponseEntity<>(lectureService.updateLecture(id, lectureSaveDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        lectureService.deleteLecture(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
