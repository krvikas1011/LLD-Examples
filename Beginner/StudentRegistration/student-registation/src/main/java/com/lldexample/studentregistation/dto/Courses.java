package com.lldexample.studentregistation.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Courses {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private List<Student> students;
}
