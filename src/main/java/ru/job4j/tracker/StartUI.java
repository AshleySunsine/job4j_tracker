package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("\nДействие: ");
            String menuChose = scanner.nextLine();
            switch (menuChose) {
                case "0":
                    System.out.println("\n=== Create a new Item ====");
                    System.out.println("Введите ИМЯ для нового элемента:");
                    Item item = new Item();
                    String setName = scanner.nextLine();
                    item.setName(setName);
                    if (tracker.add(item) != null) {
                        System.out.println("Элемент " + setName + " добавлен.");
                    }

                    break;

                case "1":
                    System.out.println("\n=== Show all Items ====");
                    for (Item everyItem : tracker.findAll()) {
                        System.out.println(everyItem.toString());
                    }
                    break;
                case "2":
                    System.out.println("\n=== Edit Item ====");
                    System.out.println("Введите id заявки, которую мы будем изменять:");
                    int idChange = Integer.parseInt(scanner.nextLine());
                    if (tracker.findById(idChange) != null) {
                        System.out.println("Введите имя заявки на которую мы будем заменять:");
                        Item newItem = new Item();
                        newItem.setName(scanner.nextLine());
                        if (tracker.replace(idChange, newItem)) {
                            System.out.println("Замена прошла удачно.");
                        } else {
                            System.out.println("Неудачно. Замена не выполнена.");
                        }
                    } else {
                        System.out.println("Элемента с id= " + idChange + " не существует.");
                    }
                    break;
                case "3":
                    System.out.println("\n=== Delete Item ====");
                    System.out.println("Введите id заявки, которую мы будем удалять:");
                    int idDelete = Integer.parseInt(scanner.nextLine());
                    if (tracker.findById(idDelete) != null) {
                        if (tracker.delete(idDelete)) {
                            System.out.println("Удаление прошло успешно.");
                        } else {
                            System.out.println("Неудачно. Удаление не выполнено.");
                        }
                    } else {
                        System.out.println("Элемента с id= " + idDelete + " не существует.");
                    }
                    break;

                case "4" :
                    System.out.println("\n=== Find Item by Id ====");
                    System.out.println("Введите id заявки, которую мы будем искать:");
                    int idFind = Integer.parseInt(scanner.nextLine());
                    Item itemFind = tracker.findById(idFind);
                    if (itemFind != null) {
                        System.out.println(itemFind.toString());
                    } else {
                        System.out.println("Элемента с id= " + idFind + " не существует.");
                    }
                    break;
                case "5":
                    System.out.println("\n=== Find Item by Name ====");
                    System.out.println("Введите ИМЯ заявки, которую мы будем искать:");
                    Item[] searchedItem = tracker.findByName(scanner.nextLine());
                    if (searchedItem.length > 0) {
                        for (Item i : searchedItem) {
                            System.out.println(i.toString());
                        }
                    } else {
                        System.out.println("Заявки с таким именем не найдены");
                    }
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}