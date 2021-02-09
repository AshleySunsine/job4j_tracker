package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idDelete = input.askInt("Введите id заявки, которую мы будем удалять:");
        if (tracker.delete(idDelete)) {
            System.out.println("Удаление прошло успешно.");
        } else {
            System.out.println("Неудачно. Удаление не выполнено.");
            System.out.println("Элемента с id=" + idDelete + " не существует.");
        }
        return true;
    }
}
