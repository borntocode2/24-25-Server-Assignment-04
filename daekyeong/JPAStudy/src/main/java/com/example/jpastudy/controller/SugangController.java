package com.example.jpastudy.controller;

import com.example.jpastudy.dto.SugangInfoResponseDto;
import com.example.jpastudy.dto.SugangListResponseDto;
import com.example.jpastudy.dto.SugangRequestDto;
import com.example.jpastudy.service.SugangService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sugang")
public class SugangController {
    private final SugangService sugangService;

    @PostMapping
    public ResponseEntity<SugangInfoResponseDto> sugangRequest(@RequestBody SugangRequestDto sugangRequestDto) {
        return new ResponseEntity<>(sugangService.save(sugangRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SugangListResponseDto> getSugangInfo(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(sugangService.findSugangInfoByStudentId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SugangInfoResponseDto> cancleSugangInfo(@PathVariable(name = "id") Long id) {
        sugangService.cancleSugang(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<SugangListResponseDto> getSugangList() {
        return new ResponseEntity<>(sugangService.findSugangList(), HttpStatus.OK);
    }
}
