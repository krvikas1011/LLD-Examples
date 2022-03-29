package com.lldexample.studentregistation.controller;

import com.lldexample.studentregistation.dto.Student;
import com.lldexample.studentregistation.service.StudentCourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class StudentCourseRegistrationController {

    @Autowired
    StudentCourseRegistrationService studentCourseRegistrationService;

    @PostMapping("/{id}")
    public ResponseEntity<Student> registerStudentToCourse(@PathVariable int studentId, @PathVariable int courseId) {
        return new ResponseEntity<>(studentCourseRegistrationService.registerCourseToStudent(studentId, courseId), HttpStatus.CREATED);
    }
}
