package core.model;

import core.data.Toy;
import core.data.ToysDistributor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Edit extends Mode {

    public Edit() {
        super("edit", "edit");
    }

    @Override
    public void execute(ToysDistributor toys, Scanner scanner) {
        int id;
        try {
            System.out.println("Enter toy's ID");
            id = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new RuntimeException();
        }
        Toy editToy = toys.searchById(id);
        System.out.println(editToy);
        System.out.print("edit Y/N ->");
        String choice = scanner.next().toLowerCase().trim().strip();
        if (choice.equals("y")) {
            editToy.setToy(getToy(toys, scanner, 0));
            System.out.println("changed successfully");
        } else System.out.println("back to main menu");
    }
}
