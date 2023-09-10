package core.view;

import core.control.BasicControl;
import core.control.Control;
import core.data.ToysDistributor;
import core.model.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View implements BasicView {
    private final BasicControl control;


    public View() {
        Mode start = new Lottery();
        Mode setting = new Settings(this);
        Mode exit = new Exit();
        Map<String, Mode> menu = new LinkedHashMap<>();
        menu.put(start.getNameMenu(), start);
        menu.put(setting.getNameMenu(), setting);
        menu.put(exit.getNameMenu(), exit);
        this.control = new Control(new ToysDistributor(), menu);
        start(control, "\nMain menu");
    }

    public View(BasicControl control, String text) {
        this.control = control;
        start(control, text);
    }

    @Override
    public BasicControl getControl() {
        return control;
    }

    @Override
    public void start(BasicControl control, String text) {
        Scanner in = new Scanner(System.in).useDelimiter("\r?\n");
        System.out.println(text);
        System.out.print(control.toString() + "\n");
        while (true) {
            System.out.print(" ->");
            String input = in.next().strip().trim().toLowerCase();
            control.onExecute(input, in);
        }
    }
}
