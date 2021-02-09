package ru.job4j.tracker;

public class ReplaceItem implements UserAction {
    private final Output out;

    public ReplaceItem(Output out) {
        this.out = out;
    }

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
            out.println("Замена прошла удачно.");
        } else {
            out.println("Неудачно. Удаление не выполнено.");
            out.println("Элемента с id=" + idChange + " не существует.");
        }
        return true;
    }
}
