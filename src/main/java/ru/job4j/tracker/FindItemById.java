package ru.job4j.tracker;

public class FindItemById implements UserAction {
    private final Output out;

    public FindItemById(Output out) {
        this.out = out;
    }

    public String name() {
        return "=== Find Item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idFind = input.askInt("Введите id заявки, которую мы будем искать:");
        Item itemFind = tracker.findById(idFind);
        if (itemFind != null) {
            out.println(itemFind.toString());
        } else {
            out.println("Элемента с id= " + idFind + " не существует.");
        }
        return true;
    }
}
