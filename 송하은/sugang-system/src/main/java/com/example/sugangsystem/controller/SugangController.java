package com.example.sugangsystem.controller;

import com.example.sugangsystem.dto.request.sugang.RegisterSugangRequestDto;
import com.example.sugangsystem.dto.response.sugang.GetSugangByStudentIdResponseDto;
import com.example.sugangsystem.dto.response.sugang.RegisterSugangResponseDto;
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
    @PostMapping("/register")
    public ResponseEntity<RegisterSugangResponseDto> register(@RequestBody RegisterSugangRequestDto registerSugangRequestDto) {
        return new ResponseEntity<>(sugangService.register(registerSugangRequestDto), HttpStatus.CREATED);
    }

    // 학생 ID 로 수강신청 내역을 조회한다.
    @GetMapping("/list/{studentId}")
    public ResponseEntity<List<GetSugangByStudentIdResponseDto>> getSugangListByStudentId(@PathVariable("studentId") Long studentId) {
        return new ResponseEntity<>(sugangService.getSugangListByStudentId(studentId), HttpStatus.OK);
    }

    // 학생 ID 로 수강신청을 취소한다.
    @DeleteMapping("/cancel/{studentId}/{sugangId}")
    public ResponseEntity<Void> cancelSugangByStudentId(@PathVariable Long studentId, @PathVariable Long sugangId) {
        sugangService.cancelSugang(studentId, sugangId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
