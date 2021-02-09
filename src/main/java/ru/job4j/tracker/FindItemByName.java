package ru.job4j.tracker;

public class FindItemByName implements UserAction {
    private final Output out;

    public FindItemByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find Item by Name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] searchedItem = tracker.findByName(
                input.askStr("Введите ИМЯ заявки, которую мы будем искать:")
        );
        if (searchedItem.length > 0) {
            for (Item i : searchedItem) {
                System.out.println(i.toString());
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}