package com.example.jpaproject.service;

import com.example.jpaproject.domain.Course;
import com.example.jpaproject.dto.CourseDto.CourseInfoResponseDto;
import com.example.jpaproject.dto.CourseDto.CourseSaveRequestDto;
import com.example.jpaproject.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //서비스 계층임을 알려준다.
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    @Transactional // 예외가 발생하는 경우 롤백해준다.
    //Create : 새로운 과목을 생성한다.
    public CourseInfoResponseDto save(CourseSaveRequestDto courseSaveRequestDto) {
        // 전달받은 Dto를 엔터티로 변환하여 Repository에 저장한다.
        Course cours = courseSaveRequestDto.toEntity();
        courseRepository.save(cours);

        return CourseInfoResponseDto.from(cours); //클라이언트한테 갈 정보
    }

    @Transactional
    //Read : id로 과목 정보를 조회한다.
    public CourseInfoResponseDto findByCourseId(int id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("없는 id입니다."));
        return CourseInfoResponseDto.from(course);
    }

    @Transactional
    //update : 과목 정보를 수정한다.
    public CourseInfoResponseDto updateByCourseId(int id, CourseSaveRequestDto courseSaveRequestDto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("없는 id입니다."));
        course.update(courseSaveRequestDto.getSubjectName(), courseSaveRequestDto.getRoomNum());

        return CourseInfoResponseDto.from(course);
    }

    @Transactional
    //delete : 학생 정보를 삭제한다.
    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }
}
