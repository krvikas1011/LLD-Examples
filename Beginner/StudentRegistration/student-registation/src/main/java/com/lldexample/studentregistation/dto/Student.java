package com.lldexample.studentregistation.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Student {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private List<Courses> courses;
}
