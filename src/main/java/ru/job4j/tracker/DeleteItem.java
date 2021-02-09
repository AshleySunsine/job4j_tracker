package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    private final Output out;

    public DeleteItem(Output out) {
        this.out = out;
    }

    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idDelete = input.askInt("Введите id заявки, которую мы будем удалять:");
        if (tracker.delete(idDelete)) {
            out.println("Удаление прошло успешно.");
        } else {
            out.println("Неудачно. Удаление не выполнено.");
            out.println("Элемента с id=" + idDelete + " не существует.");
        }
        return true;
    }
}
