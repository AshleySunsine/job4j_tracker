package ru.job4j.tracker;

public class FindItemById implements UserAction {
    public String name() {
        return "=== Find Item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idFind = input.askInt("Введите id заявки, которую мы будем искать:");
        Item itemFind = tracker.findById(idFind);
        if (itemFind != null) {
            System.out.println(itemFind.toString());
        } else {
            System.out.println("Элемента с id= " + idFind + " не существует.");
        }
        return true;
    }
}
