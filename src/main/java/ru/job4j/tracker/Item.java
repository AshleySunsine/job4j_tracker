package ru.job4j.tracker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Item {
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public Item(String name) {
        this.name = name;
    }

    public Item() {
        this.name = "Default name";
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return this.created.format(formatter);
    }

    public static void main(String[] args) {
        Item item = new Item();
    }

    @Override
    public String toString() {
        return "Item{"
                + "id = " + id
                + ", name = '" + name + '\''
                + ", created = " + this.getCreated()
                + '}';
    }
}