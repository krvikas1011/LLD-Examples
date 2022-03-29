package com.lldexample.studentregistation.controller;

import com.lldexample.studentregistation.dto.Student;
import com.lldexample.studentregistation.dto.StudentCourseRegistrationData;
import com.lldexample.studentregistation.service.StudentCourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class StudentCourseRegistrationController {

    private final StudentCourseRegistrationService studentCourseRegistrationService;

    @Autowired
    public StudentCourseRegistrationController(StudentCourseRegistrationService studentCourseRegistrationService) {
        this.studentCourseRegistrationService = studentCourseRegistrationService;
    }

    @PostMapping
    public ResponseEntity<Student> registerStudentToCourse(
            @RequestBody StudentCourseRegistrationData studentCourseRegistrationData) {
        return new ResponseEntity<>(
                studentCourseRegistrationService.registerCourseToStudent(studentCourseRegistrationData),
                HttpStatus.CREATED);
    }
}
