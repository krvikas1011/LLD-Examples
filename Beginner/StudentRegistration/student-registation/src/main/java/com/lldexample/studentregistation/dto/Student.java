package com.lldexample.studentregistation.dto;

import lombok.Data;
import java.util.List;

@Data
public class Student {

    private int id;

    private String name;

    private String email;

    private List<Courses> courses;

    @Override
    public boolean equals(Object obj) {
        Student student = (Student) obj;
        return this.name.equals(student.name) &&
                this.email.equals(student.email);
    }
}
