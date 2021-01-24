package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        /*int length = 0;
        Item[] returnItem = new Item[items.length];
        for (Item item : items) {
          if (item != null) {
              returnItem[length] = item;
              length++;
          }
        }
        return Arrays.copyOf(returnItem, length);*/
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String name) {
        Item[] returnItem = new Item[items.length];
        int length = 0;
        for (Item item : items) {
            if (item.getName().equals(name)) {
                returnItem[length] = item;
                length++;
            }
        }
        return Arrays.copyOf(returnItem, length);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != (-1)) {
            items[index] = item;
            items[index].setId(id);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != (-1)) {
            int start = index + 1;
            int length = size - index;
            System.arraycopy(items, start, items, index, length);
            items[size - 1] = null;
            size--;
            return true;
        }
        return false;
    }
}