package net.igorok;

import net.igorok.controller.Controller;
import net.igorok.model.Model;
import net.igorok.view.View;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        controller.readingInputFile(args);
        controller.showMenu();
    }
}
