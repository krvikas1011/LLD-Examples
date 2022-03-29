package com.lldexample.studentregistation.service;

import com.lldexample.studentregistation.dto.Course;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CourseService {
    private int id = 1;

    private Set<Course> courses = new HashSet<>();

    public Set<Course> getAllCourses() {
        return courses;
    }

    public Course getCourseById(int id) {
        if (!courses.isEmpty()) {
            for (Course course : courses) {
                if (course.getId() == id) {
                    return course;
                }
            }
        }
        return null;
    }

    public Course createCourse(Course course) {
        Course courseObject = new Course();
        courseObject.setId(id);
        courseObject.setName(course.getName());
        courses.add(courseObject);
        id++;
        return courseObject;
    }

    public Course updateCourseById(Course course, int id) {
        if (!courses.isEmpty()) {
            for (Course courseObject : courses) {
                if (courseObject.getId() == id) {
                    courseObject.setName(course.getName());
                    return courseObject;
                }
            }
        }
        return null;
    }

    public String deleteCourseById(int id) {
        if (!courses.isEmpty()) {
            for (Course courseObject : courses) {
                if (courseObject.getId() == id) {
                    courses.remove(courseObject);
                    return "Removed course with id " + id;
                }
            }
        }
        return "Course with id " + id + " does not exist.";
    }

    public String deleteAllCourses() {
        courses.clear();
        return "Removed all courses.";
    }

    public boolean isValidCourse(int courseId) {
        return courses.stream().filter(course -> course.getId() == courseId).findFirst().isPresent();
    }
}
