package ru.job4j.tracker;

public class ShowItem implements UserAction {
    @Override
    public String name() {
        return "=== Show all Items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item everyItem : tracker.findAll()) {
            System.out.println(everyItem.toString());
        }
        return true;
    }
}
