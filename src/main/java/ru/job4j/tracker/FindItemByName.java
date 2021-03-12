package ru.job4j.tracker;
import java.util.List;
import java.util.ArrayList;

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
        List<Item> searchedItem = tracker.findByName(
                input.askStr("Введите ИМЯ заявки, которую мы будем искать:")
        );
        if (!searchedItem.isEmpty()) {
            for (Item i : searchedItem) {
                out.println(i.toString());
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
