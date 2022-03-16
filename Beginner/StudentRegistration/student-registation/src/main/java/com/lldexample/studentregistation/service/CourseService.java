package com.lldexample.studentregistation.service;

import com.lldexample.studentregistation.dto.Courses;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CourseService {
    private Set<Courses> courses = new HashSet<>();

    private int id = 1;

    public Courses getCourseById(int id) {
        if(!courses.isEmpty()) {
            for (Courses course : courses) {
                if (course.getId() == id) {
                    return course;
                }
            }
        }
        return new Courses();
    }

    public Set<Courses> getAllCourses() {
        return courses;
    }

    public Courses createCourse(Courses course) {
        Courses courseObject = new Courses();
        courseObject.setId(id);
        courseObject.setName(course.getName());
        courses.add(courseObject);
        id++;
        return courseObject;
    }

    public Courses updateCourseById(Courses course, int id) {
        if(!courses.isEmpty()) {
            for (Courses courseObject : courses) {
                if (courseObject.getId() == id) {
                    courseObject.setName(course.getName());
                    return courseObject;
                }
            }
        }
        return new Courses();
    }

    public String deleteCourseById(int id) {
        if(!courses.isEmpty()) {
            for (Courses courseObject : courses) {
                if (courseObject.getId() == id) {
                    courses.remove(courseObject);
                    return "Removed course with id " + id;
                }
            }
        }
        return "Course with id " + id + " does not exist.";
    }

    public String deleteAllCourses() {
        courses = new HashSet<>();
        return "Removed all courses.";
    }
}
