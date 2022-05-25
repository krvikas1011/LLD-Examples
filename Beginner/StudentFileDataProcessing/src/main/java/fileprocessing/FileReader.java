package fileprocessing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {

    public List<Student> getDataFromFile(String filepath) throws IOException {
        return Files.lines(Paths.get(filepath)).map(l -> l.split(" "))
                .map(student -> new Student(student[0], Integer.parseInt(student[1]), Integer.parseInt(student[2]), student[3]))
                .collect(Collectors.toList());

    }
}
