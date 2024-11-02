package org.example.gdgweek4assignmentktw.controller;

import org.example.gdgweek4assignmentktw.exception.CourseAlreadyExistsException;
import org.example.gdgweek4assignmentktw.exception.CourseNotExistsException;
import org.example.gdgweek4assignmentktw.exception.StudentAlreadyExistsException;
import org.example.gdgweek4assignmentktw.exception.StudentNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    // StudentNotExistsException 처리
    @ExceptionHandler(StudentNotExistsException.class)
    public ResponseEntity<String> handleStudentNotExistsException(StudentNotExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // StudentAlreadyExistsException 처리
    @ExceptionHandler(StudentAlreadyExistsException.class)
    public ResponseEntity<String> handleStudentAlreadyExistsException(StudentAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    // CourseAlreadyExistsException 처리
    @ExceptionHandler(CourseAlreadyExistsException.class)
    public ResponseEntity<String> handleCourseAlreadyExistsException(CourseAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    // CourseNotExistsException 처리
    @ExceptionHandler(CourseNotExistsException.class)
    public ResponseEntity<String> handleCourseNotExistsException(CourseNotExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // IllegalArgumentException 처리(존재하지 않는 강의일때 에외 처리에 사용)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // 그 외 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("서버에서 오류가 발생했습니다. 잠시 후 다시 시도해주세요.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
