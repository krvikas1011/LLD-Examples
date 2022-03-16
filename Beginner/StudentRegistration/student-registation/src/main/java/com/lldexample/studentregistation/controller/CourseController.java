package com.lldexample.studentregistation.controller;

import com.lldexample.studentregistation.dto.Courses;
import com.lldexample.studentregistation.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/{id}")
    public ResponseEntity<Courses> getCourseById(@PathVariable int id) {
        return new ResponseEntity<>(courseService.getCourseById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Set<Courses>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Courses> createCourse(@RequestBody Courses course) {
        return new ResponseEntity<>(courseService.createCourse(course), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Courses> updateCourseById(@RequestBody Courses course, @PathVariable int id) {
        return new ResponseEntity<>(courseService.updateCourseById(course, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable int id) {
        return new ResponseEntity<>(courseService.deleteCourseById(id), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllCourses() {
        return new ResponseEntity<>(courseService.deleteAllCourses(), HttpStatus.NOT_FOUND);
    }
}
