package core.model;

import core.data.ToysDistributor;

import java.util.Scanner;

public class Exit extends Mode {

    public Exit() {
        super("exit", "exit");
    }

    @Override
    public void execute(ToysDistributor toys, Scanner scanner) {
        System.out.println("goodbye!");
        System.exit(0);
    }
}
