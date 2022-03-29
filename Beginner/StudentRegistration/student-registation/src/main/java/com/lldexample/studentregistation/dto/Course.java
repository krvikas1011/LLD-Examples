package com.lldexample.studentregistation.dto;

import lombok.Data;

@Data
public class Course {

    private int id;

    private String name;

    @Override
    public boolean equals(Object courseObject) {
        Course course = (Course) courseObject;
        return this.id == course.id || this.name.equals(course.name);
    }
}
