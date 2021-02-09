package ru.job4j.tracker;

import org.junit.Test;
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
                new ReplaceItem(out), new Exit(out),
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("FFFFFF"));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "\nMenu." + System.lineSeparator()
                      + "Exit" + System.lineSeparator()
        ));
    }

}