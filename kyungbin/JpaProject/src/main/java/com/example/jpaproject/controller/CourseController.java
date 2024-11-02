package com.example.jpaproject.controller;

import com.example.jpaproject.dto.CourseDto.CourseInfoResponseDto;
import com.example.jpaproject.dto.CourseDto.CourseSaveRequestDto;
import com.example.jpaproject.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseInfoResponseDto> save(@RequestBody CourseSaveRequestDto courseSaveRequestDto) {
        return new ResponseEntity<>(courseService.save(courseSaveRequestDto), HttpStatus.CREATED);
    }
    @GetMapping("/{courseId}")
    public ResponseEntity<CourseInfoResponseDto> findByCourseId(@PathVariable(name = "coursId") int courseId) {
        return new ResponseEntity<>(courseService.findByCourseId(courseId), HttpStatus.OK);
    }
    @PatchMapping("/{courseId}")
    public ResponseEntity<CourseInfoResponseDto> updateByCourseId(@PathVariable(name = "courseId") int courseId,
                                                              @RequestBody CourseSaveRequestDto courseSaveRequestDto) {
        return new ResponseEntity<>(courseService.updateByCourseId(courseId, courseSaveRequestDto), HttpStatus.OK);
    }
    @DeleteMapping("/{courseId}")
    public ResponseEntity<CourseInfoResponseDto> deleteByCourseId(@PathVariable(name = "courseId") int courseId) {
        courseService.deleteCourse(courseId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
