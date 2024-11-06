package com.example.sanghwa.controller;

import com.example.sanghwa.domain.LectureRegistration;
import com.example.sanghwa.dto.registration.RegistrationListResponseDto;
import com.example.sanghwa.dto.registration.RegistrationResponseDto;
import com.example.sanghwa.dto.registration.RegistrationSaveDto;
import com.example.sanghwa.service.LectureRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/registration")
public class LectureRegistrationController {
    private final LectureRegistrationService lectureRegistrationService;

    //수강신청
    @PostMapping
    public ResponseEntity<RegistrationResponseDto> save(@RequestBody RegistrationSaveDto registrationSaveDto) {
        return new ResponseEntity<>(lectureRegistrationService.saveRegistration(registrationSaveDto), HttpStatus.OK);
    }

    //학생의 전체강의 조회
    @GetMapping("/{id}")
    public ResponseEntity<List<RegistrationListResponseDto>> getAllRegistrationById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(lectureRegistrationService.findAllRegistrationById(id), HttpStatus.OK);
        //LectureRegistrationRepository에는 엔티티 객체가 저장되니, 거기서 student id만 뽑아 오게끔 해야함.
    }

    //전체 수강신청 조회
    @GetMapping
    public ResponseEntity<List<RegistrationResponseDto>> getAllRegistration(){
        return new ResponseEntity<>(lectureRegistrationService.getAllRegistration(), HttpStatus.OK);
    }

    //수강신청 삭제, 수강신청id 이용
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        lectureRegistrationService.deleteRegistrationById(id);
        return ResponseEntity.ok("해당 신청이 삭제되었습니다.");
    }


}
