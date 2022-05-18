package fileprocessing;

import java.util.*;
import java.util.stream.Collectors;

public class StudentDataDisplay {

    public List<String> displayAllNames(List<Student> students) {
        System.out.println("1. Displaying the names of all the students...");
        List<String> names = students.stream().map(student -> student.getName()).collect(Collectors.toList());
        return names;
    }

    public List<String> displayStudentNamesAbove20(List<Student> students) {
        System.out.println("2. Displaying the names of all the students above the age of 20...");
        List<String> names = students.stream().filter(student -> student.getAge() > 20).map(Student::getName).toList();
        return names;
    }

    public Map<String, List<Student>> displayAllStudentsByCity(List<Student> students) {
        System.out.println("3. Displaying the students for each city...");
        Map<String, List<Student>> studentsByCity = students.stream().collect(Collectors.groupingBy(Student::getCity));
        return studentsByCity;
    }

    public String displayStudentWithHighestSalaryForTheGivenCity(List<Student> students, String city) {
        System.out.printf("4. Displaying the student with highest salary for the city %s...\n", city);
        Student student = students.stream().filter(student1 -> student1.getCity().equalsIgnoreCase(city))
                .max(Comparator.comparingInt(Student::getSalary)).get();
        return student.toString();
    }

    public Map<String, String> displayNamesWithHighestSalaryForEachCity(List<Student> students) {
        System.out.println("5. Displaying names of students with highest salary for each city...");
        Map<String, Student> student = students.stream().collect(Collectors.groupingBy(Student::getCity,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Student::getSalary)), Optional::get)));
        Map<String, String> studentName = new HashMap<>();
        for(Map.Entry mapEntry : student.entrySet()) {
            Student s = (Student) mapEntry.getValue();
            studentName.put((String) mapEntry.getKey(), s.getName());
        }
        return studentName;
    }

    public int displayTotalSalary(List<Student> students) {
        System.out.println("6. Displaying the total salary of all the students...");
//        using reduce()
//        int totalSalary = students.stream().map(student -> student.getSalary()).reduce(0, Integer::sum);
        int totalSalary = students.stream().collect(Collectors.summingInt(Student::getSalary));
        return totalSalary;
    }

}
