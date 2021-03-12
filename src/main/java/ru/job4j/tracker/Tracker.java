package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public final class Tracker {
    private static Tracker instance = null;
    //private final Item[] items = new Item[100];
    private  List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    private Tracker() {
    }

    public static Tracker getTracker() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String name) {
        List<Item> returnItem = new ArrayList<Item>();
        for (Item it : items) {
            if (it.getName().equals(name)) {
                returnItem.add(it);
            }
        }
        return returnItem;
    }

    public Item findById(int id) {
        for (Item it : items) {
            if (it.getId() == id) {
               return it;
            }
        }
        return null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (Item it : items) {
            rsl++;
            if (it.getId() == id) {
                return rsl;
            }
        }
        return -1;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != (-1)) {
                items.set(index, item);
                return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != (-1)) {
            items.remove(index);
            return true;
        }
        return false;
    }
}