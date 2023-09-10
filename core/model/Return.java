package core.model;

import core.data.ToysDistributor;
import core.view.BasicView;

import java.util.Scanner;

public class Return extends Settings {

    public Return(BasicView view) {
        super("back", "to back", view);
    }

    @Override
    public void execute(ToysDistributor toys, Scanner scanner) {
        view.start(view.getControl(), "\nMain menu");
    }
}
