package core.data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Client {
    private final String name;
    private List<String> winning;

    public Client(String name) {
        this.name = name;
        this.winning = new LinkedList<>();
    }

    public void setWinning(List<String> winning) {
        this.winning = winning;
    }


    public void writeToFile() {
        String filePath = "resultLottery.txt";
        try {
            FileWriter file = new FileWriter(filePath);
            BufferedWriter buff = new BufferedWriter(file);
            buff.write(name + " winning:\n");
            for (String w : winning) {
                buff.write(w);
                buff.newLine();
            }
            buff.close();
        } catch (IOException e) {
            System.out.println("recording error" + filePath);
        }
        System.out.println("recording successful");
    }
}
