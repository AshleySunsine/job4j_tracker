package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public final class Tracker {
    private static Tracker instance = null;
    private  List<Item> items = new ArrayList<>();
    private int ids = 1;

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
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            rsl++;
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
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