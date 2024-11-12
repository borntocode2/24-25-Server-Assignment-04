package com.example.kiwoong.controller;

import com.example.kiwoong.dto.Enrolment.request.EnrolmentRequestDto;
import com.example.kiwoong.dto.Enrolment.response.EnrolmentInfoResponseDto;
import com.example.kiwoong.dto.Enrolment.response.EnrolmentListResponseDto;
import com.example.kiwoong.service.EnrolmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/enrolment")
public class EnrolmentController {
    private final EnrolmentService enrolmentService;
    @PostMapping
    public ResponseEntity<EnrolmentInfoResponseDto> save(@RequestBody EnrolmentRequestDto enrolmentRequestDto){
        return new ResponseEntity<>(enrolmentService.save(enrolmentRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EnrolmentInfoResponseDto> findByEnrolmentId(@PathVariable(name="id") Long id){
        return new ResponseEntity<>(enrolmentService.findByEnrolmentId(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<EnrolmentInfoResponseDto> deleteByEnrolmentId(@PathVariable(name="id") Long id){
        enrolmentService.deleteByEnrolmentId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<EnrolmentListResponseDto> findAllEnrolmentId(){
        return new ResponseEntity<>(enrolmentService.findAllEnrolmentId(), HttpStatus.OK);
    }
}