package com.lldexample.studentregistation.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Courses {

    private int id;

    private String name;

    @Override
    public boolean equals(Object courseObject) {
        Courses course = (Courses) courseObject;
        return this.name.equals(course.name);
    }

}
