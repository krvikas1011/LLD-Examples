package fileprocessing;

import lombok.Data;

@Data
public class Student {

    private String name;
    private int age;
    private int salary;
    private String city;

    public Student(String name, int age, int salary, String city) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.city = city;
    }

}
