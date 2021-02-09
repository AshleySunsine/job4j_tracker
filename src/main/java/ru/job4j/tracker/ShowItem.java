package ru.job4j.tracker;

public class ShowItem implements UserAction {
    private final Output out;

    public ShowItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all Items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item everyItem : tracker.findAll()) {
            out.println(everyItem.toString());
        }
        return true;
    }
}
