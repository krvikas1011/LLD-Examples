package com.lldexample.studentregistation.service;

import com.lldexample.studentregistation.dto.Courses;
import com.lldexample.studentregistation.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StudentCourseRegistrationService {

    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    public Student registerCourseToStudent(int studentId, int courseId) {
        Courses courseData = null;
        for(Courses course : courseService.getCourseData()) {
            if(course.getId() == courseId) {
                courseData = course;
                break;
            }
        }
        if(courseData == null) {
            System.out.println("Course with id " + courseId + " does not exist.");
            return new Student();
        }
        for(Student student : studentService.getStudentsData()) {
            if(student.getId() == studentId) {
                student.setCourses(Arrays.asList(courseData));
                return student;
            }
        }
        return new Student();
    }
}
