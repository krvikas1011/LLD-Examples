package fileprocessing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public List<Student> getDataFromFile(String filepath) throws IOException {
        List<Student> students = new ArrayList<>();
        Stream<String> lines = Files.lines(Paths.get(filepath));
        List<String> collect = lines.collect(Collectors.toList());
        for(String value : collect){
            String[] studentData = value.split(" ");
            String name = studentData[0];
            int age = Integer.parseInt(studentData[1]);
            int salary = Integer.parseInt(studentData[2]);
            String city = studentData[3];
            students.add(new Student(name, age, salary, city));
        }
        return students;
    }
}
