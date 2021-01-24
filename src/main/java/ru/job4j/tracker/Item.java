package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Item {
    private int id;
    private String name;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private String created = LocalDateTime.now().format(formatter);

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
        return this.created;
    }

    public static void main(String[] args) {
        Item item = new Item();
    }

    @Override
    public String toString() {
        return "Item{"
                + "id = " + id
                + ", name = '" + name + '\''
                + ", created = " + created
                + '}';
    }
}