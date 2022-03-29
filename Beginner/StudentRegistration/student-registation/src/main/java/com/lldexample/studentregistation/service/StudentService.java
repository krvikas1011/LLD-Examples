package com.lldexample.studentregistation.service;

import com.lldexample.studentregistation.dto.Student;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudentService {
    private int id = 1;
    private Set<Student> students = new HashSet<>();

    public Student getStudentById(int id) {
        Student foundStudent = null;
        if (!students.isEmpty()) {
            foundStudent = students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
        }
        return foundStudent;
    }

    public Set<Student> getAllStudents() {
        return students;
    }

    public Student createStudent(Student student) {
        Student studentObject = new Student();
        studentObject.setId(id);
        studentObject.setName(student.getName());
        studentObject.setEmail(student.getEmail());
        students.add(studentObject);
        id++;
        return studentObject;
    }

    public Student updateStudentById(Student student, int id) {
        if (!students.isEmpty()) {
            for (Student studentObject : students) {
                if (studentObject.getId() == id) {
                    studentObject.setName(student.getName());
                    studentObject.setEmail(student.getEmail());
                    return studentObject;
                }
            }
        }
        return null;
    }

    public String deleteStudentById(int id) {
        if (!students.isEmpty()) {
            for (Student studentObject : students) {
                if (studentObject.getId() == id) {
                    students.remove(studentObject);
                    return "Removed student with id " + id;
                }
            }
        }
        return "Student with id " + id + " does not exist.";
    }

    public String deleteAllStudents() {
        students.clear();
        return "Removed all students.";
    }
}
