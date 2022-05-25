package fileprocessing;

import java.util.*;
import java.util.stream.Collectors;

public class StudentDataProcessor {

    public List<String> getAllNames(List<Student> students) {
        return students.stream().map(student -> student.getName()).collect(Collectors.toList());
    }

    public List<String> getStudentNamesAbove20(List<Student> students) {
        return students.stream().filter(student -> student.getAge() > 20).map(Student::getName).toList();
    }

    public Map<String, List<Student>> getAllStudentsByCity(List<Student> students) {
        return students.stream().collect(Collectors.groupingBy(Student::getCity));
    }

    public String getStudentWithHighestSalaryForTheGivenCity(List<Student> students, String city) {
        return students.stream().filter(student1 -> student1.getCity().equalsIgnoreCase(city))
                .max(Comparator.comparingInt(Student::getSalary)).get().toString();
    }

    public Map<String, String> getNamesWithHighestSalaryForEachCity(List<Student> students) {
        Map<String, Student> student = students.stream().collect(Collectors.groupingBy(Student::getCity,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Student::getSalary)), Optional::get)));
        Map<String, String> studentName = new HashMap<>();
        for(Map.Entry mapEntry : student.entrySet()) {
            Student s = (Student) mapEntry.getValue();
            studentName.put((String) mapEntry.getKey(), s.getName());
        }
        return studentName;
    }

    public int getTotalSalary(List<Student> students) {
//        using reduce()
//        return students.stream().map(student -> student.getSalary()).reduce(0, Integer::sum);
       return students.stream().collect(Collectors.summingInt(Student::getSalary));
    }

}
