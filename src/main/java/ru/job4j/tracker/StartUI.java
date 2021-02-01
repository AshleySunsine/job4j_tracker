package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("\n=== Edit Item ====");
        int idChange = input.askInt("Введите id заявки, которую мы будем изменять:");
        if (tracker.findById(idChange) != null) {
            Item newItem = new Item();
            newItem.setName(
                    input.askStr("Введите имя заявки на которую мы будем заменять:")
            );
            if (tracker.replace(idChange, newItem)) {
                System.out.println("Замена прошла удачно.");
            } else {
                System.out.println("Неудачно. Замена не выполнена.");
            }
        } else {
            System.out.println("Элемента с id= " + idChange + " не существует.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("\n=== Delete Item ====");
        int idDelete = input.askInt("Введите id заявки, которую мы будем удалять:");
        if (tracker.findById(idDelete) != null) {
            if (tracker.delete(idDelete)) {
                System.out.println("Удаление прошло успешно.");
            } else {
                System.out.println("Неудачно. Удаление не выполнено.");
            }
        } else {
            System.out.println("Элемента с id= " + idDelete + " не существует.");
        }
    }

    public static void showItem(Input input, Tracker tracker) {
        System.out.println("\n=== Show all Items ====");
        for (Item everyItem : tracker.findAll()) {
            System.out.println(everyItem.toString());
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("\n=== Find Item by Id ====");
        int idFind = input.askInt("Введите id заявки, которую мы будем искать:");
        Item itemFind = tracker.findById(idFind);
        if (itemFind != null) {
            System.out.println(itemFind.toString());
        } else {
            System.out.println("Элемента с id= " + idFind + " не существует.");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("\n=== Find Item by Name ====");
        Item[] searchedItem = tracker.findByName(
                input.askStr("Введите ИМЯ заявки, которую мы будем искать:")
        );
        if (searchedItem.length > 0) {
            for (Item i : searchedItem) {
                System.out.println(i.toString());
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            String menuChose = input.askStr("\nДействие: ");
            switch (menuChose) {
                case "0":
                   StartUI.createItem(input, tracker);
                    break;

                case "1":
                    StartUI.showItem(input, tracker);
                    break;
                case "2":
                    StartUI.replaceItem(input, tracker);
                    break;
                case "3":
                    StartUI.deleteItem(input, tracker);
                    break;

                case "4" :
                    StartUI.findItemById(input, tracker);
                    break;
                case "5":
                    StartUI.findItemByName(input, tracker);
                    break;
                case "6":
                    run = false;
                    break;
                default:
                    System.out.println("Введите корректное значение.");
                    break;
            }
        }
    }

    private void showMenu() {
        System.out.println("\nMenu.");
        System.out.println("0. Add new Item"
                + "\n1. Show all items"
                + "\n2. Edit item"
                + "\n3. Delete item"
                + "\n4. Find item by Id"
                + "\n5. Find items by name"
                + "\n6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}