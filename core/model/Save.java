package core.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.data.ToysDistributor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Save extends Mode {

    public Save() {
        super("save", "save file");
    }

    @Override
    public void execute(ToysDistributor toys, Scanner scanner) {
        System.out.print("File name: ");
        String filePath = scanner.next().trim().strip();
        String path = filePath + ".json";
        ObjectMapper mapper = new ObjectMapper();
        String jsonString;
        try {
            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(toys.getToys());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } try {
            Files.write(Paths.get(path),
                    jsonString.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("err: error writing");;
        }
        System.out.println("saved successfully");
    }
}
