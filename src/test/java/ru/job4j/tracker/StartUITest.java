package ru.job4j.tracker;

import org.junit.Test;

import java.security.cert.X509Certificate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
    Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenDeleteItem() {
    Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1", "1", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                 new DeleteItem(out), new Exit(out),
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(null, is(tracker.findById(1)));
    }

    @Test
    public void whenReplaceItem() {
    Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1", "1", "FFFFFF", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ReplaceItem(out), new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("FFFFFF"));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1", "Item name", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new FindItemByName(out), new Exit(out),
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                 "Menu." + System.lineSeparator()
                        + "=== Create a new Item ====" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "Item{id = 1, name = 'Item name'}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "Exit" + System.lineSeparator()

        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1", "1", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new FindItemById(out), new Exit(out),
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "=== Create a new Item ====" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "Item{id = 1, name = 'Item name'}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "Exit" + System.lineSeparator()

        ));
    }

    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ShowItem(out), new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "=== Create a new Item ====" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "Item{id = 1, name = 'Item name'}" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input input = new StubInput(
                new String[] {"45", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is(String.format(
                "Menu.%n"
                        + "Wrong input, you can select: 0 .. 0%n"
                        + "Menu.%n"
                        + "Exit%n"
                )
        ));
    }

}