package ru.job4j.newtracker;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import org.hamcrest.core.Is;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StartUITest {
    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        ExitStubAction action = new ExitStubAction();
        new StartUI().init(input, new Tracker(), new UserAction[]{action});
        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenCreateItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"qwe"});
        new CreateAction().execute(input, tracker);
        assertThat(tracker.findAll()[0].getName(), is("qwe"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("asd");
        tracker.add(item);
        String id = tracker.findAll()[0].getId();
        String[] answers = {id};
        Input input = new StubInput(answers);
        new DeleteAction().execute(input, tracker);
        Item deletedItem = tracker.findById(id);
        Assert.assertNull(deletedItem);
    }

    @Test
    public void whenItemReplace() {
        Tracker tracker = new Tracker();
        Item item = new Item("qwe");
        tracker.add(item);
        String id = tracker.findAll()[0].getId();
        String[] answers = {id, "asd"};
        new ReplaceAction().execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(id);
        Assert.assertThat(replaced.getName(), Is.is("asd"));
    }

    @Test
    public void whenUserFindItemById() {
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item itemFirst = new Item("qwe");
        tracker.add(itemFirst);
        String id = tracker.findAll()[0].getId();
        String[] answers = {id};
        Input input = new StubInput(answers);
        new FindByIdAction().execute(input, tracker);
        Assert.assertThat(new String(out.toByteArray()),
                Is.is("Имя заявки: " + itemFirst.getName() + "; ID заявки: " + itemFirst.getId() + "\r\n"));
        System.setOut(stdOut);
    }

    }


/*
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenAddTwoItem() {
        String[] answers = {"Fix PC", "Crush PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[1];
        Item expected = new Item("Crush PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {item.getId(), "replaced item"};
        StartUI.replace(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenReplaceItemTwoTime() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {item.getId(), "replaced item", item.getId(), "last item"};
        Input input = new StubInput(answers);
        StartUI.replace(input, tracker);
        StartUI.replace(input, tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("last item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {item.getId()};
        StartUI.delete(new StubInput(answers), tracker);
        assertNull(tracker.findById(item.getId()));
    }
*/
