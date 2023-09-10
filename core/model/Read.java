package core.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.data.Toy;
import core.data.ToysDistributor;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Read extends Mode {

    public Read() {
        super("read", "read from file");
    }

    @Override
    public void execute(ToysDistributor toys, Scanner scanner) {
        System.out.print("Enter file name");
        String filePath = scanner.next().trim().strip();
        String path = filePath + ".json";
        List<Toy> temp;
        ObjectMapper mapper = new ObjectMapper();
        try {
            temp = Arrays.asList(mapper.readValue(new File(path), Toy[].class));
        } catch (IOException e) {
            System.out.println("err: file is missing");
            return;
        }
        toys.setToys(new PriorityQueue<>(temp));
        System.out.println("loaded successfully");
    }
}
