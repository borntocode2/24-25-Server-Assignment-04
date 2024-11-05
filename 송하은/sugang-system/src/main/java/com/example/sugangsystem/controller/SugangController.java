package com.example.sugangsystem.controller;

import com.example.sugangsystem.dto.request.sugang.SugangRegisterRequestDto;
import com.example.sugangsystem.dto.response.sugang.SugangCourseCountResponseDto;
import com.example.sugangsystem.dto.response.sugang.SugangInfoResponseDto;
import com.example.sugangsystem.dto.response.sugang.SugangRegisterResponseDto;
import com.example.sugangsystem.service.SugangService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sugangs")
public class SugangController {

    private final SugangService sugangService;

    // 학생이 수강신청한다.
    @PostMapping
    public ResponseEntity<SugangRegisterResponseDto> register(@RequestBody SugangRegisterRequestDto sugangRegisterRequestDto) {
        return new ResponseEntity<>(sugangService.registerSugang(sugangRegisterRequestDto), HttpStatus.CREATED);
    }

    // 학생 ID 로 수강신청 내역을 조회한다.
    @GetMapping("/list/{studentId}")
    public ResponseEntity<List<SugangInfoResponseDto>> getSugangListByStudentId(@PathVariable("studentId") Long studentId) {
        return new ResponseEntity<>(sugangService.getSugangListByStudentId(studentId), HttpStatus.OK);
    }

    // 학생 ID 로 수강신청을 취소한다.
    @DeleteMapping("/cancel/{studentId}/{sugangId}")
    public ResponseEntity<Void> cancelSugangByStudentId(@PathVariable Long studentId, @PathVariable Long sugangId) {
        sugangService.cancelSugang(studentId, sugangId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 추가 기능 - 강의별 수강신청 인원을 조회한다.
    @GetMapping("/statistics")
    public ResponseEntity<List<SugangCourseCountResponseDto>> getSugangStatistics() {
        return new ResponseEntity<>(sugangService.getCountByCourse(), HttpStatus.OK);
    }
}