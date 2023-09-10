package core.model;

import core.data.Toy;
import core.data.ToysDistributor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Add extends Mode {

    public Add() {
        super("add", "to add");
    }

    @Override
    public void execute(ToysDistributor toys, Scanner scanner) {
        toys.addToy(getToy(toys, scanner, 1));
        System.out.println("add successfully");
    }
}
