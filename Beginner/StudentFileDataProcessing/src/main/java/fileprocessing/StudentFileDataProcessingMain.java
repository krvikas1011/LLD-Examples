package fileprocessing;

import java.io.IOException;
import java.util.*;

public class StudentFileDataProcessingMain {

    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Temp\\Students.txt";
        FileReader fileReader = new FileReader();
        StudentDataProcessor studentDataProcessor = new StudentDataProcessor();
        List<Student> students = fileReader.getDataFromFile(filePath);
        System.out.println("1. Displaying the names of all the students...");
        List<String> names = studentDataProcessor.getAllNames(students);
        System.out.println(names);
        System.out.println("2. Displaying the names of all the students above the age of 20...");
        names = studentDataProcessor.getStudentNamesAbove20(students);
        System.out.println(names);
        System.out.println("3. Displaying the students for each city...");
        Map<String, List<Student>> studentByCity = studentDataProcessor.getAllStudentsByCity(students);
        System.out.println(studentByCity);
        String city = "Pune";
        String student = studentDataProcessor.getStudentWithHighestSalaryForTheGivenCity(students, city);
        System.out.printf("4. Displaying the student with highest salary for the city %s...\n", city);
        System.out.println(student);
        System.out.println("5. Displaying names of students with highest salary for each city...");
        Map<String, String> studentName = studentDataProcessor.getNamesWithHighestSalaryForEachCity(students);
        System.out.println(studentName);
        System.out.println("6. Displaying the total salary of all the students...");
        System.out.println(studentDataProcessor.getTotalSalary(students));
    }

}
