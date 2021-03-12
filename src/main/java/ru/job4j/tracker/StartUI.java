package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Действие: ");
            if (select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        int index = 0;
        out.println("Menu.");

        for (UserAction it : actions) {
            System.out.println(index + ". " + it.name());
            index++;
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = Tracker.getTracker();
        List<UserAction> actions = new ArrayList<UserAction>(Arrays.asList(new CreateAction(output), new ReplaceItem(output),
                new ShowItem(output), new DeleteItem(output),
                new FindItemById(output), new FindItemByName(output), new Exit(output)));

        new StartUI(output).init(input, tracker, actions);
    }
}
