package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"FixPC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("FixPC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplacedItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId()), "replaced item"};
        StartUI.replaceItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("New item");
        tracker.add(item);
        String[] answer = {String.valueOf(item.getId())};
        StartUI.deleteItem(new StubInput(answer), tracker);
        assertThat(null, is(tracker.findById(item.getId())));
    }
}