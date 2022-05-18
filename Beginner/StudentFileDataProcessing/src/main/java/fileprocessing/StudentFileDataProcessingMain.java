package fileprocessing;

import java.io.IOException;
import java.util.*;

public class StudentFileDataProcessingMain {

    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Temp\\Students.txt";
        FileReader fileReader = new FileReader();
        StudentDataDisplay studentDataDisplay = new StudentDataDisplay();
        List<Student> students = fileReader.getDataFromFile(filePath);
        List<String> names = studentDataDisplay.displayAllNames(students);
        System.out.println(names);
        names = studentDataDisplay.displayStudentNamesAbove20(students);
        System.out.println(names);
        Map<String, List<Student>> studentByCity = studentDataDisplay.displayAllStudentsByCity(students);
        System.out.println(studentByCity);
        String student = studentDataDisplay.displayStudentWithHighestSalaryForTheGivenCity(students, "Pune");
        System.out.println(student);
        Map<String, String> studentName = studentDataDisplay.displayNamesWithHighestSalaryForEachCity(students);
        System.out.println(studentName);
        System.out.println(studentDataDisplay.displayTotalSalary(students));
    }

}
