package com.example.sanghwa.controller;

import com.example.sanghwa.domain.LectureRegistration;
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

    @PostMapping
    public ResponseEntity<RegistrationResponseDto> save(@RequestBody RegistrationSaveDto registrationSaveDto) {
        return new ResponseEntity<>(lectureRegistrationService.saveRegistration(registrationSaveDto), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<LectureRegistration>> getAllRegistrationById(@PathVariable Long id) {
        return new ResponseEntity<>(lectureRegistrationService.findAllRegistrationById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        lectureRegistrationService.deleteRegistrationById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
