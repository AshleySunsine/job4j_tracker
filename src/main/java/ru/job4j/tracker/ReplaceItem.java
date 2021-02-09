package ru.job4j.tracker;

public class ReplaceItem implements UserAction {
    public String name() {
        return "=== Edit Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idChange = input.askInt("Введите id заявки, которую мы будем изменять:");
        Item newItem = new Item();
        if (tracker.replace(idChange, newItem)) {
            newItem.setName(
                    input.askStr("Введите имя заявки на которую мы будем заменять:")
            );
            System.out.println("Замена прошла удачно.");
        } else {
            System.out.println("Неудачно. Удаление не выполнено.");
            System.out.println("Элемента с id=" + idChange + " не существует.");
        }
        return true;
    }
}
