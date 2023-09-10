package core.control;

import core.data.ToysDistributor;
import core.model.Mode;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;

public class Control implements BasicControl {
    private final Map<String, Mode> modes;
    private final ToysDistributor toys;

    public Control(ToysDistributor toys, Map<String, Mode> modes) {
        this.modes = modes;
        this.toys = toys;
    }

    public int[] maxSizeMenu() {
        int maxName = 0, maxDescription = 0;
        for (Map.Entry<String, Mode> mode : modes.entrySet()) {
            if (mode.getValue().getNameMenu().length() > maxName)
                maxName = mode.getValue().getNameMenu().length();
            if (mode.getValue().getDescription().length() > maxDescription)
                maxDescription = mode.getValue().getDescription().length();
        }
        return new int[]{maxName, maxDescription};
    }


    @Override
    public void onExecute(String item, Scanner in) {
        try {
            modes.get(item).execute(toys, in);
        } catch (RuntimeException e) {
            System.out.println("err: Invalid value entered");
        }
    }

    @Override
    public String toString() {
        StringBuilder main = new StringBuilder();
        int[] size = maxSizeMenu();
        main.append("-".repeat(size[0]))
                .append("   ")
                .append("-".repeat(size[1]))
                .append("\n");
        for (Map.Entry<String, Mode> mode : modes.entrySet()) {
            main.append(mode.getValue().getNameMenu())
                    .append(" ".repeat(size[0] - mode.getValue().getNameMenu().length()))
                    .append("   ")
                    .append(mode.getValue().getDescription())
                    .append("\n");
        }
        return main.toString();
    }
}
