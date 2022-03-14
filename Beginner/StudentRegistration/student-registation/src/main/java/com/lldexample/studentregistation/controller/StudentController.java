package com.lldexample.studentregistation.controller;

import com.lldexample.studentregistation.dto.Student;
import com.lldexample.studentregistation.service.StudentService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Set<Student>> getAllStudents() {
        return new ResponseEntity<Set<Student>>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentById(@RequestBody Student student, @PathVariable int id) {
        return new ResponseEntity<>(studentService.updateStudentById(student, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id) {
        return new ResponseEntity<>(studentService.deleteStudentById(id), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllStudents() {
        return new ResponseEntity<>(studentService.deleteAllStudents(), HttpStatus.NOT_FOUND);
    }
}
