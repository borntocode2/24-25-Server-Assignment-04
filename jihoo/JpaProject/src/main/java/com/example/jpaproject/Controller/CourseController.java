package com.example.jpaproject.Controller;

import com.example.jpaproject.Dto.Course.request.CourseRequestDto;
import com.example.jpaproject.Dto.Course.response.CourseListResponseDto;
import com.example.jpaproject.Dto.Course.response.CourseResponseDto;
import com.example.jpaproject.Service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseResponseDto> create(@RequestBody CourseRequestDto courseRequestDto){
        log.info("course read 요청 -{}", courseRequestDto.getTitle());
        courseService.create(courseRequestDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseResponseDto> findByCourseId(@PathVariable("courseId") Long courseId) {
        log.info("course read 요청 -{}", courseId);
        CourseResponseDto findCourse = courseService.findByCourseId(courseId);
        return ResponseEntity.ok().body(findCourse);
    }

    @PatchMapping("/{courseId}")
    public ResponseEntity<CourseResponseDto> updateByCourseId(@PathVariable("courseId") Long courseId, @RequestBody CourseRequestDto dto) {
        log.info("course update 요청 -{}", courseId);
        courseService.updateByCourseId(courseId, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<CourseResponseDto> deleteByCourseId(@PathVariable("courseId") Long courseId) {
        log.info("course delete 요청 -{}", courseId);
            courseService.deleteByCourseId(courseId);
            return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<CourseListResponseDto> findAllCourses() {
        log.info("course findAllCourses 요청");
        CourseListResponseDto allCourses = courseService.findAllCourses();
        return ResponseEntity.ok().body(allCourses);
    }
}
