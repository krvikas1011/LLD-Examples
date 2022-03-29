package com.lldexample.studentregistation.service;

import com.lldexample.studentregistation.dto.Course;
import com.lldexample.studentregistation.dto.Student;
import com.lldexample.studentregistation.dto.StudentCourseRegistrationData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StudentCourseRegistrationService {

    private final StudentService studentService;
    private final CourseService courseService;

    @Autowired
    public StudentCourseRegistrationService(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public Student registerCourseToStudent(StudentCourseRegistrationData studentCourseRegistrationData) {
        Course courseData;
        int courseId = studentCourseRegistrationData.getCourseId();
        int studentId = studentCourseRegistrationData.getStudentId();
        courseData = courseService.getCourseById(courseId);
        if (courseData == null) {
            return null;
        }
        Student targetStudent = studentService.getStudentById(studentId);
        if (targetStudent == null) {
            return null;
        }
        targetStudent.getCourses().add(courseData);
        return targetStudent;
    }

    public Student deRegisterCourseFromStudent(StudentCourseRegistrationData studentCourseRegistrationData) {
        Course courseData;
        int courseId = studentCourseRegistrationData.getCourseId();
        int studentId = studentCourseRegistrationData.getStudentId();
        courseData = courseService.getCourseById(courseId);
        if (courseData == null) {
            return null;
        }
        Student targetStudent = studentService.getStudentById(studentId);
        if (targetStudent == null) {
            return null;
        }
        targetStudent.getCourses().remove(courseData);
        return targetStudent;
    }
}
